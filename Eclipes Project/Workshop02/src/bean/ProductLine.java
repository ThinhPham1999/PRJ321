package bean;

import java.io.Serializable;

public class ProductLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private int quatity;

	public ProductLine(Product product, int quatity) {
		super();
		this.product = product;
		this.quatity = quatity;
	}
	
	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductLine [product=" + product + ", quatity=" + quatity + "]";
	}
	
	
}
