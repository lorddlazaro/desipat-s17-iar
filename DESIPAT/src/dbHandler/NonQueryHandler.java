package dbHandler;

import java.sql.Statement;


public class NonQueryHandler extends DBCommandHandler {
	public void executeCommand() {
    	try{
    		Statement stmt = myCon.getConnection().createStatement();
			stmt.executeUpdate(myStatement.toString());
    	}
    	catch(Exception e){e.printStackTrace();}
	}
}