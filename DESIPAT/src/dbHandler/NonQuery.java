package dbHandler;

//done
public abstract class NonQuery implements SQLStatement{
	protected String nonQuery;
	protected NonQueryHandler myHandler;
	
	public NonQuery() {
		myHandler = new NonQueryHandler();
	}

	public String toString() {
		return nonQuery;
	}

	public void executeStatement() {
		myHandler.setStatement(this);
		
		myHandler.useDB();
	}
}
