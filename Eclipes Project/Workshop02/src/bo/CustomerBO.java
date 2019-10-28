package bo;

import java.util.ArrayList;

import bean.Customer;
import dao.CustomerDAO;

public class CustomerBO {
	private Customer cus;

	public CustomerBO() {
		super();
	}
	
	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public boolean validate(String customerId, String pass) {
		setCus(CustomerDAO.getCustomer(customerId));;
		if (this.cus != null) {
			if (cus.getPass().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Customer> listCustomer(){
		return CustomerDAO.listAll();
	}
}	
