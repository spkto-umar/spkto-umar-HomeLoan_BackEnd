package com.homeloan.entity;

import javax.persistence.*;

@Entity
@Table(name="Admin_Table")
public class Admin 
{

	@Id
	private int adminId;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String username, String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return " /n Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
	}	
}
