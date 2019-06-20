package model;

public class Book {
	private int BookID;
	private String BookName;
	private int BookPrice;
	private int BookQuantity;
	private String BookSize;
	private String BookType;
	private String BookImg1;
	private String BookImg2;
	private String BookImg;
	private String BookLink;
		
	
	

	public Book(int bookID, String bookName, int bookPrice, int bookQuantity, String bookSize, String bookType,
			String bookImg) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookPrice = bookPrice;
		BookQuantity = bookQuantity;
		BookSize = bookSize;
		BookType = bookType;
		BookImg = bookImg;
	}

	@Override
	public String toString() {
		return "Book [BookID=" + BookID + ", BookName=" + BookName + ", BookPrice=" + BookPrice + ", BookQuantity="
				+ BookQuantity + ", BookSize=" + BookSize + ", BookType=" + BookType + ", BookImg1=" + BookImg1
				+ ", BookImg2=" + BookImg2 + ", BookImg=" + BookImg + "]";
	}

	public Book(String bookName, int bookPrice, int bookQuantity, String bookSize, String bookType, String bookImg1,
			String bookImg2, String booImg) {
		BookName = bookName;
		BookPrice = bookPrice;
		BookQuantity = bookQuantity;
		BookSize = bookSize;
		BookType = bookType;
		BookImg1 = bookImg1;
		BookImg2 = bookImg2;
		BookImg = booImg;
	}
	

	public Book(int bookID, String bookName, int bookPrice, int bookQuantity, String bookSize, String bookType,
			String bookImg1, String bookImg2, String booImg) {
		BookID = bookID;
		BookName = bookName;
		BookPrice = bookPrice;
		BookQuantity = bookQuantity;
		BookSize = bookSize;
		BookType = bookType;
		BookImg1 = bookImg1;
		BookImg2 = bookImg2;
		BookImg = booImg;
	}
	
	

	public Book(int bookID, String bookName, int bookPrice, int bookQuantity, String bookSize, String bookType,
			String bookImg1, String bookImg2, String bookImg, String bookLink) {
		super();
		BookID = bookID;
		BookName = bookName;
		BookPrice = bookPrice;
		BookQuantity = bookQuantity;
		BookSize = bookSize;
		BookType = bookType;
		BookImg1 = bookImg1;
		BookImg2 = bookImg2;
		BookImg = bookImg;
		BookLink = bookLink;
	}

	//For author jsp
	public Book(String bookName, int bookPrice, String bookImg) {
		super();
		BookName = bookName;
		BookPrice = bookPrice;
		BookImg = bookImg;
	}
	
	//For Best seller
	public Book(String bookName, String bookImg) {
		super();
		BookName = bookName;
		BookImg = bookImg;
	}

	public String getBookImg() {
		return BookImg;
	}

	public void setBookImg(String bookImg) {
		BookImg = bookImg;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	
	public int getBookPrice() {
		return BookPrice;
	}

	public void setBookPrice(int bookPrice) {
		BookPrice = bookPrice;
	}


	public int getBookQuantity() {
		return BookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		BookQuantity = bookQuantity;
	}


	public String getBookSize() {
		return BookSize;
	}

	public void setBookSize(String bookSize) {
		BookSize = bookSize;
	}


	public String getBookType() {
		return BookType;
	}

	public void setBookType(String bookType) {
		BookType = bookType;
	}


	public String getBookImg1() {
		return BookImg1;
	}

	public void setBookImg1(String bookImg1) {
		BookImg1 = bookImg1;
	}


	public String getBookImg2() {
		return BookImg2;
	}

	public void setBookImg2(String bookImg2) {
		BookImg2 = bookImg2;
	}
	
	
	
}
