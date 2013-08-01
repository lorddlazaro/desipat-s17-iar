package dataObjects;

import java.util.ArrayList;

public class AssetChangeLog extends TableEntry{
	private int actionID;
	private int assetID;
	private String assetField;
	private String oldValue;
	private String newValue;
	
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
	}
	public int getAssetID() {
		return assetID;
	}
	public void setAssetID(int assetID) {
		this.assetID = assetID;
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
