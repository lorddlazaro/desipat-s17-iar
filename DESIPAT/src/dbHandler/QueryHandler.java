package dbHandler;

import java.sql.ResultSet;
import java.sql.Statement;


public class QueryHandler extends DBCommandHandler {
	private ResultSet resultSet;
	
	public void executeCommand() {
    	try{
    		Statement stmt = myCon.getConnection().createStatement();
    		resultSet = stmt.executeQuery(myStatement.toString());
    	}
    	catch(Exception e){e.printStackTrace();}
	}

	public ResultSet getResult() {
		return resultSet;
	}
	
}
