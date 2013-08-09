package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Person;
import statements.SelectAllStrategy;

public class SelectAllPersons extends SelectAllStrategy {
	public SelectAllPersons() {
		super("Person");
	}

	public ArrayList getResultList() {
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
			
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
