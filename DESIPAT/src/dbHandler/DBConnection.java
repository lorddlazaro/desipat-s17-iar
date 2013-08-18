package dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/DESIPAT";
    
    private Connection conn;
	
	public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Cannot connect to database.", "ERROR", JOptionPane.ERROR_MESSAGE);
        	System.exit(1);
        }
	}
	
	public void closeConnection() {
        try {
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public Connection getConnection() {
		return conn;
	}
}
