package statements;

import java.sql.SQLException;

import dbHandler.Query;

public class InsertAndSelectUser extends Query{
	public InsertAndSelectUser(String username, String password, int clearanceID, int personID) {
		query = "INSERT INTO UserAccount (username, password, clearanceID, personID) values ('" + username + "', '" + password + "', " + clearanceID + ", " + personID + ");";
	}
	
	public void fillResultList() {
		try {
			query = "SELECT LAST_INSERT_ID();";
			this.executeStatement();
			if (myResult.isBeforeFirst()) {
				myResult.first();
				while (!myResult.isAfterLast()) {
					resultList.add(myResult.getInt(1));
					myResult.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
