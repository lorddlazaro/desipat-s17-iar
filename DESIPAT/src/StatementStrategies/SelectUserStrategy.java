package StatementStrategies;

import DataClasses.User;

public class SelectUserStrategy implements SelectStrategy {

	String statement;
	int userID;
	public SelectUserStrategy(User user)
	{
		userID=user.getUserID();
	}
	public String getStatement() {
		statement="select username from useraccount where userid = '"+userID+"';";
		return statement;
		
	}
	
}
