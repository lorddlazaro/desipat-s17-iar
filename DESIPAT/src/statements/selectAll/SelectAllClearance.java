package statements.selectAll;

import dataObjects.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Classification;
import dataObjects.Clearance;
import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllClearance extends SelectAllStrategy {
	public SelectAllClearance() {
		super("ClearanceLookUp");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Type>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Clearance clearance= new Clearance(myResult.getInt(1), myResult.getString(2));
					resultList.add(clearance);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}