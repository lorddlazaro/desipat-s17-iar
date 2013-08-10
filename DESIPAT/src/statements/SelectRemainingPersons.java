package statements;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbHandler.Query;

public class SelectRemainingPersons extends Query {
	public SelectRemainingPersons() {
		query = "SELECT firstName, middleInitial, lastName FROM Person WHERE personID NOT IN (SELECT personID FROM UserAccount) OR personID IN (SELECT personID FROM UserAccount WHERE isActive = 0);";
	}
	
	public void fillResultList() {
		try {
			if (myResult.isBeforeFirst()) {
				myResult.first();
				while (!myResult.isAfterLast()) {
					resultList.add(myResult.getString(1) + " " + myResult.getString(2) + ". " + myResult.getString(3));
					myResult.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
