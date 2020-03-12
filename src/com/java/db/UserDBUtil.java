package com.java.db;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;

import com.java.model.User;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	private DataSource dataSource;
	
	public UserDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	private void close(Connection conn, Statement smt,ResultSet res) {
		try {
			if(res != null) {
				res.close();
			}
			if(smt != null) {
				smt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		catch(Exception exe) {
			exe.printStackTrace();
		}
	}
	public boolean Insert(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		boolean registrationStatus= false;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("INSERT INTO user VALUES('%s','%s','%s','%s')",objuser.getFirstName(),objuser.getLastName(),objuser.getEmail(),objuser.getPassword());
			stm = conn.createStatement();
			if(stm.executeUpdate(sql) == 1)
			{
				registrationStatus = true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		return registrationStatus;
	}
	
	public User findUser(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		User founduser = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("SELECT * FROM user WHERE Email=?");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()) {
			founduser = new User(res.getString("FirstName"),res.getString("LastName"),res.getString("Email"),res.getString("Password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		return founduser;
	}
	
	
	
	public List<User> readUserFriends(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		List<User> friends = new ArrayList<User>();
		try {
			conn = this.dataSource.getConnection();
			System.out.println(objuser.getEmail());
			
			String sql = String.format("SELECT RelatingUserEmail as friend from friends where RelatedUserEmail = ? and status=1 union SELECT RelatedUserEmail as friend from friends where RelatingUserEmail = ? and status=1 ");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, objuser.getEmail());
			pstmt.setString(2, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()) {
				//System.out.println(res.getString("friend"));
			friends.add(findUser(new User(res.getString("friend"),"")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		//for(User u : friends) {
			//System.out.println("helo");
			//System.out.println(u.getFirstName());
		//}
		return friends;
	}
	
	public List<User> readAllFriends(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		List<User> friends = new ArrayList<User>();
		try {
			conn = this.dataSource.getConnection();
			System.out.println(objuser.getEmail());
			
			String sql = String.format("SELECT * FROM user where Email!=?");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, objuser.getEmail());
			//SELECT concat(FirstName,' ',LastName) As friend FROM user 
			res = pstmt.executeQuery();
			while(res.next()) {
				//System.out.println(res.getString("friend"));
			friends.add(findUser(new User(res.getString("Email"),"")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		//for(User u : friends) {
			//System.out.println("helo");
			//System.out.println(u.getFirstName());
		//}
		return friends;
	}


	public void makeFriend(String friendEmail,String userEmail) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("INSERT INTO friends VALUES('%s','%s','%s')",friendEmail,userEmail,0);
			stm = conn.createStatement();
			stm.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
	}


	public List<User> getNewFriendRequest(User currentUser) {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		List<User> friends = new ArrayList<User>();
		try {
			conn = this.dataSource.getConnection();
			
			String sql = String.format("SELECT RelatingUserEmail as friend FROM friends where RelatedUserEmail=? and status=0 ");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, currentUser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()) {
				//System.out.println(res.getString("friend"));
			friends.add(findUser(new User(res.getString("friend"),"")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		//for(User u : friends) {
			//System.out.println("helo");
			//System.out.println(u.getFirstName());
		//}
		return friends;
		
	}


	public void AcceptRequest(String Friendemail,String Useremail) {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("UPDATE friends SET status = 1 WHERE RelatedUserEmail=? and RelatingUserEmail=? ");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, Useremail);
			pstmt.setString(2, Friendemail);
			//System.out.println(pstmt.toString());
			pstmt.executeUpdate();
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		
	}

}
