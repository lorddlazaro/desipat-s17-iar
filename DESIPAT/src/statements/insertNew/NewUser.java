package statements.insertNew;

import dataObjects.UserAccount;
import statements.InsertStrategy;

public class NewUser extends InsertStrategy{
	public NewUser(UserAccount u) {
		super("UserAccount", 
				"username, password, clearanceID, personID", 
				"'" + u.getUsername() + "', '" + u.getPassword() + "', " + u.getClearanceID() + ", " + u.getPersonID());
	}
}
