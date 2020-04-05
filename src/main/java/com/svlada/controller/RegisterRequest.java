package com.svlada.controller;

public class RegisterRequest {
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
	String username;
	String password;
	public RegisterRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public RegisterRequest() {
		// TODO Auto-generated constructor stub
	}
}
