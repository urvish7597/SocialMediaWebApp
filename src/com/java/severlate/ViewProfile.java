package com.java.severlate;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.java.db.PostDBUtil;
import com.java.db.UserDBUtil;
import com.java.model.Post;
import com.java.model.User;

/**
 * Servlet implementation class ViewProfile
 */
@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/java_project")
    private DataSource dataSource;
    private PostDBUtil postdb;
    private UserDBUtil userdb;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			postdb = new PostDBUtil(dataSource);
			userdb = new UserDBUtil(dataSource);
		}
		catch(Exception ex) {
			throw new ServletException(ex);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		User friend = new User(request.getParameter("friendemail"),"");
		try {
			List<Post> posts = postdb.readUserPost(friend);
			List<User> friends = userdb.readUserFriends(friend);
			friend.setFriends(friends);
			friend.setPosts(posts);
			String isFriend = "Add Friend";
			for(User user :friends) {
				if((user.getEmail()).equals(currentUser.getEmail())) {
					isFriend = "";
					break;
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewProfile.jsp");
			request.setAttribute("isFriend", isFriend);
			request.setAttribute("loggedUser", friend);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
