package controller;

import java.io.IOException;
import model.*;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/SearchNameServlet")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private SearchNameDAO abc; // search DAO CHANGE PLS
	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public SearchNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new SearchNameDAO(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = request.getQueryString();
		
		URL = URLDecoder.decode(URL);
		String[] parts = URL.split("name=");
		String part2 = parts[1]; 
		try {

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
