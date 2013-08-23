package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import screenBehaviourStrategy.AddAssetScreenBehavior.formButtonActionListener;
import screens.FormAssetScreen;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.Storage;
import dataObjects.StorageTable;
import dataObjects.TableEntry;
import dataObjects.Type;
import dataObjects.TypeLookUpTable;

public class EditAssetScreenBehavior extends AddAssetScreenBehavior {

	public EditAssetScreenBehavior()
	{
		assetScreen = new FormAssetScreen(this, "Edit Existing Asset", "Edit Asset");
		fillComboBoxes();

		assetScreen.addFormButtonActionListener(new formButtonActionListener());
	}
	
	public void editAsset() {
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

		AssetTable.getInstance().editEntry(asset);
	}
	
	public FormAssetScreen getView(){
		return assetScreen;
	}
	
	class formButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			editAsset();
		}
	}
}
