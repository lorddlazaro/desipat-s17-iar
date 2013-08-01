package actionLogger;

import dataObjects.ActionLog;
import dbHandler.NonQueryHandler;

public abstract class ActionLogger {
	protected ActionLog log;
	protected NonQueryHandler myHandler;
	
	protected int actionHeaderID;
	protected String actionDesc;
	
	public ActionLogger(int userID) {
		log = new ActionLog();
		
		log.setUserID(userID);
	}
	
	public abstract void logAction();
}