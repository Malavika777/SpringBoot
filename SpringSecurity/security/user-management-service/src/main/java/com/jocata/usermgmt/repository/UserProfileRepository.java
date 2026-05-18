package com.jocata.usermgmt.repository;

import com.jocata.usermgmt.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * User Profile Repository
 * 
 * This repository handles database operations for UserProfile entities.
 * It provides methods to find users by various criteria.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    
    /**
     * Find user profile by username
     * @param username the username to search for
     * @return Optional<UserProfile> containing the profile if found
     */
    Optional<UserProfile> findByUsername(String username);
    
    /**
     * Find user profile by email
     * @param email the email to search for
     * @return Optional<UserProfile> containing the profile if found
     */
    Optional<UserProfile> findByEmail(String email);
    
    /**
     * Find active user profiles
     * @return List of active user profiles
     */
    List<UserProfile> findByActiveTrue();
    
    /**
     * Find user profiles by city
     * @param city the city to search for
     * @return List of user profiles in the specified city
     */
    List<UserProfile> findByCity(String city);
    
    /**
     * Find user profiles by country
     * @param country the country to search for
     * @return List of user profiles in the specified country
     */
    List<UserProfile> findByCountry(String country);
    
    /**
     * Search user profiles by name (first name or last name)
     * @param name the name to search for
     * @return List of user profiles matching the name
     */
    @Query("SELECT u FROM UserProfile u WHERE u.firstName LIKE %:name% OR u.lastName LIKE %:name%")
    List<UserProfile> findByNameContaining(@Param("name") String name);
    
    /**
     * Check if user profile exists by username
     * @param username the username to check
     * @return true if profile exists, false otherwise
     */
    boolean existsByUsername(String username);
    
    /**
     * Check if user profile exists by email
     * @param email the email to check
     * @return true if profile exists, false otherwise
     */
    boolean existsByEmail(String email);
}
