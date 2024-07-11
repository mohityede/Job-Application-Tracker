package org.themohit.job_application_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
    private String authority;
    @Id
    private String username;
    private String password;
    private boolean isEnabled;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String authority, String username, String password, boolean isEnabled) {
        this.authority = authority;
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "authority='" + authority + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
