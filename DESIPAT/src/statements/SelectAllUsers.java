package statements;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.UserAccount;

public class SelectAllUsers extends SelectAllStrategy {
	public SelectAllUsers() {
		super("UserAccount");
	}

}
