package com.java.severlate;

import com.java.db.PostDBUtil;
import com.java.db.UserDBUtil;
import com.java.model.Post;
import com.java.model.User;

/**
 * Servlet implementation class Friends
 */
@WebServlet("/Friends")
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friends() {
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
		try {
			
			}
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
