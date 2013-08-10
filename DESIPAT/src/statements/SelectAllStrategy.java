package statements;

import dbHandler.Query;

public abstract class SelectAllStrategy extends Query {
	public SelectAllStrategy(String tableName) {
		query = "SELECT * FROM " + tableName + ";";
	}
}
