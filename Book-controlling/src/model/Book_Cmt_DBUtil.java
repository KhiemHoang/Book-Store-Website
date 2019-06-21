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
	
	public int getTotalRate(String name) throws Exception{
		int total = new int();
		
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
