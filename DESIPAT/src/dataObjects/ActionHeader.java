package dataObjects;

import java.util.ArrayList;

public class ActionHeader extends TableEntry{
	public final static int ACTIONHEADER_INDEX = 1;
	
	private String actionHeader;
	
	public ActionHeader(int ID, String actionHeader){
		setID(ID);
		setActionHeader(actionHeader);
	}
	
	public String getActionHeader() {
		return actionHeader;
	}
	public void setActionHeader(String actionHeader) {
		this.actionHeader = actionHeader;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getActionHeader());
		}
		return values;
	}
}
