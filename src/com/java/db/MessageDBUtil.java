package com.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.java.model.Message;
import com.java.model.User;

public class MessageDBUtil {
private DataSource dataSource;
	
	public MessageDBUtil(DataSource dataSource) {
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

	public void getUserMessages(User currentUser,User friend) {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			
			String sql = String.format("SELECT * FROM message where fromUser=? and toUser=? union SELECT * FROM message where fromUser=? and toUser=? order by date;");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, currentUser.getEmail());
			pstmt.setString(2, friend.getEmail());
			pstmt.setString(3, friend.getEmail());
			pstmt.setString(4, currentUser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()) {
				//System.out.println(res.getString("friend"));
			currentUser.messages.add(new Message(res.getString("fromUser"),res.getString("toUser"),res.getString("message"),res.getString("date"),0));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
	}
	

}
