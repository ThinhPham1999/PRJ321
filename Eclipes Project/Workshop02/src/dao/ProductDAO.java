package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {
	public static ArrayList<Product> listAll(){
		ArrayList<Product> result = new ArrayList<>();
        try (Connection con=CreateConnection.getConnect()){
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select ProductID, ProductName, ProductPrice from ProductTBL");
            while (re.next()) {
                int id = re.getInt(1);
                String name = re.getString(2);
                int price = re.getInt(3);
                result.add(new Product(id, name, price));
            }
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
		
	}
}
