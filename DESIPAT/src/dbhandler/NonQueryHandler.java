package dbhandler;

public class NonQueryHandler implements DBCommandHandler {
	private Statement myStatement;
	
	public void executeCommand() {
		
	}

	public void setStatement(Statement stmt) {
		myStatement = stmt;
	}
}
