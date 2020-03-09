package com.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.java.model.Post;
import com.java.model.User;

public class PostDBUtil {
private DataSource dataSource;
	
	public PostDBUtil(DataSource dataSource) {
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
	public List<Post> readAllPost(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		List<Post> foundPosts = new ArrayList<Post>();
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("SELECT * FROM posts");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			//pstmt.setString(1, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()){
				foundPosts.add(new Post(res.getString("postID"),res.getString("email"),res.getString("content"),res.getString("date")));	
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		
		return foundPosts;
	}
	public List<Post> readUserPost(User objuser) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		List<Post> foundPosts = new ArrayList<Post>();
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("SELECT * FROM posts WHERE email=?");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()){
				foundPosts.add(new Post(res.getString("postID"),res.getString("email"),res.getString("content"),res.getString("date")));	
            }
			
			/*System.out.println(objuser.getEmail());
			
			for(Post p : foundPosts) {
				System.out.println(p.getPost_id()+"-profile.java");
			}*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stm,res);
		}
		
		return foundPosts;
	}
	
	public void createPost(Post post) {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("INSERT INTO posts VALUES('%s','%s','%s','%s')",post.getPost_id(),post.getUser_id(),post.getText(),post.getDate());
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
	
	public void savePost(String postId,String text) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("UPDATE posts SET content = ? WHERE postID=?");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, text);
			pstmt.setString(2, postId);
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

	public void deletePost(String postId) {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = String.format("DELETE FROM posts WHERE postID=?");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, postId);
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