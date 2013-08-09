package statements.lookUp;

import java.sql.SQLException;
import java.util.ArrayList;

import statements.SelectLookUpStrategy;

public class LookUpClearance extends SelectLookUpStrategy {
	public LookUpClearance (String clearance) {
		super("ClearanceLookUp", "clearanceLevel = " + clearance);
	}

	public ArrayList getResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					int clearanceID = myResult.getInt(1);
					resultList.add(clearanceID);
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