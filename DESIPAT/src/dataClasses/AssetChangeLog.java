package dataClasses;

public class AssetChangeLog {
	private int changeID;
	private int actionID;
	private int assetID;
	private String assetField;
	private String oldValue;
	private String newValue;
	public int getChangeID() {
		return changeID;
	}
	public void setChangeID(int changeID) {
		this.changeID = changeID;
	}
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
}
