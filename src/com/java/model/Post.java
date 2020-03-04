package com.java.model;

import com.mysql.fabric.xmlrpc.base.Array;

public class Post<String> {
	private String post_id;
	private String user_id;
	private String text;
	private String date;
	private String addPost;
	private String deletePost;
	private String readAllPosts;
	private String savePost;
	
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
<<<<<<< HEAD
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
	
	


=======
		this.date = date;
	}
	public Post(String post_id, String user_id, String text, String date) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.text = text;
		this.date = date;
	}
>>>>>>> ecd49fa36f7a79ceef7311874c82def9963da446

}
