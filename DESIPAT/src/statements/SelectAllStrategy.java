package statements;

import java.sql.ResultSet;

import dbHandler.Query;

// done
public abstract class SelectAllStrategy extends Query {
	public SelectAllStrategy(String tableName) {
		query = "SELECT * FROM " + tableName + ";";
	}
}
