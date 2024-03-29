package statements.lookUp;

import java.sql.SQLException;
import java.util.ArrayList;

import statements.SelectLookUpStrategy;

public class LookUpClassification extends SelectLookUpStrategy {
	public LookUpClassification (String classification) {
		super("ClassificationLookUp", "classification = " + classification);
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					int classID = myResult.getInt(1);
					resultList.add(classID);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
