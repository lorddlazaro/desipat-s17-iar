package dbHandler;

import java.sql.ResultSet;

// done
public abstract class Query implements SQLStatement{
	protected String query;
	protected QueryHandler myHandler;
	private ResultSet myResult;
	
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
	}
	
	public ResultSet getResult() {
		return myResult;
	}
}
