package dataObjects;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.getMax.GetMaxIDAssetChangeLog;
import statements.getMax.GetMaxIDPerson;
import statements.insertNew.NewActionLog;
import statements.insertNew.NewAssetChangeLog;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllActionLogs;
import statements.selectAll.SelectAllAssetChangeLogs;
import statements.selectAll.SelectAllUsers;
import statements.updateTable.UpdateAsset;

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
		Query statement = new SelectAllAssetChangeLogs();
		statement.executeStatement();
		assetChangeLogList = statement.getResultList();
	}
	
	public void addEntry(AssetChangeLog assetChangeLog){
		assetChangeLogList.add(assetChangeLog);
		NonQuery statement = new NewAssetChangeLog(assetChangeLog);
		statement.executeStatement();
		
		Query getID = new GetMaxIDAssetChangeLog();
		getID.executeStatement();
		
		assetChangeLog.setID((Integer)getID.getResultList().get(0));
		
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
	
	public DefaultTableModel createSelectedAssetChageLogTableModel(int selectedAssetID){
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("User");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("New Value");
		model.addColumn("Old Value");
		
		Asset selectedAsset = AssetTable.getInstance().getEntry(selectedAssetID);

		if(selectedAsset != null){
			 
			Vector<Object> row = new Vector<Object>();
			ArrayList<AssetChangeLog> list = AssetChangeLogTable.getInstance().getAllEntries();
			
			System.out.println(list.size());
			for(AssetChangeLog assetChangeLog: list)
				if(assetChangeLog.getAssetID() == selectedAsset.getID()){
					row.add(assetChangeLog.getActionLog().getActionDate());
					row.add(assetChangeLog.getActionLog().getActionTime());
					row.add(assetChangeLog.getActionLog().getUser().getUsername());
					row.add(assetChangeLog.getAsset().getName());
					row.add(assetChangeLog.getAssetField());
					row.add(assetChangeLog.getOldValue());
					row.add(assetChangeLog.getNewValue());	

					model.addRow(row);
				}
		}
		return model;
	}
	
	public DefaultTableModel createAssetChangeLogTableModel(){
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("User");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("Old Value");
		model.addColumn("New Value");
		
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat time = new SimpleDateFormat("hh:mm");
		
		for(AssetChangeLog assetChangeLog : AssetChangeLogTable.getInstance().getAllEntries()){
			Vector<Object> row = new Vector<Object>();
			
			row.add(date.format(assetChangeLog.getActionLog().getActionDate()));
			row.add(time.format(assetChangeLog.getActionLog().getActionTime()));
			row.add(assetChangeLog.getActionLog().getUser().getUsername());
			row.add(assetChangeLog.getAsset().getName());
			row.add(assetChangeLog.getAssetField());
			row.add(assetChangeLog.getOldValue());
			row.add(assetChangeLog.getNewValue());
			
			model.addRow(row);
		}
		return model;
		
	}
}
