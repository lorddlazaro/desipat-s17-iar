package screenBehaviourStrategy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import actionLogger.ActionAddAsset;

import dataObjects.Classification;
import dataObjects.ClassificationLookUpTable;
import dataObjects.Maintenance;
import dataObjects.MaintenanceLookUpTable;
import dataObjects.PersonTable;
import dataObjects.Person;
import dataObjects.RetentionPeriod;
import dataObjects.RetentionPeriodLookUpTable;
import dataObjects.TypeLookUpTable;
import dataObjects.Type;
import dataObjects.StorageTable;
import dataObjects.Storage;
import dataObjects.AssetTable;
import dataObjects.Asset;
import errorChecker.FormAssetValidator;
import screens.FormAssetScreen;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	protected FormAssetScreen assetScreen;

	public AddAssetScreenBehavior()
	{
		assetScreen = new FormAssetScreen(this, "Add New Asset", "Add Asset");
		fillComboBoxes();
		
		assetScreen.addFormButtonActionListener(new FormButtonActionListener());
	}
	
	protected void fillComboBoxes(){
		ArrayList arr;
		
		arr = new ArrayList();
		for(Classification classification : ClassificationLookUpTable.getInstance().getAllEntries())
			arr.add(classification);
		assetScreen.fillClassificationComboBox(arr);
		
		arr = new ArrayList();
		for(Person person : PersonTable.getInstance().getAllEntries())
			arr.add(person);
		assetScreen.fillOwnerComboBox(arr);
		assetScreen.fillCustodianComboBox(arr);
		
		arr = new ArrayList();
		for(Type type : TypeLookUpTable.getInstance().getAllEntries())
			arr.add(type);
		assetScreen.fillTypeComboBox(arr);
		
		arr = new ArrayList();
		for(Storage storage : StorageTable.getInstance().getAllEntries())
			arr.add(storage);
		assetScreen.fillStorageComboBox(arr);
		
		arr = new ArrayList();
		for(RetentionPeriod retentionPeriod : RetentionPeriodLookUpTable.getInstance().getAllEntries())
			arr.add(retentionPeriod);
		assetScreen.fillPeriodComboBox(arr);
		
		arr = new ArrayList();
		for(Maintenance maintenance : MaintenanceLookUpTable.getInstance().getAllEntries())
			arr.add(maintenance);
		assetScreen.fillMaintenanceComboBox(arr);
	}
	
	public void saveAsset() {
		Asset asset = null;
		
		try {
			asset = new Asset(	assetScreen.getAssetName(),
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		AssetTable.getInstance().addEntry(asset);
		
		ActionAddAsset action = new ActionAddAsset(assetScreen.getOwnerID(), assetScreen.getAssetName());
		action.logAction();
	}
	
	public FormAssetScreen getView(){
		return assetScreen;
	}
	
	class FormButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			FormAssetValidator formValidator = new FormAssetValidator();
			String errorMsg = formValidator.getErrorWithAssetName(assetScreen.getAssetName())+formValidator.getErrorWithFinancialVal(assetScreen.getFinancialValue());
			
			if(errorMsg.isEmpty())
				saveAsset();
			else
				assetScreen.displayErrorMsg(errorMsg);
		}
	}
}
