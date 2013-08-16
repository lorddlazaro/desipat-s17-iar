package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.PersonTable;
import statements.SelectMaxTableID;

public class GetMaxIDPerson extends SelectMaxTableID{
	public GetMaxIDPerson() {
		super(PersonTable.ID_COLUMN_NAME, "Person");
	}
}
