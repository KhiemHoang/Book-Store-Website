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

import model.*;


@WebServlet("/Book_Display_Servlet")
public class Book_Display_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Book_DBUtil bookDButil;
	private Publish_DBUtil publishDButil;
	private IndexDao abc;
	private Book_Cmt_DBUtil BookCmtDBUtil;
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;
   

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			publishDButil = new Publish_DBUtil(dtSource);
			bookDButil = new Book_DBUtil(dtSource);
			BookCmtDBUtil = new Book_Cmt_DBUtil(dtSource);
			abc = new IndexDao(dtSource);
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}
	private void listtype(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<String> type = abc.getbooktype();
		request.setAttribute("booktypes", type);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URL = request.getQueryString();
		URL= java.net.URLDecoder.decode(URL, StandardCharsets.UTF_8.name());
		String[] parts = URL.split("name=");
		String part2 = parts[1]; 
		System.out.println(part2);
		try {
		listtype(request,response);
		getBookList(request, response, part2);
		getBookAuthor(request, response, part2);
		getPublishInfor(request, response, part2);
		getCustomBookList(request, response, part2);
		getCmtList(request, response, part2);
		getUserCmt(request, response, part2);
		}
		catch (Exception exec) {
			exec.printStackTrace();
		}	
		
	RequestDispatcher dispatcher = request.getRequestDispatcher("/book-display.jsp");
	dispatcher.forward(request, response);
	}




	//get Book List
  	public void getBookList(HttpServletRequest request, HttpServletResponse response,String name)
			throws Exception {
  		List<Book> books = bookDButil.getAllInfor(name);
  				
  		request.setAttribute("BOOK_LIST", books);
  	}
	
  	//get Book Author
  	public void getBookAuthor(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
  		String Author = bookDButil.getBookAuthor(name);
  				
  		request.setAttribute("BOOK_AUTHOR", Author);
  	}

  	//get Publish's infor
  	public void getPublishInfor(HttpServletRequest request, HttpServletResponse response,String name)
			throws Exception {
  		List<Publisher> publish = publishDButil.getAllInfor(name);
  				
  		request.setAttribute("PUBLISH_LIST", publish);
  	}

  	//get Custom Book List
  	public void getCustomBookList(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
  		List<Book> books = bookDButil.getCustomBooks(name);
  				
  		request.setAttribute("Custom_Book", books);
  	}
  	
  	//get All cmt
  	public void getCmtList(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
  		List<Book_Cmt> cmt = BookCmtDBUtil.getCmtInfor(name);
  				
  		request.setAttribute("Comment", cmt);
  	}
  	
  	//get User cmt
  	public void getUserCmt(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
  		List<Users> users = BookCmtDBUtil.getUserCmt(name);
  				
  		request.setAttribute("UserList", users);
  	}
}
