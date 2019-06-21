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

import model.*;


@WebServlet("/Book_Display_Servlet")
public class Book_Display_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Book_DBUtil bookDButil;
	private Publish_DBUtil publishDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;
   

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			publishDButil = new Publish_DBUtil(dtSource);
			bookDButil = new Book_DBUtil(dtSource);
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		getBookList(request, response);
		getBookAuthor(request, response);
		getPublishInfor(request, response);
		getCustomBookList(request, response);
		}
		catch (Exception exec) {
			exec.printStackTrace();
		}	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/book-display.jsp");
	dispatcher.forward(request, response);
	}




	//get Book List
  	public void getBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getAllInfor();
  				
  		request.setAttribute("BOOK_LIST", books);
  	}
	
  	//get Book Author
  	public void getBookAuthor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		String Author = bookDButil.getBookAuthor();
  				
  		request.setAttribute("BOOK_AUTHOR", Author);
  	}

  	//get Publish's infor
  	public void getPublishInfor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Publisher> publish = publishDButil.getAllInfor();
  				
  		request.setAttribute("PUBLISH_LIST", publish);
  	}

  	//get Custom Book List
  	public void getCustomBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getCustomBooks();
  				
  		request.setAttribute("Custom_Book", books);
  	}
}
