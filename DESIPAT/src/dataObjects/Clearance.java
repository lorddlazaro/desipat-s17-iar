package dataObjects;

import java.util.ArrayList;

public class Clearance extends TableEntry{
	public final static int CLEARANCELEVEL_INDEX = 1;
	
	private String clearanceLevel;
	
	public Clearance(int ID, String clearanceLevel){
		setID(ID);
		setClearanceLevel(clearanceLevel);
	}
	
	public String getClearanceLevel() {
		return clearanceLevel;
	}
	public void setClearanceLevel(String clearanceLevel) {
		this.clearanceLevel = clearanceLevel;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getClearanceLevel());
		}
		return values;
	}
}
