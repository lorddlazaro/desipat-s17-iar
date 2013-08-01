package dataObjects;

import java.util.ArrayList;

import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewUser;

public class UserAccountTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "userID";
	public final static String USERNAME_COLUMN_NAME = "username";
	public final static String PASSWORD_COLUMN_NAME = "password";
	public final static String CLEARANCEID_COLUMN_NAME = "clearanceID";
	public final static String PERSONID_COLUMN_NAME = "personID";
	
	private ArrayList<UserAccount> userList;	
	private ArrayList<String> columnNames;
	
	public UserAccountTable(){
		userList = new ArrayList<UserAccount>();
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(USERNAME_COLUMN_NAME);
		columnNames.add(PASSWORD_COLUMN_NAME);
		columnNames.add(CLEARANCEID_COLUMN_NAME);
		columnNames.add(PERSONID_COLUMN_NAME);
	}
	public void addEntry(TableEntry tableEntry){
		UserAccount userAccount = (UserAccount)tableEntry;
		entryList.add(tableEntry);
		NonQuery statement = new NewUser(userAccount);
		statement.executeStatement();
	}
	//TODO: edit entry
	public void editEntry(TableEntry tableEntry){}	
	public void deleteEntry(TableEntry tableEntry){
		UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
}
