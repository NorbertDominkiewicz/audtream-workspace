package com.audtream.audtreamserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private boolean active;
    private Role role;

    private String profilePicturePath;
    private String bannerPicturePath;

    public User() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public void setBannerPicturePath(String bannerPicturePath) {
        this.bannerPicturePath = bannerPicturePath;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public Role getRole() {
        return role;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public String getBannerPicturePath() {
        return bannerPicturePath;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
