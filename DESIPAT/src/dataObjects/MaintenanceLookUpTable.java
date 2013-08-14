package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;

import statements.insertNew.NewUser;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllClassification;
import statements.selectAll.SelectAllMaintenance;
import statements.updateTable.UpdateAsset;

public class MaintenanceLookUpTable{
	public final static String ID_COLUMN_NAME = "maintID";
	public final static String MAINTSCHED_COLUMN_NAME = "maintSched";

	private ArrayList<Maintenance> maintenanceLookUpList;	
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
	
		maintenanceLookUpList = new ArrayList<Maintenance>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllMaintenance();
		statement.executeStatement();
		maintenanceLookUpList = statement.getResultList();
	}
	
	public ArrayList<Maintenance> getAllEntries() {
		return maintenanceLookUpList;
	}

	public Maintenance getEntry(int ID) {
		for(Maintenance m:maintenanceLookUpList)
			if(m.getID() == ID)
				return m;
		return null;
	}
}
