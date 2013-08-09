package dbHandler;

import java.sql.ResultSet;
import java.util.ArrayList;

// done
public abstract class Query implements SQLStatement{
	protected String query;
	protected QueryHandler myHandler;
	protected ResultSet myResult;
	protected ArrayList resultList;
	
	public Query() {
		myHandler = new QueryHandler();
	}
	
	public String toString() {
		return query;
	}

	public void executeStatement() {
		myHandler.setStatement(this);
		myHandler.useDB();
		
		myResult = myHandler.getResult();
		
		myHandler.closeConnection();
	}
	
	public ResultSet getResult() {
		return myResult;
	}
	
	public abstract ArrayList getResultList();
}
