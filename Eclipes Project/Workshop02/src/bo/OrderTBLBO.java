package bo;

import java.util.HashMap;

import bean.ProductLine;
import dao.OrderTBLDAO;

public class OrderTBLBO {
	public void addDatabase(int payment, String customerID, HashMap<Long, ProductLine> cartItems) {
		System.out.print(customerID);
		OrderTBLDAO.addOrder(payment, customerID, cartItems);
	}
}
