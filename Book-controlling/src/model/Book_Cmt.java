package model;

public class Book_Cmt {
	private int CmtID;
	private int BookID;
	private int CustomerID;
	private String CmtText;
	private int CmtLike;
	private String CmtDate;
	private int RateScore;
	public Book_Cmt(int cmtID, int bookID, int customerID, String cmtText, int cmtLike, String cmtDate, int rateScore) {
		super();
		CmtID = cmtID;
		BookID = bookID;
		CustomerID = customerID;
		CmtText = cmtText;
		CmtLike = cmtLike;
		CmtDate = cmtDate;
		RateScore = rateScore;
	}
	public int getCmtID() {
		return CmtID;
	}
	public void setCmtID(int cmtID) {
		CmtID = cmtID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCmtText() {
		return CmtText;
	}
	public void setCmtText(String cmtText) {
		CmtText = cmtText;
	}
	public int getCmtLike() {
		return CmtLike;
	}
	public void setCmtLike(int cmtLike) {
		CmtLike = cmtLike;
	}
	public String getCmtDate() {
		return CmtDate;
	}
	public void setCmtDate(String cmtDate) {
		CmtDate = cmtDate;
	}
	public int getRateScore() {
		return RateScore;
	}
	public void setRateScore(int rateScore) {
		RateScore = rateScore;
	}
	
	
}
