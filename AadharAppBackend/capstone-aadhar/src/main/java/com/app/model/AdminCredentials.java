package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aId;
	@Column
	private String username;
	@Column
	private String password;
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	public AdminCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AdminCredentials() {
		super();
	}
	
	@Override
	public String toString() {
		return "AdminCredentials [username=" + username + ", password=" + password + "]";
	}

}
