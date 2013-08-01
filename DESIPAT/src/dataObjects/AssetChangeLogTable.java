package dataObjects;

import java.util.ArrayList;

import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewAssetChangeLog;
import statements.insertNew.NewUser;

public class AssetChangeLogTable extends TableSubject{
	public final static String CHANGEID_COLUMN_NAME = "changeID";
	public final static String ACTIONID_COLUMN_NAME = "actionID";
	public final static String ASSETID_COLUMN_NAME = "assetID";
	public final static String ASSETFIELD_COLUMN_NAME = "assetField";
	public final static String OLDVALUE_COLUMN_NAME = "oldValue";
	public final static String NEWVALUE_COLUMN_NAME = "newValue";
	
	private ArrayList<AssetChangeLog> assetChangeLogList;	
	private ArrayList<String> columnNames;
	
	private static AssetChangeLogTable instance;
	
	public static AssetChangeLogTable getInstance(){
		if(instance == null){
			instance = new AssetChangeLogTable();
		}
		return instance;
	}
	
	protected AssetChangeLogTable(){
		assetChangeLogList = new ArrayList<AssetChangeLog>();
		columnNames = new ArrayList<String>();
		columnNames.add(CHANGEID_COLUMN_NAME);
		columnNames.add(ACTIONID_COLUMN_NAME);
		columnNames.add(ASSETID_COLUMN_NAME);
		columnNames.add(ASSETFIELD_COLUMN_NAME);
		columnNames.add(OLDVALUE_COLUMN_NAME);
		columnNames.add(NEWVALUE_COLUMN_NAME);
	}
	public void addEntry(TableEntry tableEntry){
		AssetChangeLog assetChangeLog = (AssetChangeLog)tableEntry;
		entryList.add(tableEntry);
		NonQuery statement = new NewAssetChangeLog(assetChangeLog);
		statement.executeStatement();
	}
	//TODO: edit entry
	public void editEntry(TableEntry tableEntry){}	
	public void deleteEntry(TableEntry tableEntry){
		/*UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();*/
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

}
