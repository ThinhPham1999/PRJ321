package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Customer;
import bean.Product;

public class CustomerDB {
	public static Customer getCustomer(String id) {
		Customer cus = null;
		try (Connection con=CreateConnection.getConnect()){
            con.setAutoCommit(false);
            Statement stmt= con.createStatement(); 
            ResultSet rs=stmt.executeQuery("Select CustomerID, CustomerName, CustomerPass from Customer where CustomerID='"+id+"'"); 
            if(rs.next()){
            	String CustomerID = id;
                String CustomerName=rs.getString(2); // == fullName
                String CustomerPass=rs.getString(3);  // == email 
                cus = new Customer(CustomerID, CustomerName, CustomerPass);
            }
            con.commit();
            con.close();
            return cus;
		}catch(Exception ex) {
			Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
		}
	}
	
	public static ArrayList<Customer> listAll(){
		ArrayList<Customer> result = new ArrayList<Customer>();
		try (Connection con=CreateConnection.getConnect()){
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select CustomerID, CustomerName, CustomerPass from Customer");
            while (re.next()) {
                String id = re.getString(1);
                String name = re.getString(2);
                String pass = re.getString(3);
                result.add(new Customer(id, name, pass));
            }
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
	}
}
