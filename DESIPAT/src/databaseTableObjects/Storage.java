package databaseTableObjects;

public class Storage extends TableEntry{
	private int ID;
	private String storageLocation;
	
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
}
