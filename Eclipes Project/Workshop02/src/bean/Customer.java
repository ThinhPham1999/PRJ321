package bean;

import java.io.Serializable;
//import java.util.ArrayList;

//import DB.*;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private String pass;
	public Customer(String iD, String name, String pass) {
		super();
		ID = iD;
		this.name = name;
		this.pass = pass;
	}
	public Customer() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
//	public static Customer login(String id, String pw){
//        Customer cus= CustomerDB.getCustomer(id);
//        if (cus == null){
//            return null;
//        }
//        if(cus.getPass().equals(pw)) return cus;
//        return null;
//    }
	
//	public static ArrayList<Customer> listAll(){
//		return CustomerDB.listAll();
//	}
}
