package statements.update;

import java.util.ArrayList;

import dataObjects.Asset;
import dataObjects.UserAccount;
import statements.InsertStrategy;
import statements.UpdateStrategy;

public class UpdateUser extends UpdateStrategy {
	static ArrayList<String>columns;
	public UpdateUser(UserAccount a) {
		super("UserAccount", columns, a.getValues(), "username = "+a.getUsername());
		columns=new ArrayList<String>();
		columns.add("username");
		columns.add("password");
		columns.add("clearanceID");
		columns.add("personID");
	}
}
