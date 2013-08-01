package statements.updateTable;

import java.util.ArrayList;

import statements.UpdateStrategy;

public class UpdateUser extends UpdateStrategy{

	public UpdateUser(ArrayList<String> values, int toUpdate) {
		super("UserAccount", values, "userID = " + toUpdate);
	}

	public void populateColumns() {
		columns.add("username");
		columns.add("password");
		columns.add("clearanceID");
		columns.add("personID");
	}
}
