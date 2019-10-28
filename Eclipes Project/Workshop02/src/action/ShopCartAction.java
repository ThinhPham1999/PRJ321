package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Customer;
import bean.ProductLine;
import bean.ShopCart;
import bo.CustomerBO;
import bo.OrderTBLBO;

public class ShopCartAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> customerList;
	private String customer;
	private String payment;
	private HashMap<Long, ProductLine> listProductCart;
	private int total;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ShopCartAction() {
		super();
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public HashMap<Long, ProductLine> getListProductCart() {
		return listProductCart;
	}

	public void setListProductCart(HashMap<Long, ProductLine> listProductCart) {
		this.listProductCart = listProductCart;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String viewShopCart() {
		CustomerBO customerBO = new CustomerBO();
		setCustomerList(customerBO.listCustomer());
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShopCart cart = (ShopCart) session.get("cart");
		if (cart == null) {
			cart = new ShopCart();
		}
		setListProductCart(cart.getCartItems());
		setTotal(cart.total());
		return "success";
	}
	
	public String addDatabase() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		ShopCart cart = (ShopCart) session.get("cart");
		System.out.print(cart.getCartItems());
		String id = (String)session.get("customerID");
		int pay = 0;
		if (payment.equals("Card")) {
			pay = 1;
		}
		OrderTBLBO order = new OrderTBLBO();
		order.addDatabase(pay, id, cart.getCartItems());
		session.remove("cart");
		session.remove("listProductLine");
		return "success";
	}
	
}
