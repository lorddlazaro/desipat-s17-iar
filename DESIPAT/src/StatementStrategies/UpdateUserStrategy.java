package StatementStrategies;

import DataClasses.User;

public class UpdateUserStrategy implements UpdateStrategy {

	private String statement;
	private String username;
	private String password;
	private int userID;
	private int clearanceID;
	private int personID;
	
	public UpdateUserStrategy(User user)
	{
		username=user.getUsername();
		password=user.getPassword();
		userID=user.getUserID();
		clearanceID=user.getClearance();
		personID=user.getPerson().getPersonID();
	}
	public String getStatement() {
		statement="UPDATE UserAccount SET username = '" + username + "', password = '" + password + "', isActive = 1, clearanceID = " + clearanceID + ", personID = "+personID+" WHERE userID = " + userID + ";";
		return statement;
	}
	
	//change password:
	/*
	 * "UPDATE UserAccount SET password = '" + newPasswordField.getText() + "' WHERE userID = " + currUser.getUserID() + ";"
	 */

}
