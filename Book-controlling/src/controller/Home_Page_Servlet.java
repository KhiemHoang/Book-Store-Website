package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
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


@WebServlet("/Home_Page")
public class Home_Page_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Author_DBUtil authorDButil;
	private Book_DBUtil bookDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			authorDButil = new Author_DBUtil(dtSource);
			bookDButil = new Book_DBUtil(dtSource);
		}
		catch(Exception exec) {
			throw new ServletException(exec);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			getBestSellerBookList(request, response);
			getActionBookList(request, response);
			getAdventureBookList(request, response);
		}
		catch (Exception exec) {
			throw new ServletException(exec);
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home-page.jsp");
		dispatcher.forward(request, response);
  	}

	//get Book List
  	public void getBestSellerBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getBestSeller();
  				
  		request.setAttribute("BEST_SELL_LIST", books);
  	}

  	//get Action Grene Book List
  	public void getActionBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getActionBooks();
  				
  		request.setAttribute("ACTION_LIST", books);
  	}
  	
  //get Adventure Grene Book List
  	public void getAdventureBookList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Book> books = bookDButil.getAdventureBooks();
  				
  		request.setAttribute("ADVENTURE_LIST", books);
  	}
}
