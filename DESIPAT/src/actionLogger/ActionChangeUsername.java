package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionChangeUsername extends ActionLogger{
	
	public ActionChangeUsername(int userID) {
		super(userID);
		
		log.setActionHeaderID(3);
		log.setActionDesc("Changed Username");
		
		this.logAction();
	}

	public void logAction() {
		myHandler.setStatement(new NewActionLog(log));
		myHandler.executeCommand();
	}
}
