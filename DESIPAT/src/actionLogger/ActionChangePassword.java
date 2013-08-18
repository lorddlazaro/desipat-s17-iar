package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionChangePassword extends ActionLogger{
	
	public ActionChangePassword(int userID) {
		super(userID);
		
		log.setActionHeaderID(3);
		log.setActionDesc("Changed Password");
	}
}
