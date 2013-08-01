package dataObjects;

import java.util.ArrayList;

import statements.DeleteStrategy;
import statements.DeleteUser;
import statements.insertNew.NewAsset;
import statements.insertNew.NewUser;

import dbHandler.NonQuery;

public class AssetTable extends TableSubject{
	//private ArrayList<Asset> assetList;	
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
	private ArrayList<String> columnNames;
	
	public AssetTable(){
		assetList = new ArrayList<Asset>();
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
	}
	
	public void addEntry(TableEntry tableEntry){
		Asset asset=(Asset)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		NonQuery statement=new NewAsset(asset);
		statement.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		/*Asset asset=(Asset)tableEntry;
		statement=new DeleteStrategy("Asset",asset.getID());
		statement.executeStatement();*/
	}
	/*public ArrayList<TableEntry> getAllEntries(){
		return entryList;}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);}*/
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	@Override
	public void editEntry(TableEntry tableEntry) {
		// TODO Auto-generated method stub
		
	}
}







