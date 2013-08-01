package databaseTableObjects;

public abstract class TableEntry {
	protected int ID;
	
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
}
