package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.Product;
import bean.ProductLine;
import bean.ShopCart;
import bo.ProductBO;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> productList = new ArrayList<Product>();
	private Product product = new Product();
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductAction() {
		super();
	}
		
	public String listProduct() {
		ProductBO productbo = new ProductBO();
		setProductList(productbo.getList());
		return "success";
	}
	
	public String addProductToCart() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShopCart cart = (ShopCart)session.get("cart");
			
		if (cart == null) {
			cart = new ShopCart();
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<ProductLine> listProductLine = (ArrayList<ProductLine>) session.get("listProductLine");
		
		if (listProductLine == null) {
			listProductLine = new ArrayList<ProductLine>();
			ProductBO productbo = new ProductBO();
			setProductList(productbo.getList());
			for (Product pro:productList) {
				listProductLine.add(new ProductLine(pro, 0));
			}
		}
		
		for (ProductLine pr:listProductLine) {
			if (pr.getProduct().getID() == id)
				cart.insertToCart((long)id, pr);
		}
		
		session.put("cart", cart);
		session.put("listProductLine", listProductLine);
		return "success";
	}
	
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
}
