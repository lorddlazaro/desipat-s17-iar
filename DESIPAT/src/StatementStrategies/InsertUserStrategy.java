package StatementStrategies;

import DataClasses.User;

public class InsertUserStrategy extends InsertStrategy {
	private String statement;
	private String username;
	private String password;
	private int clearanceID;
	
	public InsertUserStrategy(User user)
	{
		username=user.getUsername();
		password=user.getPassword();
	}
	public String getStatement() {
		statement="INSERT INTO UserAccount (username, password, isactive, clearanceID) values ('" + username + "', '" + password + "', 1, "+clearanceID+");";
		return statement;
	}

}
