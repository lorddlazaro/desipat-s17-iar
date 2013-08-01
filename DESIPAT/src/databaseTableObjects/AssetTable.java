package databaseTableObjects;

import java.util.ArrayList;

import dbHandler.Query;

public class AssetTable extends TableSubject{
	//private ArrayList<Asset> assetList;	
	Query query;
	public void addEntry(TableEntry tableEntry){
		Asset asset=(Asset)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		query=new InsertStrategy("Asset", /*tableEntry.values*/,"name, ownerID, custodianID, typeID, maintID, classID, storageID, periodID, dateAcquired, financialValue, confidentialValue, integrityValue, availabilityValue");
		query.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		Asset asset=(Asset)tableEntry;
		query=new DeleteStrategy("Asset",asset.getID());
		query.executeStatement();
	}
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);}
}
