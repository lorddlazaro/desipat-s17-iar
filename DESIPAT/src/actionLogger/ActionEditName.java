package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionEditName extends ActionLogger{
	
	public ActionEditName(int userID) {
		super(userID);
		
		log.setActionHeaderID(3);
		log.setActionDesc("Corrected Name");
	}
}
