package statements;

import dbHandler.NonQuery;
import dataObjects.*;

public abstract class InsertStrategy extends NonQuery {
	public InsertStrategy(String tableName, String columns, String values) {
		System.out.println("Values: "+values);
		nonQuery = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ");";
		System.out.println("Values: "+nonQuery);
	}
}