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

public class Customer_DBUtil {

	private DataSource dataSource;
	
	public Customer_DBUtil (DataSource DTS){
		dataSource = DTS;
	}
	
	//get User Information
	public List<Users> getUserInfor() throws Exception{
		
		List<Users> users = new ArrayList<>();
		
		Connection con = null;
		Statement stm = null;
		ResultSet rss = null;
	
		try {
			con = dataSource.getConnection();
			
			String sql = "SELECT * FROM book_controlling.users"
					+ " where book_controlling.users.UserID =1;"; //sql query
			stm = con.createStatement(); //create sql statement
			rss = stm.executeQuery(sql); //exec query
			while(rss.next())
			{
				int UserID = rss.getInt("UserID");
				String Username = rss.getString("UserName");
				String UserPass = rss.getString("UserPassword");
				String Email = rss.getString("UserEmail");
				String Address = rss.getString("UserAddress");
				int UserRole = rss.getInt("UserRole");
				String UserImg = rss.getString("UserImg");
				
				System.out.println(Username);
				
				Users tempAuthor = new Users(UserID, Username, UserPass, Email, Address, UserRole, UserImg);
				users.add(tempAuthor);
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
