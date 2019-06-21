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


@WebServlet("/Online_Reading_Servlet")
public class Online_Reading_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Book_DBUtil bookDButil;
	private Publish_DBUtil publishDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;

	
	@Override
	public void init() throws ServletException {
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
			String URL = request.getQueryString();
			URL= java.net.URLDecoder.decode(URL, StandardCharsets.UTF_8.name());
			String[] parts = URL.split("bookid=");
			String part2 = parts[1]; 
			List<Book> temp = bookDButil.getAllInfor2(part2);
			String name = temp.get(0).getBookName();
			System.out.println(name);
			getBookList(request, response,part2);
			getBookAuthor(request, response,part2 );
			getPublishInfor(request, response,name );
			RequestDispatcher dispatcher = request.getRequestDispatcher("/online-reading.jsp");
			dispatcher.forward(request, response);	
		}
		catch (Exception exec) {
			exec.printStackTrace();
		}	
		
		
	}
	
	
	public void getBookList(HttpServletRequest request, HttpServletResponse response, String ID)
		throws Exception {
		List<Book> books = bookDButil.getAllInfor2(ID);
 		request.setAttribute("BOOK_LIST", books);
 	}
	
	
  //get Book Author
  	public void getBookAuthor(HttpServletRequest request, HttpServletResponse response, String ID)
			throws Exception {
  		String Author = bookDButil.getBookAuthor2(ID);
  		request.setAttribute("BOOK_AUTHOR", Author);
  	}

  	//get Publish's infor
  	public void getPublishInfor(HttpServletRequest request, HttpServletResponse response, String name)
			throws Exception {
  		List<Publisher> publish = publishDButil.getAllInfor(name);
  		request.setAttribute("PUBLISH_LIST", publish);
  	}
	
	
}
