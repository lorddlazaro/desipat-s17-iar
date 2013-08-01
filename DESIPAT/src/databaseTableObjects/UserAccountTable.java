package databaseTableObjects;

import java.util.ArrayList;
import java.util.ArrayList;

import statementStrategies.DeleteUser;
import dbHandler.NonQuery;

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
	

	NonQuery statement;
	public void addEntry(TableEntry tableEntry){
		UserAccount user = (UserAccount)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		//statement=new InsertStrategy("UserAccount", /*tableEntry.values*/,"username, password, clearanceID, personID, isActive");
		statement.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		UserAccount user=(UserAccount)tableEntry;
		statement = new DeleteUser(user.getID());
		statement.executeStatement();
	}
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;
	}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);
	}
	
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
}
