package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
  		String URL = request.getQueryString();
		URL= java.net.URLDecoder.decode(URL, StandardCharsets.UTF_8.name());
		String[] parts = URL.split("name=");
		String part2 = parts[1]; 
		System.out.println(part2);
		try {
			getAuthorName(request, response,part2);
			getAuthorDOB(request, response,part2);
			getAuthorNation(request, response,part2);
			getAuthorImg(request, response,part2);
			getAuthorTotal(request, response,part2);
			getBookImg(request, response,part2);
			getBookList(request,response,part2);
		}
		catch (Exception exec) {
			throw new ServletException(exec);
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/author.jsp");
		dispatcher.forward(request, response);
  	}

  	//get Book List
  	public void getBookList(HttpServletRequest request, HttpServletResponse response,String name)
			throws Exception {
  		List<Book> books = bookDButil.getBooks(name);
  				
  		request.setAttribute("BOOK_LIST", books);
  	}
	
	//get Author Name
	public void getAuthorName(HttpServletRequest request, HttpServletResponse response, String n)
			throws Exception {
			
			String authorName = authorDButil.getAuthorName(n);
			
			request.setAttribute("AUTHORS_NAME", authorName);
			
		}

	//get Author DOB
	public void getAuthorDOB(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
			
			Date authorDOB = authorDButil.getAuthorDOB(name);
			
			request.setAttribute("AUTHORS_DOB", authorDOB);
			
		}
	
	//get Author Nationality
	public void getAuthorNation(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
			
			String authorNation = authorDButil.getAuthorNation(name);
			
			request.setAttribute("AUTHORS_NATION", authorNation);
			
		}
	
	//get Author image
	public void getAuthorImg(HttpServletRequest request, HttpServletResponse response, String Name)
			throws Exception {
			
			String authorImg = authorDButil.getAuthorImg(Name);
			
			request.setAttribute("AUTHORS_IMG", authorImg);
			
		}
	
	//get Author Total
	public void getAuthorTotal(HttpServletRequest request, HttpServletResponse response,String name)
			throws Exception {
			
			int authorTotal = authorDButil.getAuthorTotal(name);
			
			request.setAttribute("AUTHORS_TOTAL", authorTotal);
			
		}

	//get book image
	public void getBookImg(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
			
			String bookImg = bookDButil.getBookImg(name);
			
			request.setAttribute("BOOK_IMG", bookImg);
			
		}

}
