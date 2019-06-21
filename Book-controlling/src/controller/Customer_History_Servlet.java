package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
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


@WebServlet("/Customer_History_Servlet")
public class Customer_History_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
       
	private Book_DBUtil bookDButil;
	private Order_DBUtil orderDButil;
	private Customer_DBUtil cusDButil;
	
	@Resource(name="jdbc/book_controlling")
	private DataSource dtSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
				super.init();
				
				try {
					orderDButil = new Order_DBUtil(dtSource);
					bookDButil = new Book_DBUtil(dtSource);
					cusDButil = new Customer_DBUtil(dtSource);
				}
				catch(Exception exec) {
					throw new ServletException(exec);
				}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if(session == null)
				{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				}
			else
			{
				String name = (String)session.getAttribute("username");
				getUserInfor(request, response,name);
				List<Order_History> TEMPLIST = getOrderInfor(request, response,name);
				List<String> bname = new ArrayList<String>();
				for(int i =0;i<TEMPLIST.size();i++)
					 bname.add(getbookname(TEMPLIST.get(i).getBookID()));
				request.setAttribute("bname", bname);
				RequestDispatcher dispatcher = request.getRequestDispatcher("customer-history.jsp");
				dispatcher.forward(request, response);
			}
			}
			catch (Exception exec) {
				exec.printStackTrace();
			}	
			
		
	}
   
	public String getbookname(int i) throws Exception
	{
		String name = orderDButil.getname(i);
		return name;
	}
	//get Customer Infor
  	public void getUserInfor(HttpServletRequest request, HttpServletResponse response,String Name)
			throws Exception {
  		List<Users> users = cusDButil.getUserInfor(Name);
  				
  		request.setAttribute("cus_infor", users);
  	}
   
  	//get Order Infor
  	public List<Order_History> getOrderInfor(HttpServletRequest request, HttpServletResponse response,String name)
			throws Exception {
  		List<Order_History> history = orderDButil.getHistoryInfor(name);
  				
  		request.setAttribute("history", history);
  		return history;
  	}
  	
  		
}
