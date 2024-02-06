package com.muthupradeesh.mailmanagement.dto;

public class User {
	private String name;
	private String userId;
	private String password;
	private long mobileNumber;
	private String dateOfBirth;

	public User(String name, String userName, String password, long mobileNumber, String dateOfBirth) {
		this.userId = userName;
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
