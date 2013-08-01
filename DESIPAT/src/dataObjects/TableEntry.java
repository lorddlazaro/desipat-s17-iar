package dataObjects;

import java.util.ArrayList;

public abstract class TableEntry {
	protected int ID;
	protected ArrayList<String> values;
	
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
	public abstract ArrayList<String> getValues();
}
