package model;

public class Order {
	private int OrderID;
	private int CustomerID;
	private String OrderDate;
	
	public Order(int orderID, int customerID, String orderDate) {
		super();
		OrderID = orderID;
		CustomerID = customerID;
		OrderDate = orderDate;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	
}
