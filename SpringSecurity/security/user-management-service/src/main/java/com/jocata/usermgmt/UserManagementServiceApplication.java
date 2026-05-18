package com.jocata.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * User Management Service
 * 
 * This service handles user data management and operations.
 * It provides CRUD operations for user profiles and information.
 * 
 * Key Features:
 * - User Profile Management: Create, read, update, delete user profiles
 * - User Data Operations: Handle user information and preferences
 * - User Search: Find users by various criteria
 * - User Statistics: Provide user analytics and statistics
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}

}
