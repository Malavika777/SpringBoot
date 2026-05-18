package com.jocata.usermgmt.controller;

import com.jocata.usermgmt.entity.UserProfile;
import com.jocata.usermgmt.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * User Profile Controller
 * 
 * This controller handles HTTP requests for user profile operations.
 * It provides REST endpoints for user profile management.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    /**
     * Create a new user profile
     * @param userProfile the user profile to create
     * @return the created user profile
     */
    @PostMapping
    public ResponseEntity<?> createUserProfile(@RequestBody UserProfile userProfile) {
        try {
            UserProfile createdProfile = userProfileService.createUserProfile(userProfile);
            return ResponseEntity.ok(createdProfile);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("{\"error\":\"Failed to create user profile: " + e.getMessage() + "\"}");
        }
    }

    /**
     * Get user profile by ID
     * @param id the user profile ID
     * @return the user profile if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserProfileById(@PathVariable Long id) {
        Optional<UserProfile> userProfile = userProfileService.getUserProfileById(id);
        if (userProfile.isPresent()) {
            return ResponseEntity.ok(userProfile.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get user profile by username
     * @param username the username
     * @return the user profile if found
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserProfileByUsername(@PathVariable String username) {
        Optional<UserProfile> userProfile = userProfileService.getUserProfileByUsername(username);
        if (userProfile.isPresent()) {
            return ResponseEntity.ok(userProfile.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all user profiles
     * @return List of all user profiles
     */
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    /**
     * Get active user profiles
     * @return List of active user profiles
     */
    @GetMapping("/active")
    public ResponseEntity<List<UserProfile>> getActiveUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getActiveUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    /**
     * Update user profile
     * @param id the user profile ID
     * @param userProfile the updated user profile
     * @return the updated user profile
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
        try {
            Optional<UserProfile> existingProfile = userProfileService.getUserProfileById(id);
            if (existingProfile.isPresent()) {
                userProfile.setId(id);
                UserProfile updatedProfile = userProfileService.updateUserProfile(userProfile);
                return ResponseEntity.ok(updatedProfile);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("{\"error\":\"Failed to update user profile: " + e.getMessage() + "\"}");
        }
    }

    /**
     * Delete user profile
     * @param id the user profile ID
     * @return success message if deleted
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long id) {
        boolean deleted = userProfileService.deleteUserProfile(id);
        if (deleted) {
            return ResponseEntity.ok("{\"message\":\"User profile deleted successfully\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deactivate user profile
     * @param id the user profile ID
     * @return success message if deactivated
     */
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateUserProfile(@PathVariable Long id) {
        boolean deactivated = userProfileService.deactivateUserProfile(id);
        if (deactivated) {
            return ResponseEntity.ok("{\"message\":\"User profile deactivated successfully\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Search user profiles by name
     * @param name the name to search for
     * @return List of matching user profiles
     */
    @GetMapping("/search")
    public ResponseEntity<List<UserProfile>> searchUserProfiles(@RequestParam String name) {
        List<UserProfile> userProfiles = userProfileService.searchUserProfilesByName(name);
        return ResponseEntity.ok(userProfiles);
    }

    /**
     * Get user profiles by city
     * @param city the city to search for
     * @return List of user profiles in the specified city
     */
    @GetMapping("/city/{city}")
    public ResponseEntity<List<UserProfile>> getUserProfilesByCity(@PathVariable String city) {
        List<UserProfile> userProfiles = userProfileService.getUserProfilesByCity(city);
        return ResponseEntity.ok(userProfiles);
    }

    /**
     * Get user profiles by country
     * @param country the country to search for
     * @return List of user profiles in the specified country
     */
    @GetMapping("/country/{country}")
    public ResponseEntity<List<UserProfile>> getUserProfilesByCountry(@PathVariable String country) {
        List<UserProfile> userProfiles = userProfileService.getUserProfilesByCountry(country);
        return ResponseEntity.ok(userProfiles);
    }
}
