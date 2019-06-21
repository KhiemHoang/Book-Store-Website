package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public int getmaxid() throws SQLException
	{	
		int id = 0;
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = " SELECT max(orderid) FROM book_controlling.order ";
			stm = con.createStatement(); 
			rss = stm.executeQuery(sql); 
			while(rss.next())
			{
				id = rss.getInt(1)+1;	
				System.out.println(id);
			}
			
			return id;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	public int getcusid(String name) throws SQLException
	{
		int id = 0;
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = " select userid from users where username = '"+name+"'"; 
			stm = con.createStatement(); 
			rss = stm.executeQuery(sql); 
			while(rss.next())
			{
				id = rss.getInt(1);	
				System.out.println(id);
			}
			
			return id;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	public int insert(Order order) throws SQLException
	{
		Connection con = null;
		PreparedStatement myStmt = null;
		ResultSet rss = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO book_controlling.order VALUES (?, ?, ?)";

			myStmt = con.prepareStatement(sql);
			myStmt.setInt(1, order.getOrderID());
			
			myStmt.setInt(2, order.getCustomerID());
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			myStmt.setTimestamp(3, date);
			myStmt.execute();
			return order.getOrderID();
		}
		finally {
			close(con, myStmt, rss);
		}		
	}

	public int getbid(String name) throws SQLException
	{
		Connection myConn = null;
		Statement myStmt1 = null;
		ResultSet myRs1 = null;

		int bid = 0;
		try {
			myConn = dataSource.getConnection();

			String sql = "select bookid from book where bookname ='"+ name+"'";
			System.out.println(sql);
			myStmt1 = myConn.createStatement();
			
			myRs1 = myStmt1.executeQuery(sql);
			while (myRs1.next()) {
				 bid = myRs1.getInt(1);
			}
			return bid;
		}
		finally {
			close(myConn, myStmt1, myRs1);
		}		
	}
	
	public void insert2(int orderid, int bookid) throws SQLException
	{
		Connection con = null;
		PreparedStatement myStmt = null;
		ResultSet rss = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO book_controlling.order_history VALUES (?, ?, ?, ?)";

			myStmt = con.prepareStatement(sql);
			myStmt.setInt(1, orderid);
			
			myStmt.setInt(2, bookid);
			
			
			myStmt.setInt(3, 1);
			myStmt.setInt(4, 100000);
			myStmt.execute();
		}
		finally {
			close(con, myStmt, rss);
		}		
	}
}
