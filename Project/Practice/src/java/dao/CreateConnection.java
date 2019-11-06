
package dao;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CreateConnection {
    public static Connection getConnect(){
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
            return ds.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(CreateConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
}
