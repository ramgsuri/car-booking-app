package com.carbooking.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;

public class LoginDto {

    @UniqueElements
    @NotEmpty(message = "username can not be null")
    private String username;
    private String password;
    private String userType;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
