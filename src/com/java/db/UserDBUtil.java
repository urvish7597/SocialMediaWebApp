package com.java.db;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.java.model.User;
import java.sql.PreparedStatement;

import java.sql.Statement;

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
			while(res.next()){
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

}
