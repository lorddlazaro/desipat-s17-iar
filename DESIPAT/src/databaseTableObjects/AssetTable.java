package databaseTableObjects;

import java.util.ArrayList;

import statementStrategies.DeleteStrategy;

import dbHandler.NonQuery;

public class AssetTable extends TableSubject{
	//private ArrayList<Asset> assetList;	
	NonQuery statement;
	public void addEntry(TableEntry tableEntry){
		Asset asset=(Asset)tableEntry;
		entryList.add(tableEntry);
		//TODO: add entry to Asset DB
		statement=new InsertStrategy("Asset", /*tableEntry.values*/,"name, ownerID, custodianID, typeID, maintID, classID, storageID, periodID, dateAcquired, financialValue, confidentialValue, integrityValue, availabilityValue");
		statement.executeStatement();
	}
	public void deleteEntry(TableEntry tableEntry){
		/*Asset asset=(Asset)tableEntry;
		statement=new DeleteStrategy("Asset",asset.getID());
		statement.executeStatement();*/
	}
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;}
	public TableEntry getEntry(int key){ 
		return entryList.get(key);}
}
