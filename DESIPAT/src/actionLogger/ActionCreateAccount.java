package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionCreateAccount extends ActionLogger{
	
	public ActionCreateAccount(int userID, String username) {
		super(userID);
		
		log.setActionHeaderID(5);
		log.setActionDesc("Created Account " + username);
	}
}
