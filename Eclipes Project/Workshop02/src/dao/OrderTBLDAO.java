package dao;

import static dao.CreateConnection.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.ProductLine;

public class OrderTBLDAO {
	public static void addOrder(int payment, String customerID, HashMap<Long, ProductLine> cartItems) {
		try (Connection con = getConnect()) {
			con.setAutoCommit(false);		
			String sql = "Insert into OrderTBL(OrderDate, PaymentMethod, CustomerID) output inserted.OrderID values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			LocalDateTime now = LocalDateTime.now();
			stmt.setDate(1, java.sql.Date.valueOf(now.toLocalDate()));
			stmt.setInt(2, payment);
			stmt.setString(3, customerID);
			stmt.execute();
			int lastIdentity = 0;  
			ResultSet identities =  stmt.getGeneratedKeys();  
			
			identities.next();  
			lastIdentity = identities.getInt(1);  
			identities.close();  
			stmt.close();
			
			String sql2 = "Insert into OrderLineTBL(OrderID, ProductID, Quantity, Price) values(?,?,?,?)";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			for (Map.Entry<Long, ProductLine> me : cartItems.entrySet()) {
		          stmt2.setInt(1, lastIdentity);
		          stmt2.setInt(2, me.getValue().getProduct().getID());
		          stmt2.setInt(3, me.getValue().getQuatity());
		          stmt2.setInt(4, me.getValue().getProduct().getPrice());
		          stmt2.addBatch();
		        }
			@SuppressWarnings("unused")
			int[] update = stmt2.executeBatch();
			con.commit();
			con.setAutoCommit(true);
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(OrderTBLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
