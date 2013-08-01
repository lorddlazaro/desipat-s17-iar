package databaseTableObjects;

import java.util.ArrayList;

public abstract class TableEntry {
	protected int ID;
	
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
	public abstract ArrayList<String> getValues();
}
