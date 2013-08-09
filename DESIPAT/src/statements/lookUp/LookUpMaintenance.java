package statements.lookUp;

import java.sql.SQLException;
import java.util.ArrayList;

import statements.SelectLookUpStrategy;

public class LookUpMaintenance extends SelectLookUpStrategy {
	public LookUpMaintenance (String maint) {
		super("MaintenanceLookUp", "maintSched = " + maint);
	}

	public ArrayList getResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					int maintID = myResult.getInt(1);
					resultList.add(maintID);
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
