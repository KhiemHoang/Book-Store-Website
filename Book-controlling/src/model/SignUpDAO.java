package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SignUpDAO {

	private DataSource dataSource;

	public SignUpDAO(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public int Add(Users user)
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
			try {
			myConn = dataSource.getConnection();
			
			Statement myStmt1 = null;
			ResultSet myRs1 = null;
			int counter =0;
			int condition = 0;
			
			String sql = "select max(UserID) from users";
			myStmt1 = myConn.createStatement();
			
			myRs1 = myStmt1.executeQuery(sql);
			while (myRs1.next()) {
				 counter = myRs1.getInt(1)+1;
			}
			sql = " select count(*) from users where username = '"+user.getUserName()+"'";
			myRs1 = myStmt1.executeQuery(sql);
			while (myRs1.next()) {
				 condition = myRs1.getInt(1);
			}
			
			if (condition > 0 )
			{
				return 0;
			}
			else
			{
			
			sql = "insert into users values (?, ?, ?,?,?,?, ?)";		
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, counter);
			myStmt.setString(2, user.getUserName());
			myStmt.setString(3, user.getUserPassword());
			myStmt.setString(4, user.getUserEmail());
			myStmt.setString(5, user.getUserAddress());
			myStmt.setInt(6, 1);
			myStmt.setString(7,null);

			
			myStmt.execute();
			return 1;
			}
			
			}catch (Exception exc)
			{
				exc.printStackTrace();
			}
			return 0;
		
	}
	
	
}
