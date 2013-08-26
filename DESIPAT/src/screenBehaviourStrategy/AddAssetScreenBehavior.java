package screenBehaviourStrategy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

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
import errorChecker.ValidLengthAndCharChecker;
import fields.ObjectInput;
import screens.FormAssetScreen;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	protected FormAssetScreen assetScreen;

	public AddAssetScreenBehavior()
	{
		assetScreen = new FormAssetScreen(this, "Add New Asset", "Add Asset");
		fillComboBoxes();
		
		assetScreen.addFormButtonActionListener(new FormButtonActionListener());
		assetScreen.addStorageNewButtonActionListener(new NewStorageActionListener());
		assetScreen.addOwnerNewButtonActionListener(new NewPersonActionListener());
		assetScreen.addCustodianNewButtonActionListener(new NewPersonActionListener());
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
	
	class NewPersonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox comboBox = (JComboBox) e.getSource();
			if(comboBox.getSelectedItem()!=null){
				String input = comboBox.getSelectedItem().toString();
				
				FormAssetValidator validator = new FormAssetValidator();
				
				String errorMsg = validator.getErrorWithNewPerson(input);
				
				if(!errorMsg.isEmpty()){
					assetScreen.displayErrorMsg(errorMsg);
					return;
				}
				
				//Insert new Person
				Person newPerson = new Person(input);
				if(PersonTable.getInstance().getEntry(newPerson.getFirstName(), ""+newPerson.getMiddleInitial(), newPerson.getLastName()) == null){
					PersonTable.getInstance().addEntry(newPerson);
					fillComboBoxes();
				}
		
			}
		}
	}
	
	class NewStorageActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedStorage= assetScreen.getSelectedStorage();
			if(selectedStorage != null){
				ValidLengthAndCharChecker checker = new ValidLengthAndCharChecker(ValidLengthAndCharChecker.NAME, 20);
				
				String errorMsg = checker.getErrorMsg(selectedStorage);
				if(!errorMsg.isEmpty()){
					assetScreen.displayErrorMsg(errorMsg);
					return;
				}
			
				if (StorageTable.getInstance().getEntry(selectedStorage) == null){
					StorageTable.getInstance().addEntry(new Storage(selectedStorage));
					fillComboBoxes();
				}
			}
		}
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
