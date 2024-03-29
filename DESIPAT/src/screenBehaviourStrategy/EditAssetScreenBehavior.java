package screenBehaviourStrategy;

import actionLogger.ActionUpdateAsset;
import assetLogger.AssetEdited;

import screens.FormAssetScreen;
import screens.MainScreen;
import screens.TableObserver;
import screens.ViewAssetScreen;
import statements.getMax.GetMaxIDActionLog;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dbHandler.Query;


public class EditAssetScreenBehavior extends AddAssetScreenBehavior{

	public EditAssetScreenBehavior()
	{
		assetScreen = new FormAssetScreen(this, "Edit Existing Asset", "Edit Asset");
		fillComboBoxes();

		assetScreen.addFormButtonActionListener(new FormButtonActionListener());
	}
	
	public void saveAsset() {
		Asset editedAsset = null;
		
		try {
			editedAsset = new Asset(
								assetScreen.getAssetName(),
								assetScreen.getOwnerID(),
								assetScreen.getCustodianID(),
								assetScreen.getTypeID(),
								assetScreen.getMaintenanceID(),
								assetScreen.getClassificationID(),
								assetScreen.getStorageID(),
								assetScreen.getPeriodID(),
								assetScreen.getDateAcquired(),
								assetScreen.getFinancialValue(),
								assetScreen.getConfidentialityValue(),
								assetScreen.getIntegrityValue(),
								assetScreen.getAvailabilityValue()
								);
			
			editedAsset.setID(assetScreen.getAssetID());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//will be true if user made a change. else, don't edit and don't log.
		
		
		Asset oldAsset = AssetTable.getInstance().getEntry(editedAsset.getID());
		
		if(!oldAsset.equals(editedAsset)){
		
			ActionUpdateAsset action = new ActionUpdateAsset(MainScreen.getCurrentUser().getID(), assetScreen.getAssetName());
			action.logAction();
			
			Query getID = new GetMaxIDActionLog();
			getID.executeStatement();
			
			AssetEdited editAction = new AssetEdited((Integer)getID.getResultList().get(0), editedAsset);
			editAction.logAction();
			
			AssetTable.getInstance().editEntry(editedAsset);
		}
	}
	
	public FormAssetScreen getView(){
		return assetScreen;
	}
}
