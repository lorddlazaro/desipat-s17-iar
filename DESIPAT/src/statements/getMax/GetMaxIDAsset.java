package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.PersonTable;
import dataObjects.UserAccountTable;
import statements.SelectMaxTableID;

public class GetMaxIDAsset extends SelectMaxTableID{
	public GetMaxIDAsset() {
		super(AssetTable.ID_COLUMN_NAME, "Asset");
	}
}
