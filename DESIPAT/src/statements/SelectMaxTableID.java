package statements;

import dbHandler.Query;

public abstract class SelectMaxTableID extends Query {
	public SelectMaxTableID(String tableID, String tableName) {
		query = "SELECT max(" + tableID + ") from " + tableName + ";";
	}
}
