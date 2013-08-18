package statements.insertNew;

import dataObjects.ActionLog;
import statements.InsertStrategy;

public class NewActionLog extends InsertStrategy{
	public NewActionLog(ActionLog a) {
		super("ActionLog",
				"userID, actionDate, actionTime, actionHeaderID, actionDesc",
				a.getUserID() + ", '" + a.getActionDate() + "' ,'" + a.getActionTime() + "' , " + a.getActionHeaderID() + ", '" +
				a.getActionDesc() + "'");
	}
}
