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

public class Publish_DBUtil {

	private DataSource dataSource;
	
	public Publish_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	
	//get Publish Info
	public List<Publisher> getAllInfor(String name) throws Exception{
		List<Publisher> publish = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			String sql = "select * from publish, book where publish.bookid = book.bookid and bookname ='" +name+"'";
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int AuthorID = rss.getInt("BookID");
				int BookID = rss.getInt("BookID");
				String Realease = rss.getString("RealeaseDate");
				String Company = rss.getString("PublisherName");
				
				Publisher tempAuthor = new Publisher(AuthorID, BookID, Realease, Company);
				publish.add(tempAuthor);
			}
			
			return publish;
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
