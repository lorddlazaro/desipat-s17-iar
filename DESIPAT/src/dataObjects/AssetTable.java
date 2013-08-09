package dataObjects;

import java.sql.ResultSet;
import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteStrategy;
import statements.DeleteUser;
import statements.insertNew.NewAsset;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllUsers;

import dbHandler.NonQuery;
import dbHandler.Query;

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
		Query statement = new SelectAllUsers();
		statement.executeStatement();
		try{
			ResultSet rs = statement.getResult();
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					Asset asset = new Asset(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getDate(10),rs.getFloat(11),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					assetList.add(asset);
					rs.next();
				}
			}
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addEntry(Asset asset){
		assetList.add(asset);
		
		//TODO: add entry to Asset DB
		NonQuery statement=new NewAsset(asset);
		statement.executeStatement();
	}
	
	public void editEntry(Asset asset) {
		// TODO Auto-generated method stub
	}
	
	public void deleteEntry(Asset asset){
		// TODO Auto-generated method stub
	}

	public ArrayList<Asset> getAllEntries() {
		return assetList;
	}

	public Asset getEntry(int ID) {
		for(Asset asset:assetList)
			if(asset.getID() == ID)
				return asset;
		return null;
	}
}
