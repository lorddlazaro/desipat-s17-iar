package statements.insertNew;

import dataClasses.User;

public class NewUser extends InsertStrategy{
	public NewUser(User u) {
		super("UserAccount", 
				"username, password, clearanceID, personID", 
				"'" + u.getUsername() + "', '" + u.getPassword() + "', " + u.getClearance() + ", " + u.getPerson().getPersonID());
	}
}
