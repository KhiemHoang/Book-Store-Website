package model;

public class Publisher {
	private int AuthorID;
	private int BookID;
	private String Release;
	private String Company;
	public Publisher(int authorID, int bookID, String release, String company) {
		super();
		AuthorID = authorID;
		BookID = bookID;
		Release = release;
		Company = company;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getRelease() {
		return Release;
	}
	public void setRelease(String release) {
		Release = release;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	
	
	
	
}
