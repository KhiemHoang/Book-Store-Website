package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;



public class forgotDAO {

	private DataSource dataSource;

	public forgotDAO(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	public int Find(Users user)
	{
		
		Connection myConn = null;
		try
		{
		myConn = dataSource.getConnection();
		Statement myStmt = null;
		ResultSet myRs = null;
		myStmt = myConn.createStatement();
		String Sql = "select count(*) from users where username='"+user.getUserName()+"' and UserEmail = '"+user.getUserEmail()+"'";
		System.out.println(Sql);
		// Step 4:  Execute SQL query
		myRs = myStmt.executeQuery(Sql);
		while (myRs.next())
		{
			System.out.println("FOUND");
			return 1;
		}	
		}catch (Exception Exc)
		{
			Exc.printStackTrace();
		}
		System.out.println("NOT FOUND");
		return 0;
		
			
			
			
			
		
		
	}
	
	
}

