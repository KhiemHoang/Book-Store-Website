package model;

public class Users {
	int UserId;
	String UserName;
	String UserPassword;
	String UserEmail;
	String UserAddress;
	int UserRole; // 1  = user, 2 = admin
	String UserIMG;
	
	
	
	
	
	public Users(String userName, String userPassword, String userEmail, String userAddress) {
		super();
		UserName = userName;
		UserPassword = userPassword;
		UserEmail = userEmail;
		UserAddress = userAddress;
	}
	public Users(int userId, String userName, String userPassword, String userEmail, String userAddress, int userRole,
			String userIMG) {
		super();
		UserId = userId;
		UserName = userName;
		UserPassword = userPassword;
		UserEmail = userEmail;
		UserAddress = userAddress;
		UserRole = userRole;
		UserIMG = userIMG;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public int getUserRole() {
		return UserRole;
	}
	public void setUserRole(int userRole) {
		UserRole = userRole;
	}
	public String getUserIMG() {
		return UserIMG;
	}
	public void setUserIMG(String userIMG) {
		UserIMG = userIMG;
	}
	
}
