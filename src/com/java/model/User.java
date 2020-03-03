package com.java.model;

import java.util.ArrayList;
import java.util.List;

import com.java.db.UserDBUtil;

public class User {
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fname) {
		firstName = fname;
	}
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lname) {
		lastName = lname;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> friends = new ArrayList<String>();
	public List<String> posts = new ArrayList<String>();
	public List<String> messages = new ArrayList<String>();
	
	public boolean Register(UserDBUtil db) {
		boolean registrationStatus =false;
		try {
			registrationStatus = db.Insert(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationStatus;
	}
	
	public boolean Login(UserDBUtil db) {
		User founduser = null;
		try {
			founduser = db.findUser(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(founduser != null) {
			if(this.getPassword() == founduser.getPassword()) {
				this.firstName = founduser.getFirstName();
				this.lastName = founduser.getLastName();
				this.password = founduser.getPassword();
				this.email = founduser.getPassword();
			}
			else {
				return false;
			}
		}
		return false;
	}

}
