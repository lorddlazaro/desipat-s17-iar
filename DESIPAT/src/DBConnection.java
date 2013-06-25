import java.sql.*;

public class DBConnection
{
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/DESIPAT";
    public Connection c;
    
    public ResultSet executeQuery(Connection con, String query){
    	try{
    		Statement stmt = con.createStatement();
			return stmt.executeQuery(query);
    	}
    	catch(Exception e){e.printStackTrace();}
    	
    	return null;
    }
    
    public void executeUpdate(Connection con, String command){
    	try{
    		Statement stmt = con.createStatement();
			stmt.executeUpdate(command);
    	}
    	catch(Exception e){e.printStackTrace();}
 
    }
    
    public Connection open()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void close() {
        try {
            c.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
