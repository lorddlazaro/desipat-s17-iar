package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;
import statements.insertNew.NewStorage;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllStorage;
import statements.updateTable.UpdateAsset;

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
		Query statement = new SelectAllStorage();
		statement.executeStatement();
		storageList = statement.getResultList();
	}
	
	public void addEntry(Storage storage){
		storageList.add(storage);
		NonQuery statement = new NewStorage(storage);
		statement.executeStatement();
	}
	
	public void editEntry(Storage storage) {
		ArrayList<String> values = storage.getValues();
		values.remove(this.ID_COLUMN_NAME);
		
		NonQuery statement = new UpdateAsset(values, storage.getID());
		statement.executeStatement();
	}
	
	/*
	 * YOU CANT DELETE AN ASSET
	public void deleteEntry(Asset asset){
		assetList.add(asset);
		NonQuery statement = new DeleteAsset(asset);
		statement.executeStatement();	
	}*/	
	
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
