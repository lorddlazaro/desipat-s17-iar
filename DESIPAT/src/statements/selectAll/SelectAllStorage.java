package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllStorage extends SelectAllStrategy {
	public SelectAllStorage() {
		super("Storage");
	}

	public ArrayList getResultList() {
		try {
			resultList = new ArrayList<Storage>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Storage storage= new Storage(myResult.getInt(1), myResult.getString(2));
					resultList.add(storage);
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