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
import com.java.db.UserDBUtil;
import com.java.model.User;

/**
 * Servlet implementation class ViewFriendRequest
 */
@WebServlet("/ViewFriendRequest")
public class ViewFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFriendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/java_project")
    private DataSource dataSource;
    private UserDBUtil userdb;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
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
		System.out.println("friend-request in");
		if(currentUser != null)
		{
		List<User> friendRequest = userdb.getNewFriendRequest(currentUser);
		int friendRequestCount = friendRequest.size();
		for(User u:friendRequest)
		{
		System.out.println(u.getFirstName()+"friend-request in");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewFriendRequest.jsp");
		request.setAttribute("friendRequest", friendRequest);
		request.setAttribute("friendRequestCount", friendRequestCount);
		dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("Login.jsp");
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
