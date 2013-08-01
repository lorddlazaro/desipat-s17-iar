package databaseTableObjects;

import java.util.ArrayList;

import dbHandler.Query;

public class UserTable extends TableSubject{
	//private ArrayList<User> userList;	
	Query query;
	public void addEntry(TableEntry tableEntry){
		User user=(User)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		query=new InsertStrategy("UserAccount", /*tableEntry.values*/,"username, password, clearanceID, personID, isActive");
		query.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		User user=(User)tableEntry;
		query=new DeleteStrategy("UserAccount",user.getUserID());
		query.executeStatement();
	}
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);}
}
