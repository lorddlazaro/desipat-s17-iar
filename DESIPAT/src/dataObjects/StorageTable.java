package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewStorage;
import statements.insertNew.NewUser;

public class StorageTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "storageID";
	public final static String LOCATION_COLUMN_NAME = "storageLocation";

	private ArrayList<Storage> storageList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static StorageTable instance;
		
	public static StorageTable getInstance(){
		if(instance == null){
			instance = new StorageTable();
		}
		return instance;
	}
	
	protected  StorageTable(){
		observerList = new ArrayList<TableObserver>();

		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(LOCATION_COLUMN_NAME);
	
		storageList = new ArrayList<Storage>();
		fillData();
	}
	
	private void fillData(){
		//TODO
	}
	
	public void addEntry(TableEntry tableEntry){
		Storage storage = (Storage)tableEntry;
		NonQuery statement = new NewStorage(storage);
		statement.executeStatement();
	}
	
	public void editEntry(TableEntry tableEntry){
		//TODO: edit entry
	}	
	
	public ArrayList<Storage> getAllEntries() {
		return storageList;
	}

	public Storage getEntry(int ID) {
		for(Storage storage:storageList)
			if(storage.getID() == ID)
				return storage;
		return null;
	}
}
