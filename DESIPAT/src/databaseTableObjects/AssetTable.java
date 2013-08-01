package databaseTableObjects;

import java.util.ArrayList;

public class AssetTable extends TableSubject{
	private ArrayList<Asset> assetList;	
	
	public void addEntry(TableEntry tableEntry){}
	public void deleteEntry(TableEntry tableEntry){}
	public ArrayList<TableEntry> getAllEntries(){return new ArrayList<TableEntry>();}
	public TableEntry getEntry(int key){ return new Asset();}
}
