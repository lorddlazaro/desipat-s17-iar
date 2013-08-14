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
import statements.selectAll.SelectAllRetentionPeriod;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class RetentionPeriodLookUpTable{
	public final static String ID_COLUMN_NAME = "periodID";
	public final static String PERIODNAME_COLUMN_NAME = "periodName";
	public final static String PERIODVALUE_COLUMN_NAME = "periodValue";

	private ArrayList<Type> periodLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static RetentionPeriodLookUpTable instance;
		
	public static RetentionPeriodLookUpTable getInstance(){
		if(instance == null){
			instance = new RetentionPeriodLookUpTable();
		}
		return instance;
	}
	
	protected  RetentionPeriodLookUpTable(){
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(PERIODNAME_COLUMN_NAME);
		columnNames.add(PERIODVALUE_COLUMN_NAME);
	
		periodLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllRetentionPeriod();
		statement.executeStatement();
		periodLookUpList = statement.getResultList();
	}
	
	public ArrayList<Type> getAllEntries() {
		return periodLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:periodLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
