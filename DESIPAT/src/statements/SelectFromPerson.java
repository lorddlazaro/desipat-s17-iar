package statements;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Person;

public class SelectFromPerson extends SelectFromIDStrategy {
	public SelectFromPerson(int personID) {
		super("Person", "assetID = " + personID);
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Person>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Person person= new Person(myResult.getInt(1), myResult.getString(2), myResult.getString(3).charAt(0), myResult.getString(4));
					resultList.add(person);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
