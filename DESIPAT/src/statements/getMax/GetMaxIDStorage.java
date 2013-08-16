package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.PersonTable;
import dataObjects.StorageTable;
import statements.SelectMaxTableID;

public class GetMaxIDStorage extends SelectMaxTableID{
	public GetMaxIDStorage() {
		super(StorageTable.ID_COLUMN_NAME, "Storage");
	}
}
