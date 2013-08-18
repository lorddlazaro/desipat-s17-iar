package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionLogIn extends ActionLogger{
	
	public ActionLogIn(int userID) {
		super(userID);
		
		log.setActionHeaderID(1);
		log.setActionDesc("Logged in");
	}
}
