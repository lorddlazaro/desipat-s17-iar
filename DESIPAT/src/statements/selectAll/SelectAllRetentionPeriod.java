package statements.selectAll;

import dataObjects.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Classification;
import dataObjects.Maintenance;
import dataObjects.RetentionPeriod;
import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllRetentionPeriod extends SelectAllStrategy {
	public SelectAllRetentionPeriod() {
		super("RetentionPeriodLookUp");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Type>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					RetentionPeriod retentionPeriod= new RetentionPeriod(myResult.getInt(1), myResult.getString(2), myResult.getInt(3));
					resultList.add(retentionPeriod);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}