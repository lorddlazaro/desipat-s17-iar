package statements;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbHandler.Query;

public class SelectRowUserTable extends Query {
	public SelectRowUserTable() {
		query = "SELECT u.userID, u.username, u.password, c.clearanceLevel, p.firstName, p.middleInitial, p.lastName FROM UserAccount AS u, Person AS p, ClearanceLookUp AS c WHERE u.personID = p.personID AND u.clearanceID = c.clearanceID AND u.isActive = 1 ORDER BY u.userID;";
	}
	
	public void fillResultList() {
		try {
			if (myResult.isBeforeFirst()) {
				myResult.first();
				while (!myResult.isAfterLast()) {
					resultList.add(new Object[]{myResult.getString(1), myResult.getString(2), myResult.getString(3), myResult.getString(4),myResult.getString(5),myResult.getString(6), myResult.getString(7)});
					myResult.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
