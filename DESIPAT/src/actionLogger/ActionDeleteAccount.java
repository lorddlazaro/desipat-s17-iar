package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionDeleteAccount extends ActionLogger{
	
	public ActionDeleteAccount(int userID, String username) {
		super(userID);
		
		log.setActionHeaderID(4);
		log.setActionDesc("Deleted Account " + username);
	}
}
