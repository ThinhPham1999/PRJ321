package bean;

public class Order {
	private int OrderID;
	private int ProductID;
	private int quantity;
	private int price;
	public Order(int orderID, int productID, int quantity, int price) {
		super();
		OrderID = orderID;
		ProductID = productID;
		this.quantity = quantity;
		this.price = price;
	}
	public Order() {
		super();
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
