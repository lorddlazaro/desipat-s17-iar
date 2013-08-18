package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionLogOut extends ActionLogger{
	
	public ActionLogOut(int userID) {
		super(userID);
		
		log.setActionHeaderID(2);
		log.setActionDesc("Logged out");
	}
}
