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

	private ArrayList<Type> clearanceLookUpList;	
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
	
		clearanceLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllClearance();
		statement.executeStatement();
		clearanceLookUpList = statement.getResultList();
	}
	
	public ArrayList<Type> getAllEntries() {
		return clearanceLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:clearanceLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
