package dbHandler;


public abstract class DBCommandHandler {
	protected SQLStatement myStatement;
	protected DBConnection myCon;
	
	public void useDB() {
		myCon = new DBConnection();
		
		myCon.openConnection();
		executeCommand();
		myCon.closeConnection();
		
	}
	
	public abstract void executeCommand();
	public void setStatement(SQLStatement stmt) {
		myStatement = stmt;
	}
}
