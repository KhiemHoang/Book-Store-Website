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
			getUserInfor(request, response);
			getOrderInfor(request, response);
			}
			catch (Exception exec) {
				exec.printStackTrace();
			}	
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer-history.jsp");
		dispatcher.forward(request, response);
	}
   

	//get Customer Infor
  	public void getUserInfor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Users> users = cusDButil.getUserInfor();
  				
  		request.setAttribute("cus_infor", users);
  	}
   
  	//get Order Infor
  	public void getOrderInfor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
  		List<Order_History> history = orderDButil.getHistoryInfor();
  				
  		request.setAttribute("history", history);
  	}
}
