package com.java.model;

public class FriendsList
{
	
	private boolean status;
    private String RelatingUserEmail;
    private String RelatedUserEmail;
    
    
    public Array<String> list = new ArrayList<String>();
    
    public boolean getStatus()
	{
		return this.status;
	}
	
	public void setStatus(boolean status)
	{
		this.status=status;
	}
	
	public String getRelatingUserEmail()
	{
		return this.RelatingUserEmail;
	}
	
	public void setRelatingUserEmail(String RelatingUserEmail)
	{
		this.RelatingUserEmail=RelatingUserEmail;
	}
	
	public String getRelatedUserEmail()
	{
		return this.RelatedUserEmail;
	}
	
	public void setRelatedUserEmail(String RelatedUserEmail)
	{
		this.RelatedUserEmail=RelatedUserEmail;
	}
    
	private List<User> friends = new ArrayList<User>();
	
	
    public List<User> getFriends() 
    {
		return this.friends;
	}
	
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	
	public FriendsList(boolean status, String RalatingUserEmail, String RelatedUserEmail) 
	{
		
		this.status=status;
		this.RelatingUserEmail=RelatingUserEmail;
		this.RelatedUserEmail=RelatedUserEmail;
	}
	
    public void addFriend()
    {   
        
    }
    
    public void removeFriend()
    {
        
    }

}

