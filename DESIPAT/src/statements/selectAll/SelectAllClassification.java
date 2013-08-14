package statements.selectAll;

import dataObjects.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Classification;
import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllClassification extends SelectAllStrategy {
	public SelectAllClassification() {
		super("ClassificationLookUp");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Type>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Classification classification= new Classification(myResult.getInt(1), myResult.getString(2));
					resultList.add(classification);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}