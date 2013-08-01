package statements;

import dbHandler.Query;

// done
public abstract class SelectAllStrategy extends Query {
	public SelectAllStrategy(String tableName) {
		query = "SELECT * FROM " + tableName + ";";
	}
}

// add subclasses
class SelectAllUsers extends SelectAllStrategy {
	public SelectAllUsers() {
		super("UserAccount");
	}
}