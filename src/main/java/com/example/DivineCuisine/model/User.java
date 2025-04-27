package com.example.DivineCuisine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String address;
    private String password;

    // Default constructor (protected for JPA)
    protected User(){}

    // Private constructor for builder pattern
    private User(UserBuilder builder) {
        this.fullname = builder.fullname;
        this.email = builder.email;
        this.address = builder.address;
        this.password = builder.password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Static builder method
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    // Static nested builder class
    public static class UserBuilder {
        private String fullname;
        private String email;
        private String address;
        private String password;

        // Setters for each field in the builder
        public UserBuilder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        // Build method to return a new User instance
        public User build() {
            return new User(this);
        }
    }
}
