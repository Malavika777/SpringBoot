package com.example.user.controller;

import com.example.user.entity.UserProfile;
import com.example.user.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getUserProfile(Authentication authentication) {
        String username = authentication.getName();
        Optional<UserProfile> profile = userProfileRepository.findByUsername(username);
        
        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/profile")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile, 
                                                        Authentication authentication) {
        userProfile.setUsername(authentication.getName());
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return ResponseEntity.ok(savedProfile);
    }
    
    @PutMapping("/profile")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile,
                                                        Authentication authentication) {
        String username = authentication.getName();
        Optional<UserProfile> existingProfile = userProfileRepository.findByUsername(username);
        
        if (existingProfile.isPresent()) {
            UserProfile profile = existingProfile.get();
            profile.setFirstName(userProfile.getFirstName());
            profile.setLastName(userProfile.getLastName());
            profile.setEmail(userProfile.getEmail());
            profile.setPhone(userProfile.getPhone());
            profile.setAddress(userProfile.getAddress());
            
            UserProfile updatedProfile = userProfileRepository.save(profile);
            return ResponseEntity.ok(updatedProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<UserProfile>> getAllUsers(Authentication authentication) {
        // Check if user has ADMIN role
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        
        if (isAdmin) {
            List<UserProfile> users = userProfileRepository.findAll();
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.forbidden().build();
        }
    }
}
