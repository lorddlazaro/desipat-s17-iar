package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.AssetChangeLogTable;
import dataObjects.PersonTable;
import statements.SelectMaxTableID;

public class GetMaxIDAssetChangeLog extends SelectMaxTableID{
	public GetMaxIDAssetChangeLog() {
		super(AssetChangeLogTable.ACTIONID_COLUMN_NAME, "AssetChangeLog");
	}
}
