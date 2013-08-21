package screenBehaviourStrategy;
import java.util.ArrayList;

import dataObjects.PersonTable;
import dataObjects.Person;
import dataObjects.TypeLookUpTable;
import dataObjects.Type;
import dataObjects.StorageTable;
import dataObjects.Storage;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.UserAccountTable;
import dataObjects.Asset;
import screens.AddAssetScreen;
import screens.LoginScreen;
import screens.TableObserver;
import statements.SelectLookUpStrategy;
import statements.lookUp.LookUpMaintenance;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	private AddAssetScreen addAssetScreen;

	public AddAssetScreenBehavior()
	{
		addAssetScreen = new AddAssetScreen(this);
	}
	public void saveAsset() {
		Asset asset = null;
		
		try {
			asset = new Asset(	addAssetScreen.getAssetName(),
								addAssetScreen.getOwnerID(),
								addAssetScreen.getCustodianID(),
								addAssetScreen.getTypeID(),
								addAssetScreen.getMaintenanceID(),
								addAssetScreen.getClassificationID(),
								addAssetScreen.getStorageID(),
								addAssetScreen.getPeriodID(),
								addAssetScreen.getDateAcquired(),
								addAssetScreen.getFinancialValue(),
								addAssetScreen.getConfidentialityValue(),
								addAssetScreen.getIntegrityValue(),
								addAssetScreen.getAvailabilityValue()
								);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		AssetTable.getInstance().addEntry(asset);
	}
	
	public AddAssetScreen getView(){
		return addAssetScreen;
	}
}
