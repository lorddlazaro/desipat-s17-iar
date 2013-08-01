package statementStrategies;

import dbHandler.Query;

public abstract class SelectFromIDStrategy extends Query { 
	public SelectFromIDStrategy(String tableName, String condition)	{
		query = "SELECT * FROM " + tableName + " WHERE ID = " + condition + ";";
	}
}

//add subclasses




