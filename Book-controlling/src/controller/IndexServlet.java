package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import model.*;




@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private IndexDao abc;
	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public IndexServlet() {
        super();
    }
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new IndexDao(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		
		try {
			listbook(request,response);
			listtype(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		 	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/Index.jsp");
		 	RequetsDispatcherObj.forward(request, response);
	}
	private void listbook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List <Book> books = abc.getbook();
		request.setAttribute("booklist", books);
		request.setAttribute("numberofitem",books.size());	
	}
	private void listtype(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<String> type = abc.getbooktype();
		request.setAttribute("booktypes", type);
	}
	


}
