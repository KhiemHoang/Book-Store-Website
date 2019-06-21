package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class UpdatePwdDAO {
private DataSource dataSource;
	
	public UpdatePwdDAO (DataSource DTS){
		dataSource = DTS;
	}
	
	
	
	
	
	
	public void updatepasswd(String n,String m) throws SQLException
	{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		System.out.println(m);
		try {
			 myConn = dataSource.getConnection();
			 String sql = " update users set userpassword ='"+n+"'where username = '"+m+"'";
			 System.out.println(sql);
			 myStmt = myConn.createStatement();
			 myStmt.executeUpdate(sql);
			 
		}
		finally	 {
			close(myConn,myStmt,myRs);
		}
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
}
