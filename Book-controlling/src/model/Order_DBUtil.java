package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order_DBUtil {

	private DataSource dataSource;
	
	public Order_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	//get Order History
	public List<Order_History> getHistoryInfor(String name) throws Exception{
		
		List<Order_History> history = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT *  FROM book_controlling.order_history, book_controlling.order where book_controlling.order_history.OrderID = book_controlling.order.OrderID and book_controlling.order.CustomerID = (select userid from users where username = '"+name+"')";
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int OrderID = rss.getInt("OrderID");
				int BookID = rss.getInt("BookID");
				int Quantity = rss.getInt("OrderQuantity");
				int Price = rss.getInt("OrderPrice");
				
				Order_History tempAuthor = new Order_History(OrderID, BookID, Quantity, Price);
				history.add(tempAuthor);
			}
			
			return history;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	
	//Close Connection
	private void close(Connection con, Statement stm, ResultSet rss) {
		// TODO Auto-generated method stub
		try {
			if(rss != null) {
				rss.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(con != null) {
				con.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	////
	public String getname(int i) throws Exception{
		String name = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = " select bookname from book where bookid ="+i;
			System.out.println(sql);
			stm = con.createStatement(); 
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				name = rss.getString("bookname");			
			}
			
			return name;
		}
		finally {
			close(con, stm, rss);
		}
		
	}
	
	
}
