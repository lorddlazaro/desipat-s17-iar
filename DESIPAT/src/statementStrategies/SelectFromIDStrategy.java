package statementStrategies;

import dbHandler.Query;

public abstract class SelectFromIDStrategy extends Query { 
	public SelectFromIDStrategy(String tableName, String condition)	{
		query = "SELECT * FROM " + tableName + " WHERE ID = " + condition + ";";
	}
}

//add subclasses
class SelectFromUser extends SelectFromIDStrategy {
	public SelectFromUser(int userID) {
		super("UserAccount", "userID =" + userID);
	}
}

class SelectFromAsset extends SelectFromIDStrategy {
	public SelectFromAsset(int assetID) {
		super("Asset", "assetID = " + assetID);
	}
}	