import java.sql.Connection;
import java.sql.ResultSet;


public interface DBConnectionFactory {

    public Connection openConnection();
    public void closeConnection();
    
    public ResultSet executeQuery(Connection con, String query);
    public void executeUpdate(Connection con, String command);
}
