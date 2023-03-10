package com.batch2.onlineshopping.entity;

public class LoginResponse {

	private String username;
	private String accessToken;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public LoginResponse(String username, String accessToken) {
		super();
		this.username = username;
		this.accessToken = accessToken;
	}

	public LoginResponse() {
		super();
	}

}
