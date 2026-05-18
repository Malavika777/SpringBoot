package com.jocata.usermgmt.service;

import com.jocata.usermgmt.entity.UserProfile;
import com.jocata.usermgmt.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * User Profile Service
 * 
 * This service handles business logic for user profile operations.
 * It provides methods to manage user profiles and related operations.
 */
@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    /**
     * Create a new user profile
     * @param userProfile the user profile to create
     * @return the created user profile
     */
    public UserProfile createUserProfile(UserProfile userProfile) {
        userProfile.setCreatedAt(LocalDateTime.now());
        userProfile.setActive(true);
        return userProfileRepository.save(userProfile);
    }

    /**
     * Get user profile by ID
     * @param id the user profile ID
     * @return Optional<UserProfile> containing the profile if found
     */
    public Optional<UserProfile> getUserProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    /**
     * Get user profile by username
     * @param username the username
     * @return Optional<UserProfile> containing the profile if found
     */
    public Optional<UserProfile> getUserProfileByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }

    /**
     * Get all user profiles
     * @return List of all user profiles
     */
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    /**
     * Get all active user profiles
     * @return List of active user profiles
     */
    public List<UserProfile> getActiveUserProfiles() {
        return userProfileRepository.findByActiveTrue();
    }

    /**
     * Update user profile
     * @param userProfile the updated user profile
     * @return the updated user profile
     */
    public UserProfile updateUserProfile(UserProfile userProfile) {
        userProfile.setUpdatedAt(LocalDateTime.now());
        return userProfileRepository.save(userProfile);
    }

    /**
     * Delete user profile by ID
     * @param id the user profile ID
     * @return true if deleted, false if not found
     */
    public boolean deleteUserProfile(Long id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Deactivate user profile
     * @param id the user profile ID
     * @return true if deactivated, false if not found
     */
    public boolean deactivateUserProfile(Long id) {
        Optional<UserProfile> userProfile = userProfileRepository.findById(id);
        if (userProfile.isPresent()) {
            UserProfile profile = userProfile.get();
            profile.setActive(false);
            profile.setUpdatedAt(LocalDateTime.now());
            userProfileRepository.save(profile);
            return true;
        }
        return false;
    }

    /**
     * Search user profiles by name
     * @param name the name to search for
     * @return List of matching user profiles
     */
    public List<UserProfile> searchUserProfilesByName(String name) {
        return userProfileRepository.findByNameContaining(name);
    }

    /**
     * Get user profiles by city
     * @param city the city to search for
     * @return List of user profiles in the specified city
     */
    public List<UserProfile> getUserProfilesByCity(String city) {
        return userProfileRepository.findByCity(city);
    }

    /**
     * Get user profiles by country
     * @param country the country to search for
     * @return List of user profiles in the specified country
     */
    public List<UserProfile> getUserProfilesByCountry(String country) {
        return userProfileRepository.findByCountry(country);
    }

    /**
     * Check if user profile exists by username
     * @param username the username to check
     * @return true if exists, false otherwise
     */
    public boolean userProfileExistsByUsername(String username) {
        return userProfileRepository.existsByUsername(username);
    }

    /**
     * Check if user profile exists by email
     * @param email the email to check
     * @return true if exists, false otherwise
     */
    public boolean userProfileExistsByEmail(String email) {
        return userProfileRepository.existsByEmail(email);
    }
}
