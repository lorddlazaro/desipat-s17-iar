package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.ActionLogTable;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.PersonTable;
import dataObjects.UserAccountTable;
import statements.SelectMaxTableID;

public class GetMaxIDActionLog extends SelectMaxTableID{
	public GetMaxIDActionLog() {
		super(ActionLogTable.ACTIONID_COLUMN_NAME, "ActionLog");
	}
}
