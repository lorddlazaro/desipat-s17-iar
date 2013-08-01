package databaseTableObjects;

public abstract class TableEntry {
	private int key;
	
	public void setKey(int key){
		this.key = key;
	}
	public int getKey(){
		return key;
	}
}
