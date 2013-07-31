package dbhandler;

import java.sql.ResultSet;

public class QueryHandler implements DBCommandHandler {
	private Statement myStatement;
	
	public void executeCommand() {
		
	}

	public void setStatement(Statement stmt) {
		myStatement = stmt;
	}
	
	public ResultSet getResult() {
		return null;
	}
}
