package statementStrategies;

import dbHandler.Query;

// done
public abstract class SelectAllStrategy extends Query {
	public SelectAllStrategy(String tableName) {
		query = "SELECT * FROM " + tableName + ";";
	}
}