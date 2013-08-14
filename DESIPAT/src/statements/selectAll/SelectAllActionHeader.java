package statements.selectAll;

import dataObjects.Type;
import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.ActionHeader;
import dataObjects.Storage;
import dataObjects.UserAccount;

import statements.SelectAllStrategy;

public class SelectAllActionHeader extends SelectAllStrategy {
	public SelectAllActionHeader() {
		super("ActionHeaderLookUp");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Type>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					ActionHeader actionHeader= new ActionHeader(myResult.getInt(1), myResult.getString(2));
					resultList.add(actionHeader);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}