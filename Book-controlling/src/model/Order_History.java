package model;

public class Order_History {
	private int OrderID;
	private int BookID;
	private int OrderQuantity;
	private int OrderPrice;
	public Order_History(int orderID, int bookID, int orderQuantity, int orderPrice) {
		super();
		OrderID = orderID;
		BookID = bookID;
		OrderQuantity = orderQuantity;
		OrderPrice = orderPrice;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getOrderQuantity() {
		return OrderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		OrderQuantity = orderQuantity;
	}
	public int getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		OrderPrice = orderPrice;
	}
	
	
}
