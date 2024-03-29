package statements.lookUp;

import java.sql.SQLException;
import java.util.ArrayList;

import statements.SelectLookUpStrategy;

public class LookUpType extends SelectLookUpStrategy {
	public LookUpType (String type) {
		super("TypeLookUp", "type = " + type);
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					int typeID = myResult.getInt(1);
					resultList.add(typeID);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
