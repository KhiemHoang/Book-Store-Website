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


@WebServlet("/Author_Servlet")
public class Author_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Author_DBUtil authorDButil;
	private Book_DBUtil bookDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;
		
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			authorDButil = new Author_DBUtil(dtSource);
			bookDButil = new Book_DBUtil(dtSource);
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}


	//doGet Method
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			getAuthorName(request, response);
			getAuthorDOB(request, response);
			getAuthorNation(request, response);
			getAuthorImg(request, response);
			getAuthorTotal(request, response);
			getBookImg(request, response);
			getBookList(request,response);
		}
		catch (Exception exec) {
			throw new ServletException(exec);
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/author.jsp");
		dispatcher.forward(request, response);
  	}

  	//get Book List
  	public void getBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getBooks();
  				
  		request.setAttribute("BOOK_LIST", books);
  	}
	
	//get Author Name
	public void getAuthorName(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String authorName = authorDButil.getAuthorName();
			
			request.setAttribute("AUTHORS_NAME", authorName);
			
		}

	//get Author DOB
	public void getAuthorDOB(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			Date authorDOB = authorDButil.getAuthorDOB();
			
			request.setAttribute("AUTHORS_DOB", authorDOB);
			
		}
	
	//get Author Nationality
	public void getAuthorNation(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String authorNation = authorDButil.getAuthorNation();
			
			request.setAttribute("AUTHORS_NATION", authorNation);
			
		}
	
	//get Author image
	public void getAuthorImg(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String authorImg = authorDButil.getAuthorImg();
			
			request.setAttribute("AUTHORS_IMG", authorImg);
			
		}
	
	//get Author Total
	public void getAuthorTotal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			int authorTotal = authorDButil.getAuthorTotal();
			
			request.setAttribute("AUTHORS_TOTAL", authorTotal);
			
		}

	//get book image
	public void getBookImg(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String bookImg = bookDButil.getBookImg();
			
			request.setAttribute("BOOK_IMG", bookImg);
			
		}

}
