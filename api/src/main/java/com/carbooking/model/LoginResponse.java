package com.carbooking.model;

public class LoginResponse {

	private String username;
	private String userType;
	
	public LoginResponse(String username, String userType) {
		this.username = username;
		this.userType = userType;
	}
	public String getUsername() {
		return username;
	}
	public String getUserType() {
		return userType;
	}
	
}
