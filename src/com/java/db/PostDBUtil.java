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
			String sql = String.format("SELECT p.postID,p.email,content,date ,l.counter FROM posts p,(select postID,count(postID) as counter from likes GROUP BY postID) l Where p.postID = l.postID order by date");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			//pstmt.setString(1, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()){
				foundPosts.add(new Post(res.getString("postID"),res.getString("email"),res.getString("content"),res.getString("date"),Integer.parseInt((res.getString("counter")))));	
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
			String sql = String.format("SELECT p.postID,p.email,content,date ,l.counter FROM posts p left join(select postID,count(postID) as counter from likes GROUP BY postID) l on p.postID = l.postID where p.email= ? order by date");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, objuser.getEmail());
			res = pstmt.executeQuery();
			while(res.next()){
				String s= res.getString("counter");
				int t=0;
				if(s!="" && s!=null)
				{
					t = Integer.parseInt(s);
				}
				
				foundPosts.add(new Post(res.getString("postID"),res.getString("email"),res.getString("content"),res.getString("date"),t));	
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
	
	public void like(String post_id,String email) {
		if(!isPostLiked(post_id,email)) {
			doLike(post_id,email);
		}
		else {
			 doUnlike(post_id,email);
		}
	}
	
public void doLike(String post_id,String email) {
		
	Connection conn = null;
	Statement stm = null;
	ResultSet res = null;
	try {
		conn = this.dataSource.getConnection();
		String sql = String.format("INSERT INTO likes VALUES('%s','%s')",post_id,email);
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		//pstmt.setString(1, postId);
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
private boolean isPostLiked(String post_id,String email)
{
	
	Connection conn = null;
	Statement stm = null;
	ResultSet res = null;
	String s="";
	try {
		conn = this.dataSource.getConnection();
		String sql = String.format("SELECT postID from likes WHERE postID=? and email=?");
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, post_id);
		pstmt.setString(2, email);
		res=pstmt.executeQuery();
		while(res.next())
		{
			s=res.getString("postID");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		close(conn,stm,res);
	}

	if(s=="" ) {
		return false;
	}
	else {
		return true;
	}
}
public void doUnlike(String post_id ,String email) {
	
	Connection conn = null;
	Statement stm = null;
	ResultSet res = null;
	try {
		conn = this.dataSource.getConnection();
		String sql = String.format("DELETE FROM likes WHERE postID=? and email=?");
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, post_id);
		pstmt.setString(2, email);
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

public List<Post> readSavedPost(User logeduser) {
	Connection conn = null;
	Statement stm = null;
	ResultSet res = null;
	List<Post> foundPosts = new ArrayList<Post>();
	try {
		conn = this.dataSource.getConnection();
		String sql = String.format("SELECT postID,email,content,date FROM posts where postID in(select postID from savedposts where email=?)");
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, logeduser.getEmail());
		res = pstmt.executeQuery();
		while(res.next()){
			foundPosts.add(new Post(res.getString("postID"),res.getString("email"),res.getString("content"),res.getString("date"),0));	
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
	
	

}