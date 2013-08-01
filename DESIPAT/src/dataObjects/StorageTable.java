package dataObjects;

import java.util.ArrayList;

import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewStorage;
import statements.insertNew.NewUser;

public class StorageTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "storageID";
	public final static String LOCATION_COLUMN_NAME = "storageLocation";

	
	private ArrayList<Storage> storageList;	
	private ArrayList<String> columnNames;
	
	public StorageTable(){
		storageList = new ArrayList<Storage>();
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(LOCATION_COLUMN_NAME);

	}
	public void addEntry(TableEntry tableEntry){
		Storage storage = (Storage)tableEntry;
		entryList.add(tableEntry);
		NonQuery statement = new NewStorage(storage);
		statement.executeStatement();
	}
	//TODO: edit entry
	public void editEntry(TableEntry tableEntry){}	
	public void deleteEntry(TableEntry tableEntry){
		//Storage storage = (Storage)tableEntry;
		//NonQuery statement = new DeleteUser(user.getID());
		//statement.executeStatement();
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
}
