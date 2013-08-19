package dataObjects;

import java.util.ArrayList;

public class Type extends TableEntry{
	public final static int TYPE_INDEX = 1;
	
	private String type;
	
	public Type(int ID, String type){
		setID(ID);
		setType(type);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getType());
		}
		return values;
	}
	public String toString(){
		return this.getType();
	}
}
