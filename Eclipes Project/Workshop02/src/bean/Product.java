package bean;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String name;
	private int price;
	public Product(int iD, String name, int price) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
