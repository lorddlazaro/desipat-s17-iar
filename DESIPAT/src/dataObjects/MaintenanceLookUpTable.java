package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;
import statements.insertNew.NewType;

import statements.insertNew.NewUser;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllClassification;
import statements.selectAll.SelectAllMaintenance;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class MaintenanceLookUpTable{
	public final static String ID_COLUMN_NAME = "maintID";
	public final static String MAINTSCHED_COLUMN_NAME = "maintSched";

	private ArrayList<Type> maintenanceLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static MaintenanceLookUpTable instance;
		
	public static MaintenanceLookUpTable getInstance(){
		if(instance == null){
			instance = new MaintenanceLookUpTable();
		}
		return instance;
	}
	
	protected  MaintenanceLookUpTable(){
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(MAINTSCHED_COLUMN_NAME);
	
		maintenanceLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllMaintenance();
		statement.executeStatement();
		maintenanceLookUpList = statement.getResultList();
	}
	
	public ArrayList<Type> getAllEntries() {
		return maintenanceLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:maintenanceLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
