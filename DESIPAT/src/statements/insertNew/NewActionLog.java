package statements.insertNew;

import dataClasses.ActionLog;

public abstract class NewActionLog extends InsertStrategy{
	public NewActionLog(ActionLog a) {
		super("ActionLog",
				"userID, actionDate, actionTime, actionHeaderID, actionDesc",
				a.getUserID() + ", " + a.getActionDate() + ", " + a.getActionTime() + ", " + a.getActionHeaderID() + ", '" +
				a.getActionDescription() + "'");
	}
}
