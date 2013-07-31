package StatementStrategies;

public class DeleteUserStrategy implements DeleteStrategy {
	private int userID;
	private String statement;
	public DeleteUserStrategy(int userID)
	{
		this.userID=userID;
	}
	public String getStatement(){
		statement = "DELETE FROM UserAccount WHERE userID = " + userID + ";";
		return statement;
	}

}
