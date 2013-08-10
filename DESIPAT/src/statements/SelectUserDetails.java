package statements;

import java.sql.SQLException;

import dbHandler.Query;

public class SelectUserDetails extends Query {
	public SelectUserDetails(int userID) {
		query = "SELECT u.username, u.password, c.clearanceLevel, p.firstName, p.middleInitial, p.lastName FROM UserAccount AS u, Person AS p, clearanceLookUp AS c WHERE u.personID = p.personID AND u.clearanceID = c.clearanceID AND u.userID = " + userID + ";";
	}
	
	public void fillResultList() {
		try {
			if (myResult.isBeforeFirst()) {
				myResult.first();
				
				resultList.add(myResult.getString(1));
				resultList.add(myResult.getString(2));
				resultList.add(myResult.getString(3));
				resultList.add(myResult.getString(4));
				resultList.add(myResult.getString(5));
				resultList.add(myResult.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
