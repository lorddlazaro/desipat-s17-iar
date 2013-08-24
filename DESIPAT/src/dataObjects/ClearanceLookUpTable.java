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
import statements.selectAll.SelectAllClearance;
import statements.selectAll.SelectAllMaintenance;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class ClearanceLookUpTable{
	public final static String ID_COLUMN_NAME = "clearanceID";
	public final static String CLEARANCELEVEL_COLUMN_NAME = "clearanceLevel";

	private ArrayList<Clearance> clearanceLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static ClearanceLookUpTable instance;
		
	public static ClearanceLookUpTable getInstance(){
		if(instance == null){
			instance = new ClearanceLookUpTable();
		}
		return instance;
	}
	
	protected  ClearanceLookUpTable(){
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(CLEARANCELEVEL_COLUMN_NAME);
	
		clearanceLookUpList = new ArrayList<Clearance>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllClearance();
		statement.executeStatement();
		clearanceLookUpList = statement.getResultList();
	}
	
	public ArrayList<Clearance> getAllEntries() {
		return clearanceLookUpList;
	}

	public Clearance getEntry(int ID) {
		for(Clearance c:clearanceLookUpList)
			if(c.getID() == ID)
				return c;
		return null;
	}
	
	public Clearance getEntry(String type) {
		for (Clearance c:clearanceLookUpList)
			if (c.getClearanceLevel().equals(type))
				return c;
		return null;
	}
	
	// Gets the ClearanceLevel of a specific ID from an ArrayList
	public String getTableID(int ID){
		for(int i = 0; i < clearanceLookUpList.size(); i++){
			if(clearanceLookUpList.get(i).getClearanceID() == ID)
				return clearanceLookUpList.get(i).getClearanceLevel();
		}
		return null;
	}
}
