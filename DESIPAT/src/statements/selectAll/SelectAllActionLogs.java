package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.ActionLog;
import statements.SelectAllStrategy;

public class SelectAllActionLogs extends SelectAllStrategy {
	public SelectAllActionLogs() {
		super("ActionLog");
	}
	
	public ArrayList getResultList() {
		try {
			resultList = new ArrayList<ActionLog>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					ActionLog log= new ActionLog(myResult.getInt(1), myResult.getInt(2), myResult.getDate(3), myResult.getTime(4), myResult.getInt(5), myResult.getString(6));
					resultList.add(log);
					myResult.next();
				}
			}
			myResult.close();
			
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}