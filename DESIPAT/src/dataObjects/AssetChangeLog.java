package dataObjects;

import java.util.ArrayList;

public class AssetChangeLog extends TableEntry{
	public final static int ACTIONID_INDEX = 1;
	public final static int ASSETID_INDEX = 2;
	public final static int ASSETFIELD_INDEX = 3;
	public final static int OLDVALUE_INDEX = 4;
	public final static int NEWVALUE_INDEX = 5;
	
	private int actionID;
	private int assetID;
	private String assetField;
	private String oldValue;
	private String newValue;
	
	public AssetChangeLog(int ID, int actionID, int assetID, String assetField, String oldValue, String newValue){
		setID(ID);
		setActionID(actionID);
		setAssetID(assetID);
		setAssetField(assetField);
		setOldValue(oldValue);
		setNewValue(newValue);
	}
	
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
	}
	public ActionLog getActionLog() {
		return ActionLogTable.getInstance().getEntry(actionID);
	}
	public int getAssetID() {
		return assetID;
	}
	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}
	public Asset getAsset() {
		return AssetTable.getInstance().getEntry(assetID);
	}
	public String getAssetField() {
		return assetField;
	}
	public void setAssetField(String assetField) {
		this.assetField = assetField;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public ArrayList<String> getValues() {
		if(values != null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(String.valueOf(getActionID()));
			values.add(String.valueOf(getAssetID()));
			values.add(getOldValue());
			values.add(getNewValue());
		}
		return values;
	}
}
