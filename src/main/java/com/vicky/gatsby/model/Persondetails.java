package com.vicky.gatsby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Persondetails")
@Component

public class Persondetails {

	@Id
	public String username;
	
	@Column
public String password;
	
	@Column
public String email;
	
	@Column
public String mobile;
	
	@Column
public String status;
	
	@Column
public String role;
	
	@Column
public String address;

	@Column
	public String dateofbirth;
public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
}
