package statements;

import java.sql.SQLException;

import dbHandler.Query;

public class InsertAndSelectPerson extends Query{
	public InsertAndSelectPerson(String firstName, String middleInit, String lastName) {
		query = "INSERT INTO UserAccount (firstName, middleInitial, lastName) values ('" + firstName + "', '" + middleInit + "', '" + lastName + "');";
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
