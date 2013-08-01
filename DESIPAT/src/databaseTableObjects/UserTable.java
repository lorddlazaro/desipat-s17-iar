package databaseTableObjects;

import java.util.ArrayList;

import dbHandler.NonQuery;
import statementStrategies.DeleteUser;

public class UserTable extends TableSubject{
	//private ArrayList<User> userList;	
	NonQuery statement;
	public void addEntry(TableEntry tableEntry){
		User user=(User)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		//statement=new InsertStrategy("UserAccount", /*tableEntry.values*/,"username, password, clearanceID, personID, isActive");
		statement.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		User user=(User)tableEntry;
		statement=new DeleteUser(user.getUserID());
		statement.executeStatement();
	}
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);}
}
