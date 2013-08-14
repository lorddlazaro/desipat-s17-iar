package statements.selectAll;

import dataObjects.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Classification;
import dataObjects.Maintenance;
import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllMaintenance extends SelectAllStrategy {
	public SelectAllMaintenance() {
		super("MaintenanceLookUp");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Type>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Maintenance maintenance= new Maintenance(myResult.getInt(1), myResult.getString(2));
					resultList.add(maintenance);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}