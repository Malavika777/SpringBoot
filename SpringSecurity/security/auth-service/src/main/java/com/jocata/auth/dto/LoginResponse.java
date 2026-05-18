package com.jocata.auth.dto;

/**
 * Login Response DTO
 * 
 * This class represents the login response payload.
 * It contains the JWT token and user information.
 */
public class LoginResponse {
    private String token;
    private String username;
    private String role;

    // Default constructor
    public LoginResponse() {}

    // Constructor with parameters
    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
