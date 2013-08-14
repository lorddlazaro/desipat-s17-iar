package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;
import statements.insertNew.NewType;

import statements.insertNew.NewUser;
import statements.selectAll.SelectAllActionHeader;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllClassification;
import statements.selectAll.SelectAllClearance;
import statements.selectAll.SelectAllMaintenance;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class ActionHeaderLookUpTable{
	public final static String ID_COLUMN_NAME = "actionHeaderID";
	public final static String ACTIONHEADER_COLUMN_NAME = "actionHeader";

	private ArrayList<Type> actionHeaderLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static ActionHeaderLookUpTable instance;
		
	public static ActionHeaderLookUpTable getInstance(){
		if(instance == null){
			instance = new ActionHeaderLookUpTable();
		}
		return instance;
	}
	
	protected  ActionHeaderLookUpTable(){
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(ACTIONHEADER_COLUMN_NAME);
	
		actionHeaderLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllActionHeader();
		statement.executeStatement();
		actionHeaderLookUpList = statement.getResultList();
	}
	
	public ArrayList<Type> getAllEntries() {
		return actionHeaderLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:actionHeaderLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
