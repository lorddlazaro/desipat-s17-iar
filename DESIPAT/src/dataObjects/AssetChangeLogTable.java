package dataObjects;

import java.sql.ResultSet;
import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAssetChangeLog;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllUsers;

public class AssetChangeLogTable extends TableSubject{
	public final static String CHANGEID_COLUMN_NAME = "changeID";
	public final static String ACTIONID_COLUMN_NAME = "actionID";
	public final static String ASSETID_COLUMN_NAME = "assetID";
	public final static String ASSETFIELD_COLUMN_NAME = "assetField";
	public final static String OLDVALUE_COLUMN_NAME = "oldValue";
	public final static String NEWVALUE_COLUMN_NAME = "newValue";
	
	private ArrayList<AssetChangeLog> assetChangeLogList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static AssetChangeLogTable instance;
		
	public static AssetChangeLogTable getInstance(){
		if(instance == null){
			instance = new AssetChangeLogTable();
		}
		return instance;
	}
	
	protected AssetChangeLogTable(){
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
		// TODO
		Query statement = new SelectAllUsers();
		statement.executeStatement();
		try{
			ResultSet rs = statement.getResult();
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					Asset asset = new Asset(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getDate(10),rs.getFloat(11),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					rs.next();
				}
			}
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addEntry(TableEntry tableEntry){
		AssetChangeLog assetChangeLog = (AssetChangeLog)tableEntry;
		NonQuery statement = new NewAssetChangeLog(assetChangeLog);
		statement.executeStatement();
	}
	
	public void editEntry(TableEntry tableEntry){
		// TODO
	}
	
	public void deleteEntry(TableEntry tableEntry){
		//TODO
		/*UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();*/
	}

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
