package statements;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.UserAccount;

public class SelectFromUser extends SelectFromIDStrategy {
	public SelectFromUser(int userID) {
		super("UserAccount", "userID =" + userID);
	}

	public ArrayList getResultList() {
		try {
			resultList = new ArrayList<UserAccount>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					UserAccount userAccount = new UserAccount(myResult.getInt(1),myResult.getString(2),myResult.getString(3),myResult.getInt(4),myResult.getInt(5));
					resultList.add(userAccount);
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