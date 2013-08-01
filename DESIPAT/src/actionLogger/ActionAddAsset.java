package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionAddAsset extends ActionLogger{
	
	public ActionAddAsset(int userID, String assetName) {
		super(userID);
		
		log.setActionHeaderID(6);
		log.setActionDesc("Added Asset " + assetName + " to registry");
		
		this.logAction();
	}

	public void logAction() {
		myHandler.setStatement(new NewActionLog(log));
		myHandler.executeCommand();
	}
}
