package com.java.model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.db.MessageDBUtil;
import com.java.db.PostDBUtil;
import com.java.db.UserDBUtil;

public class User {
	
	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String fname) {
		firstName = fname;
	}
	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lname) {
		lastName = lname;
	}
	private String email;
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String password;
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private List<User> friends = new ArrayList<User>();
	
	public List<User> getFriends() {
		return this.friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	private List<Post> posts = new ArrayList<Post>();
	
	public List<Post> getPosts() {
		return this.posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Message> messages = new ArrayList<Message>();
	
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
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
			if(this.getPassword().equals(founduser.getPassword())) {
				this.firstName = founduser.getFirstName();
				this.lastName = founduser.getLastName();
				this.password = founduser.getPassword();
				this.email = founduser.getEmail();
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public void CreatePost(String text,PostDBUtil postDB) {
		 Date date = new Date();
		 Timestamp t = new Timestamp(date.getTime());
	     long timeMilli = date.getTime();
	     
	     Post newPost = new Post(Long.toString(timeMilli),this.getEmail(),text,t.toString(),0);
	     postDB.createPost(newPost);
		
	}
	public void SavePost(String postId,String text,PostDBUtil postDB) {
		 try {
			postDB.savePost(postId,text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeletePost(String postId,PostDBUtil postDB) {
		postDB.deletePost(postId);
	}
	
	public void doLike(String post_id,PostDBUtil db) {
			System.out.println(post_id+"-like");
			db.like(post_id,this.email);

	}
	public void makeFriend(String friendEmail,String userEmail,UserDBUtil userdb) {
		
		userdb.makeFriend(friendEmail,userEmail);
	}
	public void getUserMessages(User friend ,MessageDBUtil db)
	{
		db.getUserMessages(this,friend);
	}
}
