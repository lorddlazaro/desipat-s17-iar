package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionEditClearance extends ActionLogger{
	
	public ActionEditClearance(int userID) {
		super(userID);
		
		log.setActionHeaderID(3);
		log.setActionDesc("Changed Clearance Level");
	}
}
