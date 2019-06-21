package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class buycart
 */
@WebServlet("/buycart")
public class buycart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Order_DBUtil abc;
	@Resource(name="jdbc/book_controlling")
	private DataSource dataSource;
    public buycart() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
		super.init();
		
		try {
			abc = new Order_DBUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> cartlist = new ArrayList<String>();
		HttpSession session=request.getSession(false);  
		cartlist = (List<String>) session.getAttribute("cartlist");
		String username = (String)session.getAttribute("username");
		String link = "/profile?name="+username;
		try {
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			Order theorder = new Order(abc.getmaxid(),abc.getcusid(username),date.toString());
			int orderid = abc.insert(theorder);
			for (int i = 0;i<cartlist.size();i++)
			{
				int bid = abc.getbid(cartlist.get(i));
				abc.insert2(orderid, bid);
				cartlist.clear();
				session.setAttribute("cartlist",cartlist);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher(link);
		RequetsDispatcherObj.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
