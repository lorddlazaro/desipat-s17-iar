package screenBehaviourStrategy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		fillComboBoxes();
		
		addAssetScreen.addFormButtonActionListener(new formButtonActionListener());
	}
	private void fillComboBoxes(){
		ArrayList arr;
		
		arr = new ArrayList();
		for(Classification classification : ClassificationLookUpTable.getInstance().getAllEntries())
			arr.add(classification);
		addAssetScreen.fillClassificationComboBox(arr);
		
		arr = new ArrayList();
		for(Person person : PersonTable.getInstance().getAllEntries())
			arr.add(person);
		addAssetScreen.fillOwnerComboBox(arr);
		addAssetScreen.fillCustodianComboBox(arr);
		
		arr = new ArrayList();
		for(Type type : TypeLookUpTable.getInstance().getAllEntries())
			arr.add(type);
		addAssetScreen.fillTypeComboBox(arr);
		
		arr = new ArrayList();
		for(Storage storage : StorageTable.getInstance().getAllEntries())
			arr.add(storage);
		addAssetScreen.fillStorageComboBox(arr);
		
		arr = new ArrayList();
		for(RetentionPeriod retentionPeriod : RetentionPeriodLookUpTable.getInstance().getAllEntries())
			arr.add(retentionPeriod);
		addAssetScreen.fillPeriodComboBox(arr);
		
		arr = new ArrayList();
		for(Maintenance maintenance : MaintenanceLookUpTable.getInstance().getAllEntries())
			arr.add(maintenance);
		addAssetScreen.fillMaintenanceComboBox(arr);
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
	
	class formButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			saveAsset();
		}
	}
}
