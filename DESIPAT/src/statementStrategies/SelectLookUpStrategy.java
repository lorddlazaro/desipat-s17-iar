package statementStrategies;

import dbHandler.Query;

public abstract class SelectLookUpStrategy extends Query {
	public SelectLookUpStrategy (String tableName, String condition)	{
		query = "SELECT ID FROM " + tableName + " WHERE " + condition + ";";
	}
}
