package controller;

import java.io.IOException;
import model.*;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/categoryservlet")
public class categoryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private SearchTypeDAO abc; // search DAO CHANGE PLS
	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
       

    public categoryservlet() {
        super();
    }
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new SearchTypeDAO(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String URL = request.getQueryString();
			String[] parts = URL.split("type=");
			String part2 = parts[1]; 
			System.out.println(part2);
			listbook(request,response,part2);
			listtype(request,response);
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/BookTypeQuery.jsp");
		 	RequetsDispatcherObj.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void listbook(HttpServletRequest request, HttpServletResponse response, String m) throws Exception {
		List <Book> books = abc.getbook(m);

		request.setAttribute("booklist", books);
		request.setAttribute("numberofitem",books.size());	 
		

	}
	private void listtype(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<String> type = abc.getbooktype();
		request.setAttribute("booktypes", type);
	}
	

}
