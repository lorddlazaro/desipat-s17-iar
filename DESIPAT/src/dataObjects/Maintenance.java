package dataObjects;

import java.util.ArrayList;

public class Maintenance extends TableEntry{
	public final static int MAINTENANCE_INDEX = 1;
	
	private String maintSched;
	
	public Maintenance(int ID, String maintSched){
		setID(ID);
		setMaintenance(maintSched);
	}
	
	public String getMaintenance() {
		return maintSched;
	}
	public void setMaintenance(String maintSched) {
		this.maintSched = maintSched;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getMaintenance());
		}
		return values;
	}
}
