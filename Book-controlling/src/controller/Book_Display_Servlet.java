package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Author;
import model.Author_DBUtil;
import model.Book;
import model.Book_DBUtil;


@WebServlet("/Book_Display_Servlet")
public class Book_Display_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Book_DBUtil bookDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;
   

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		}
		catch (Exception exec) {
			throw new ServletException(exec);
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/book-display.jsp");
		dispatcher.forward(request, response);
	}


	

}
