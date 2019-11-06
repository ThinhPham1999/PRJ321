package dao;

import bean.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {

    public ProductDAO() {
    }
    

    public ArrayList<Product> listAll() {
        ArrayList<Product> result = new ArrayList<>();
        try (Connection con = CreateConnection.getConnect()) {
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select ProductID, ProductName, ProductUnit, ProductPrice from Product");
            while (re.next()) {
                String id = re.getString(1);
                String name = re.getString(2);
                String unit = re.getString(3);
                int price = re.getInt(4);
                result.add(new Product(id, name, unit, price));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void newProduct(Product p) {
        try (Connection con = CreateConnection.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Insert into Product(ProductID, ProductName, ProductUnit, ProductPrice) values(?,?,?,?)");
            stmt.setString(1, p.getProductID());
            stmt.setString(2, p.getProductName());
            stmt.setString(3, p.getProductUnit());
            stmt.setInt(4, p.getProductPrice());
            int rc = stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Product getProduct(String productID) {
        Product pro = null;
        try (Connection con = CreateConnection.getConnect()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select ProductID, ProductName, ProductUnit, ProductPrice from Product where ProductID='" + productID + "'");
            if (rs.next()) {
                String productName = rs.getString(2);
                String productUnit = rs.getString(3);
                int productPrice = rs.getInt(4);
                pro = new Product(productID, productName, productUnit, productPrice);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
}
