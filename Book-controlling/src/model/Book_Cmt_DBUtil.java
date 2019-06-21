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

public class Book_Cmt_DBUtil {

	private DataSource dataSource;
	
	public Book_Cmt_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	//get List comment
	public List<Book_Cmt> getCmtInfor(String name) throws Exception{
		List<Book_Cmt> cmt = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * "
					+ "FROM book_controlling.book_comment, book_controlling.book"
					+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int CmtID = rss.getInt("CmtID");
				int BookID = rss.getInt("BookID");
				int CusID = rss.getInt("CustomerID");
				String CmtText = rss.getString("CmtText");
				int CmtLike = rss.getInt("CmtLike");
				String CmtDate = rss.getString("CmtDate");
				int RateScore = rss.getInt("RateScore");
				
				Book_Cmt tempAuthor = new Book_Cmt(CmtID, BookID, CusID, CmtText, CmtLike, CmtDate, RateScore);
				cmt.add(tempAuthor);
			}
			
			return cmt;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	//get User comment
	public List<Users> getUserCmt(String name) throws Exception{
		List<Users> users = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * "
					+ "FROM book_controlling.book_comment, book_controlling.users, book_controlling.book"
					+ " where book_controlling.users.UserID = book_controlling.book_comment.CustomerID"
					+ " and book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int ID = rss.getInt("UserID");
				String Name = rss.getString("UserName");
				String Img = rss.getString("UserImg");
				
				Users UserList = new Users(ID, Name, Img);
				
				users.add(UserList);
			}
			
			return users;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	
	//get Total Rate Score
	public int getTotalRate(String name) throws Exception{
		int total = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT sum(book_controlling.book_comment.RateScore) as Total "
					+ "FROM book_controlling.book_comment, book_controlling.book"
					+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				total = rss.getInt("Total");
			}
			
			return total;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	//Count 5 star
	public int getTotalFive(String name) throws Exception{
		int total = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT count(book_controlling.book_comment.RateScore) as Five "
					+ "FROM book_controlling.book_comment, book_controlling.book"
					+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book_comment.RateScore = 5"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				total = rss.getInt("Five");
			}
			
			return total;
		}
		finally {
			close(con, stm, rss);
		}
	}

	//Count 4 star
	public int getTotalFour(String name) throws Exception{
			int total = 0;
			
			Connection con = null;
			Statement stm = null;
			ResultSet rss = null;
			
			try {
				con = dataSource.getConnection();
				
				String sql = "SELECT count(book_controlling.book_comment.RateScore) as Four "
						+ "FROM book_controlling.book_comment, book_controlling.book"
						+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
						+ " and book_controlling.book_comment.RateScore = 4"
						+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
				System.out.println(sql);
				stm = con.createStatement(); //create sql statement
				rss = stm.executeQuery(sql); //exec query
				while(rss.next())
				{
					total = rss.getInt("Four");
				}
				
				return total;
			}
			finally {
				close(con, stm, rss);
			}
		}
	
		
	//Count 3 star
	public int getTotalThree(String name) throws Exception{
					int total = 0;
					
					Connection con = null;
					Statement stm = null;
					ResultSet rss = null;
					
					try {
						con = dataSource.getConnection();
						
						String sql = "SELECT count(book_controlling.book_comment.RateScore) as Three "
								+ "FROM book_controlling.book_comment, book_controlling.book"
								+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
								+ " and book_controlling.book_comment.RateScore = 3"
								+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
						System.out.println(sql);
						stm = con.createStatement(); //create sql statement
						rss = stm.executeQuery(sql); //exec query
						while(rss.next())
						{
							total = rss.getInt("Three");
						}
						
						return total;
					}
					finally {
						close(con, stm, rss);
					}
				}

	//Count 2 star
	public int getTotalTwo(String name) throws Exception{	
		int total = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT count(book_controlling.book_comment.RateScore) as Two "
					+ "FROM book_controlling.book_comment, book_controlling.book"
					+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book_comment.RateScore = 2"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				total = rss.getInt("Two");
			}
			
			return total;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	//Count 1 star
	public int getTotalOne(String name) throws Exception{	
		int total = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT count(book_controlling.book_comment.RateScore) as One "
					+ "FROM book_controlling.book_comment, book_controlling.book"
					+ " where book_controlling.book.bookid = book_controlling.book_comment.BookID"
					+ " and book_controlling.book_comment.RateScore = 1"
					+ " and book_controlling.book.BookName = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				total = rss.getInt("One");
			}
			
			return total;
		}
		finally {
			close(con, stm, rss);
		}
	}	
	
	public void updateLike(int CmtID) throws Exception{
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "Update book_controlling.book_comment"
					+ " set book_controlling.book_comment.CmtLike = book_controlling.book_comment.CmtLike + 1"
					+ " where book_controlling.book_comment.CmtID = " + CmtID + "";
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
}
