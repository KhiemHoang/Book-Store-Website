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

public class Author_DBUtil {
	
	private DataSource dataSource;
	
	public Author_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	
	//List Author
	public List<Author> getAuthors() throws Exception{
		
		List<Author> authors = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.author;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int Author_ID = rss.getInt("AuthorID");
				String Author_Name = rss.getString("AuthorName");
				String Author_DOB = rss.getString("AuthorDOB");
				String Author_Nationality = rss.getString("AuthorNationality");
				String Author_Img = rss.getString("AuthorImg");
				
				Author tempAuthor = new Author(Author_ID, Author_Name, Author_DOB, Author_Nationality, Author_Img);
				authors.add(tempAuthor);
			}
			
			return authors;
		}
		finally {
			close(con, stm, rss);
		}
	}

	//Get Author Name
	public String getAuthorName(String name) throws Exception{
		String authorName = new String();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT AuthorName FROM book_controlling.author where AuthorName = '"+name+"'"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				authorName = rss.getString("AuthorName");
			}
			return authorName;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	
	//Get Author DOB 
	public Date getAuthorDOB(String name) throws Exception{
		
		Date authorDOB = new Date();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT AuthorDOB FROM book_controlling.author where AuthorName = '"+name+"'"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				authorDOB = rss.getDate("AuthorDOB");
			}
			return authorDOB;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	
	//get Author Nationality
	public String getAuthorNation(String Name) throws Exception{
		String authorNation = new String();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT AuthorNationality FROM book_controlling.author where AuthorName ='"+Name+"'"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				authorNation = rss.getString("AuthorNationality");
			}
			return authorNation;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	
	//get Author total Book
	public int getAuthorTotal(String name) throws Exception{
		int authorTotal = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "Select count(book_controlling.publish.BookID) as 'Total' "
					+ "FROM book_controlling.author, book_controlling.publish "
					+ "where book_controlling.author.AuthorID = book_controlling.publish.AuthorID "
					+ "and book_controlling.author.authorname = '"+name+"'"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				authorTotal = rss.getInt("Total");
			}
			return authorTotal;
		}
		finally {
			close(con, stm, rss);
		}		
	}
	
	//get Author Image
	public String getAuthorImg(String Name) throws Exception{
		String authorImg = new String();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT AuthorImg FROM book_controlling.author where AuthorName = '"+Name+"'"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			
			while(rss.next())
			{
				authorImg = rss.getString("AuthorImg");
			}
			return authorImg;
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
