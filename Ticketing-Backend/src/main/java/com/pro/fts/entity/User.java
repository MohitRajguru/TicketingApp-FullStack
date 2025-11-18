package com.pro.fts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//pojo class
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Email
	private String emailId;

	@Size(min = 8)
	@Pattern(regexp = "^[a-zA-Z0-9_]{8,}+$", message = "Invalid user ID")
	private String userId;

	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).*$", message = "Invalid password")
	@Size(min = 8)
	private String password;

// Default Constructor
	public User() {
	}

// constructor using fields
	public User(int id, String emailId, String password, String userId) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userId = userId;
		this.password = password;
	}

// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

}
