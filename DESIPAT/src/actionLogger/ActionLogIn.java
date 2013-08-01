package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionLogIn extends ActionLogger{
	
	public ActionLogIn(int userID) {
		super(userID);
		
		log.setActionHeaderID(1);
		log.setActionDesc("Logged in");
		
		this.logAction();
	}

	public void logAction() {
		myHandler.setStatement(new NewActionLog(log));
		myHandler.executeCommand();
	}
}
