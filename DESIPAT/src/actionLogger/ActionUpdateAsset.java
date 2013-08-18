package actionLogger;

import statements.insertNew.NewActionLog;

public class ActionUpdateAsset extends ActionLogger{
	
	public ActionUpdateAsset(int userID, String assetName) {
		super(userID);
		
		log.setActionHeaderID(7);
		log.setActionDesc("Updated Asset Fields");
	}
}
