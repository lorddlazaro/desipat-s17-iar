package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.PersonTable;
import dataObjects.UserAccountTable;
import statements.SelectMaxTableID;

public class GetMaxIDUserAccount extends SelectMaxTableID{
	public GetMaxIDUserAccount() {
		super(UserAccountTable.ID_COLUMN_NAME, "UserAccount");
	}
}
