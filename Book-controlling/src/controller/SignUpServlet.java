package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.*;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private SignUpDAO abc;
	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public SignUpServlet() {
        super();
    }
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new SignUpDAO(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String passwords = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Users theuser = new Users(username,passwords,email,address);
		if (abc.Add(theuser) == 0)
		{
			System.out.println("FAIL");
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/SignUp.jsp");
		 	RequetsDispatcherObj.forward(request, response);
		}
		else
		{
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/login.jsp");
		 	RequetsDispatcherObj.forward(request, response);
			System.out.println("Success");


		}
	}

}
