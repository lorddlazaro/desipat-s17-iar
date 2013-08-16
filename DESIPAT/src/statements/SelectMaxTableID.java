package statements;

import java.sql.SQLException;
import java.util.ArrayList;

import dbHandler.Query;

public abstract class SelectMaxTableID extends Query {
	public SelectMaxTableID(String tableID, String tableName) {
		query = "SELECT max(" + tableID + ") from " + tableName + ";";
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				resultList.add(myResult.getInt(1));
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
