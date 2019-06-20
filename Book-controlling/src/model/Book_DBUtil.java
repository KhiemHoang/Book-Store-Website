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

public class Book_DBUtil {
	
	private DataSource dataSource;
	
	public Book_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	//get List book (Name, Price, Img)
	public List<Book> getBooks() throws Exception{
		
		List<Book> books = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.book, book_controlling.publish, book_controlling.author"
					+ " where book_controlling.book.BookID = book_controlling.publish.BookID "
					+ " and book_controlling.publish.AuthorID = book_controlling.author.AuthorID"
					+ " and book_controlling.author.AuthorID =2;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				String Book_Name = rss.getString("BookName");
				int Book_Price = rss.getInt("BookPrice");
				String Book_Img = rss.getString("BookImg");
				
				Book tempAuthor = new Book(Book_Name, Book_Price, Book_Img);
				books.add(tempAuthor);
			}
			
			return books;
		}
		finally {
			close(con, stm, rss);
		}
	}

	//get List best seller book (Name, Img)
	public List<Book> getBestSeller() throws Exception{
		List<Book> books = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.book LIMIT 4;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				String Book_Name = rss.getString("BookName");
				String Book_Img = rss.getString("BookImg");
				
				Book tempAuthor = new Book(Book_Name, Book_Img);
				books.add(tempAuthor);
			}
			
			return books;
		}
		finally {
			close(con, stm, rss);
		}
	}
	
	//get List of Action grene book(Name, Price, Img)
	public List<Book> getActionBooks() throws Exception{
		
		List<Book> books = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.book where book_controlling.book.BookType like '%Action%' LIMIT 4;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				String Book_Name = rss.getString("BookName");
				int Book_Price = rss.getInt("BookPrice");
				String Book_Img = rss.getString("BookImg");
				
				Book tempAuthor = new Book(Book_Name, Book_Price, Book_Img);
				books.add(tempAuthor);
			}
			
			return books;
		}
		finally {
			close(con, stm, rss);
		}
	}

	//get List of Adventure grene book(Name, Price, Img)
		public List<Book> getAdventureBooks() throws Exception{
			
			List<Book> books = new ArrayList<>();
			
			Connection con = null;
			Statement stm = null;
			ResultSet rss = null;
		
			try {
				con = dataSource.getConnection();
				
				String sql = "SELECT * FROM book_controlling.book where book_controlling.book.BookType like '%Adventure%' LIMIT 4;"; //sql query
				stm = con.createStatement(); //create sql statement
				rss = stm.executeQuery(sql); //exec query
				while(rss.next())
				{
					String Book_Name = rss.getString("BookName");
					int Book_Price = rss.getInt("BookPrice");
					String Book_Img = rss.getString("BookImg");
					
					Book tempAuthor = new Book(Book_Name, Book_Price, Book_Img);
					books.add(tempAuthor);
				}
				
				return books;
			}
			finally {
				close(con, stm, rss);
			}
		}
	
	//get book cover img
	public String getBookImg() throws Exception{
		String bookImg = new String();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT book_controlling.book.BookImg as 'BookImg'"
					+ "FROM book_controlling.book, book_controlling.author, book_controlling.publish "
					+ "where book_controlling.book.BookID = book_controlling.publish.BookID and "
					+ "book_controlling.publish.AuthorID = book_controlling.author.AuthorID and "
					+ "book_controlling.author.AuthorID = 1;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				bookImg = rss.getString("BookImg");
			}
			return bookImg;
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
