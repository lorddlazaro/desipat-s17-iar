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
					resultList.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7)});
					myResult.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
