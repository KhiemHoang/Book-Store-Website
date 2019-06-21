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

	//get List of Custom Book
	public List<Book> getCustomBooks() throws Exception{
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
				int Book_ID = rss.getInt("BookID");
				String Book_Name = rss.getString("BookName");
				int Book_Price = rss.getInt("BookPrice");
				int Quantity = rss.getInt("BookQuantity");
				String Size = rss.getString("BookSize");
				String Type = rss.getString("BookType");
				String Book_Img1 = rss.getString("BookImgLink1");
				String Book_Img2 = rss.getString("BookImgLink2");
				String Book_Img = rss.getString("BookImg");
				String Book_Link = rss.getString("BookLink");
				
				Book tempAuthor = new Book(Book_ID, Book_Name, Book_Price, Quantity, Size, Type, Book_Img1, Book_Img2, Book_Img, Book_Link);
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
	
	//get All book infor
	public List<Book> getAllInfor(String name) throws Exception{
		List<Book> books = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.book"
					+ " where bookname = '"+name+"'"; //sql query
			System.out.println(sql);
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				String Book_Name = rss.getString("BookName");
				int Book_Price = rss.getInt("BookPrice");
				String Book_Img = rss.getString("BookImg");
				String Book_Img1 = rss.getString("BookImgLink1");
				String Book_Img2 = rss.getString("BookImgLink2");
				String Book_Size = rss.getString("BookSize");
				int Book_SKU = rss.getInt("BookID");
				String Book_Link = rss.getString("BookLink");
				String Book_Type = rss.getString("BookType");
				int Book_Quantity = rss.getInt("BookQuantity");
				
				Book tempAuthor = new Book(Book_SKU, Book_Name, Book_Price, Book_Quantity, Book_Size, Book_Type, Book_Img1, Book_Img2, Book_Img, Book_Link);
				books.add(tempAuthor);
			}
			
			return books;
		}
		finally {
			close(con, stm, rss);
		}
	}

	//get Book'Author
	public String getBookAuthor() throws Exception{
		String bookAuthor = new String();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT book_controlling.author.AuthorName as 'AuthorName' "
					+ "FROM book_controlling.book, book_controlling.author, book_controlling.publish "
					+ "where book_controlling.book.BookID = book_controlling.publish.BookID and "
					+ "book_controlling.publish.AuthorID = book_controlling.author.AuthorID and "
					+ "book_controlling.book.BookID = 1;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				bookAuthor = rss.getString("AuthorName");
			}
			return bookAuthor;
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
