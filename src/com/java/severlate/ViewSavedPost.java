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
import com.java.model.Post;
import com.java.model.User;

/**
 * Servlet implementation class ViewSavedPost
 */
@WebServlet("/ViewSavedPost")
public class ViewSavedPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSavedPost() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/java_project")
    private DataSource dataSource;
    private PostDBUtil postdb;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			postdb = new PostDBUtil(dataSource);
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
		 HttpSession session=request.getSession();  
			User logeduser =(User)(session.getAttribute("user"));
			if(logeduser != null)
			{
			try {
				List<Post> savedposts = postdb.readSavedPost(logeduser);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewSavedPosts.jsp");
				request.setAttribute("posts", savedposts);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
