package com.jocata.auth.controller;

import com.jocata.auth.dto.LoginRequest;
import com.jocata.auth.dto.LoginResponse;
import com.jocata.auth.dto.RegisterRequest;
import com.jocata.auth.entity.User;
import com.jocata.auth.repository.UserRepository;
import com.jocata.auth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Authentication Controller
 * 
 * This controller handles authentication-related endpoints.
 * It provides login, registration, and token validation functionality.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    /**
     * User login endpoint
     * @param loginRequest the login credentials
     * @return JWT token if login successful
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Find user by username
            Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
            
            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("{\"error\":\"Invalid username or password\"}");
            }

            User user = userOptional.get();
            
            // Validate password
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.badRequest()
                    .body("{\"error\":\"Invalid username or password\"}");
            }

            // Generate JWT token
            String token = jwtService.generateToken(user.getUsername(), user.getRole());
            
            LoginResponse response = new LoginResponse(token, user.getUsername(), user.getRole());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("{\"error\":\"Login failed: " + e.getMessage() + "\"}");
        }
    }

    /**
     * User registration endpoint
     * @param registerRequest the registration details
     * @return success message if registration successful
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            // Check if username already exists
            if (userRepository.existsByUsername(registerRequest.getUsername())) {
                return ResponseEntity.badRequest()
                    .body("{\"error\":\"Username already exists\"}");
            }

            // Check if email already exists
            if (userRepository.existsByEmail(registerRequest.getEmail())) {
                return ResponseEntity.badRequest()
                    .body("{\"error\":\"Email already exists\"}");
            }

            // Create new user
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setEmail(registerRequest.getEmail());
            user.setRole("USER");
            user.setEnabled(true);

            userRepository.save(user);

            return ResponseEntity.ok("{\"message\":\"User registered successfully\"}");
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("{\"error\":\"Registration failed: " + e.getMessage() + "\"}");
        }
    }

    /**
     * Validate JWT token
     * @param token the JWT token to validate
     * @return validation result
     */
    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        try {
            String username = jwtService.extractUsername(token);
            Optional<User> userOptional = userRepository.findByUsername(username);
            
            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("{\"valid\":false,\"error\":\"User not found\"}");
            }

            boolean isValid = jwtService.validateToken(token, username);
            
            if (isValid) {
                User user = userOptional.get();
                return ResponseEntity.ok("{\"valid\":true,\"username\":\"" + user.getUsername() + 
                    "\",\"role\":\"" + user.getRole() + "\"}");
            } else {
                return ResponseEntity.badRequest()
                    .body("{\"valid\":false,\"error\":\"Invalid token\"}");
            }
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("{\"valid\":false,\"error\":\"Token validation failed: " + e.getMessage() + "\"}");
        }
    }
}
