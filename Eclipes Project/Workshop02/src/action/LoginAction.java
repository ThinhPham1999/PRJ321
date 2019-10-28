package action;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import bo.CustomerBO;

import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerID;
	private String pass;
	
	SessionMap<String, Object> sessionmap;
	
	public LoginAction() {
		super();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String execute() throws Exception {
		CustomerBO login = new CustomerBO();
        if (login.validate(customerID, pass)) {
        	sessionmap.remove("customerID");
        	sessionmap.remove("cart");
        	sessionmap.remove("listProductLine");
        	sessionmap.put("customerID", this.customerID);
        	return "success";
        }
        return "failed";
    }
	
	public String logout() {
		sessionmap.remove("customerID");
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionmap = (SessionMap<String, Object>)arg0;
	}
}
