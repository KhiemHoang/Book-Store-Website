package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/AccountLogin")
public class AccountLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public AccountLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/plain");
					
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				int counter = 0;
				
				try {
					myConn = dataSource.getConnection();
					
					// Step 3:  Create a SQL statements
					String sql = "select count(*) from users where username ='"+username+"' and userpassword = '"+password+"'";
					myStmt = myConn.createStatement();
					
					// Step 4:  Execute SQL query
					myRs = myStmt.executeQuery(sql);
					
					// Step 5:  Process the result set
					while (myRs.next()) {
						 counter = myRs.getInt(1);
					}
					if(counter == 1)
					{
						  HttpSession session=request.getSession();  
					      session.setAttribute("username",username);
					      RequestDispatcher rd = request.getRequestDispatcher("/IndexServlet");
					      rd.forward(request,response);
					}
					else
					{
						RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/login.jsp");
						
						RequetsDispatcherObj.forward(request, response);


					}
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
				out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
