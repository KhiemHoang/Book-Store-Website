package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SearchNameDAO {
	private DataSource dataSource;

	public SearchNameDAO(DataSource theDataSource) {
		dataSource = theDataSource;
		
	}
	
	public List<Book> getbook(String name) throws Exception
	{
		
		List<Book> books = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			 myConn = dataSource.getConnection();
			 String sql = "select * from book where bookname like '%"+name+"%'";
			 System.out.println(sql);
			 myStmt = myConn.createStatement();
			 myRs = myStmt.executeQuery(sql);
			 while(myRs.next())
			 {
				 int id = myRs.getInt("bookid");
				 	String bookname = myRs.getString("bookname");
				 	int bookprice = myRs.getInt("bookprice");
				 	int bookquantity = myRs.getInt("bookquantity");
				 	String booksize = myRs.getString("booksize");
				 	String booktype = myRs.getString("booktype");
				 	String bookImg = myRs.getString("BookImg");
				 	Book tempbook = new Book(id,bookname,bookprice,bookquantity,booksize,booktype,bookImg);
				 	books.add(tempbook);
			 }
		}
		finally	 {
			close(myConn,myStmt,myRs);
		}
		
		
		return books;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null)
			{
				myRs.close();
			}
			if(myStmt != null)
			{
				myStmt.close();
			}
			if(myConn != null)
			{
				myConn.close();
			}
		}catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
	}
	public List<String> getbooktype() throws Exception
	{
		List<String> booktype = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		

		try {
			 myConn = dataSource.getConnection();
			 String sql = "select booktype from book group by booktype order by booktype";
			 myStmt = myConn.createStatement();
			 myRs = myStmt.executeQuery(sql);
			 while(myRs.next())
			 {	 	
				 	String type = myRs.getString("booktype");
				 	booktype.add(type);
			 }
		}
		finally	 {
			close(myConn,myStmt,myRs);
		}
		
		return booktype;
	}
}


