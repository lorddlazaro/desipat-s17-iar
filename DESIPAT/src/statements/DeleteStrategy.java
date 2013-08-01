package statements;

import dbHandler.NonQuery;

// done
public abstract class DeleteStrategy extends NonQuery {
	public DeleteStrategy(String tableName, String condition) {
		nonQuery = "DELETE FROM " + tableName + " WHERE " + condition + ";";
	}
}

// add subclasses

