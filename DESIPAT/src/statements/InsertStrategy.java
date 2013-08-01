package statements;

import dbHandler.NonQuery;
import dataObjects.*;

public abstract class InsertStrategy extends NonQuery {
	public InsertStrategy(String tableName, String columns, String values) {
		nonQuery = "INSERT INTO " + tableName + " (" + columns + ") VALUES " + values + ";";
	}
}