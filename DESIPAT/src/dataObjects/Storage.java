package dataObjects;

import java.util.ArrayList;

public class Storage extends TableEntry{
	public final static int STORAGELOCATION_INDEX = 1;
	
	private String storageLocation;
	
	public Storage(int ID, String storageLocation){
		setID(ID);
		setStorageLocation(storageLocation);
	}
	
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getStorageLocation());
		}
		return values;
	}
}
