package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.UserAccount;
import statements.SelectAllStrategy;

public class SelectAllUsers extends SelectAllStrategy {
	public SelectAllUsers() {
		super("UserAccount");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<UserAccount>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					UserAccount userAccount = new UserAccount(myResult.getInt(1),myResult.getString(2),myResult.getString(3),myResult.getInt(4),myResult.getInt(5),myResult.getInt(6));
					resultList.add(userAccount);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
