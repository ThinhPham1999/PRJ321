package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateConnection {
	public static Connection getConnect(){
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FuProduct;","Workshop01","21051999"); 
            return con;
        } catch (Exception ex) {
            Logger.getLogger(CreateConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
}
