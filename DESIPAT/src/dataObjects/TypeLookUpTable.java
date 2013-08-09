package dataObjects;

import java.sql.ResultSet;
import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewActionLog;
import statements.insertNew.NewAssetChangeLog;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllActionLogs;
import statements.selectAll.SelectAllAssetChangeLogs;
import statements.selectAll.SelectAllUsers;
import statements.updateTable.UpdateAsset;

public class TypeLookUpTable extends TableSubject{
	public final static String CHANGEID_COLUMN_NAME = "changeID";
	public final static String ACTIONID_COLUMN_NAME = "actionID";
	public final static String ASSETID_COLUMN_NAME = "assetID";
	public final static String ASSETFIELD_COLUMN_NAME = "assetField";
	public final static String OLDVALUE_COLUMN_NAME = "oldValue";
	public final static String NEWVALUE_COLUMN_NAME = "newValue";
	
	private ArrayList<AssetChangeLog> assetChangeLogList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static TypeLookUpTable instance;
		
	public static TypeLookUpTable getInstance(){
		if(instance == null){
			instance = new TypeLookUpTable();
		}
		return instance;
	}
	
	protected TypeLookUpTable(){
		observerList = new ArrayList<TableObserver>();
		
		columnNames = new ArrayList<String>();
		columnNames.add(CHANGEID_COLUMN_NAME);
		columnNames.add(ACTIONID_COLUMN_NAME);
		columnNames.add(ASSETID_COLUMN_NAME);
		columnNames.add(ASSETFIELD_COLUMN_NAME);
		columnNames.add(OLDVALUE_COLUMN_NAME);
		columnNames.add(NEWVALUE_COLUMN_NAME);
		
		assetChangeLogList = new ArrayList<AssetChangeLog>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllAssetChangeLogs();
		statement.executeStatement();
		assetChangeLogList = statement.getResultList();
	}
	
	public void addEntry(AssetChangeLog assetChangeLog){
		assetChangeLogList.add(assetChangeLog);
		NonQuery statement = new NewAssetChangeLog(assetChangeLog);
		statement.executeStatement();
		
		this.notifyObservers();
	}
	/* CANT EDIT ASSETCHANGELOG
	public void editEntry(ActionLog actionLog){
		ArrayList<String> values = actionLog.getValues();
		values.remove(this.CHANGEID_COLUMN_NAME);
		
		NonQuery statement = new UpdateAsset(values, actionLog.getID());
		statement.executeStatement();
	}	
	
	/* CANT DELETE ASSETCHANGELOG
	public void deleteEntry(TableEntry tableEntry){
		//TODO
		/*UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();
	}*/
	
	public ArrayList<AssetChangeLog> getAllEntries() {
		return assetChangeLogList;
	}

	public AssetChangeLog getEntry(int ID) {
		for(AssetChangeLog assetChangeLog:assetChangeLogList)
			if(assetChangeLog.getID() == ID)
				return assetChangeLog;
		return null;
	}
}