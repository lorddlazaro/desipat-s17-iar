package statements.insertNew;

import dataObjects.ActionLog;
import dataObjects.AssetChangeLog;
import statements.InsertStrategy;

public class NewAssetChangeLog extends InsertStrategy{
	public NewAssetChangeLog(AssetChangeLog a) {
		super("AssetChangeLog",
				"actionID, assetID, assetField, oldValue, newValue",
				a.getActionID()+ ", " + a.getAssetID() + ", '" + a.getAssetField() + "' ,'" + a.getOldValue() +"' ,'"+a.getNewValue()+"'");
	}
}
