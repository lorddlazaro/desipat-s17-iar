package dataObjects;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import screens.TableObserver;
import statements.DeleteStrategy;
import statements.DeleteUser;
import statements.SelectAssetID;
import statements.getMax.GetMaxIDAsset;
import statements.getMax.GetMaxIDPerson;
import statements.insertNew.NewAsset;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllActionLogs;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllUsers;
import statements.updateTable.UpdateAsset;

import dbHandler.NonQuery;
import dbHandler.Query;
import dbHandler.QueryHandler;


public class AssetTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "identifier";
	public final static String OWNERID_COLUMN_NAME = "ownerID";
	public final static String CUSTODIANID_COLUMN_NAME = "custodianID";
	public final static String TYPEID_COLUMN_NAME = "typeID";
	public final static String MAINTID_COLUMN_NAME = "maintID";
	public final static String CLASSID_COLUMN_NAME = "classID";
	public final static String STORAGEID_COLUMN_NAME = "storageID";
	public final static String PERIODID_COLUMN_NAME = "periodID";
	public final static String DATEACQUIRED_COLUMN_NAME = "dateAcquired";
	public final static String FINANCIAL_COLUMN_NAME = "financialValue";
	public final static String CONFIDENTIALITY_COLUMN_NAME = "confidentialValue";
	public final static String INTEGRITY_COLUMN_NAME = "integrityValue";
	public final static String AVAILABILITY_COLUMN_NAME = "availabilityValue";
	
	private ArrayList<Asset> assetList;	

	// Singleton's getInstance
	private static AssetTable instance;
	
	public static AssetTable getInstance(){
		if(instance == null){
			instance = new AssetTable();
		}
		return instance;
	}
	
	protected AssetTable(){
		observerList = new ArrayList<TableObserver>();
		
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(OWNERID_COLUMN_NAME);
		columnNames.add(CUSTODIANID_COLUMN_NAME);
		columnNames.add(TYPEID_COLUMN_NAME);
		columnNames.add(MAINTID_COLUMN_NAME);
		columnNames.add(CLASSID_COLUMN_NAME);
		columnNames.add(STORAGEID_COLUMN_NAME);
		columnNames.add(PERIODID_COLUMN_NAME);
		columnNames.add(DATEACQUIRED_COLUMN_NAME);
		columnNames.add(FINANCIAL_COLUMN_NAME);
		columnNames.add(CONFIDENTIALITY_COLUMN_NAME);
		columnNames.add(INTEGRITY_COLUMN_NAME);
		columnNames.add(AVAILABILITY_COLUMN_NAME);
		
		assetList = new ArrayList<Asset>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllAssets();
		statement.executeStatement();
		assetList = statement.getResultList();
	}
	
	public void addEntry(Asset asset){
		assetList.add(asset);
		System.out.println("Type of asset, index 0: "+assetList.get(0).getTypeID());
		//System.out.println("Name of asset, index 1: "+assetList.get(1).getName());
		NonQuery statement = new NewAsset(asset);
		statement.executeStatement();
		
		Query getID = new GetMaxIDAsset();
		getID.executeStatement();
		
		asset.setID((Integer)getID.getResultList().get(0));
		
		this.notifyObservers();
	}
	
	public void editEntry(Asset asset) {
		ArrayList<String> values = asset.getValues();
		values.remove(Asset.ID_INDEX);
		
		Query queryStatement = new SelectAssetID(values.get(0));
		queryStatement.executeStatement();
		
		NonQuery statement = new UpdateAsset(values,(Integer)queryStatement.getResultList().get(0));
		statement.executeStatement();
		
		fillData();
		this.notifyObservers();
	}
	
	/*
	 * YOU CANT DELETE AN ASSET
	public void deleteEntry(Asset asset){
		assetList.add(asset);
		NonQuery statement = new DeleteAsset(asset);
		statement.executeStatement();	
	}*/
	
	public ArrayList<Asset> getAllEntries() {
		return assetList;
	}

	public Asset getEntry(int ID) {
		for(Asset asset:assetList)
			if(asset.getID() == ID)
				return asset;
		return null;
	}

	public DefaultTableModel createTableModel(){
		DefaultTableModel model = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			}};
			
			model.addColumn("ID");
			model.addColumn("Name");
			
			for(Asset asset : getAllEntries()){
				Vector<Object> row = new Vector<Object>();
				
				row.add(asset.getID());
				row.add(asset.getName());
				
				model.addRow(row);
			}
			
		return model;
	}
}
