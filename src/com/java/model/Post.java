package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
	private String post_id;
	private String user_id;
	private String text;
	private String date;
	
	public String getPost_id()
	{
		return post_id;
	}
	public void setPost_id(String post_id)
	{
		this.post_id = post_id;
	}
	
	public String getUser_id()
	{
		return user_id;
	}
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public void addPost()
	{
		
	}
	public void deletePost()
	{
		
	}
	public void savePost()
	{
		
	}
	public List<String> posts = new ArrayList<String>();
	
	public Post(String post_id, String user_id, String text, String date) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.text = text;
		this.date = date;
	}

}
