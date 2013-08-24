package statements.insertNew;

import dataObjects.UserAccount;
import statements.InsertStrategy;

public class NewUser extends InsertStrategy{
	public NewUser(UserAccount u) {
		super("UserAccount", 
				"username, password, clearanceID, personID, isActive", 
				"'" + u.getUsername() + "', '" + u.getPassword() + "', " + u.getClearanceID() + ", " + u.getPersonID() + ", " + u.getIsActive());
	}
}
