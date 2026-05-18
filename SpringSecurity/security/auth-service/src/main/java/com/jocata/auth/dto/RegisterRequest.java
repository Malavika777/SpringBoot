package com.jocata.auth.dto;

/**
 * Register Request DTO
 * 
 * This class represents the user registration request payload.
 * It contains the username, password, and email for new user registration.
 */
public class RegisterRequest {
    private String username;
    private String password;
    private String email;

    // Default constructor
    public RegisterRequest() {}

    // Constructor with parameters
    public RegisterRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
