package statements.getMax;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import statements.SelectMaxTableID;

public class GetMaxIDPerson extends SelectMaxTableID{
	public GetMaxIDPerson() {
		super("personID", "Person");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				resultList.add(myResult.getInt(1));
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
