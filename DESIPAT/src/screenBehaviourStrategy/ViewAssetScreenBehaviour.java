package screenBehaviourStrategy;

import java.awt.event.MouseEvent;

import dataObjects.Asset;
import dataObjects.AssetTable;
import screens.MainScreen;
import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy {
	
	private ViewAssetScreen view;
	private MainScreenBehaviourStrategy main;

	public ViewAssetScreenBehaviour(MainScreenBehaviourStrategy main){
		 view = new ViewAssetScreen(this);
		 this.main = main;
		 AssetTable.getInstance().registerObserver(view);
	}
	public ViewAssetScreen getView(){ 
		return view;
	}
	public void selectAsset() {
		int selectedrow = view.getAssetTable().getSelectedRow();
		
		System.out.println("selected row "+selectedrow);
		int selectedAssetIdentifier = (int)view.getAssetTable().getModel().getValueAt(selectedrow, 0);
		
		
		Asset asset = AssetTable.getInstance().getEntry(selectedAssetIdentifier);
		view.getLblAvailabilityValue().setText(String.valueOf(asset.getAvailabilityValue()));
		view.getLblClassification().setText(String.valueOf(asset.getClassID()));
		view.getLblConfidentialValue().setText(String.valueOf(asset.getConfidentialValue()));
		view.getLblCustodian().setText(String.valueOf(asset.getCustodianID()));
		view.getLblDateAcquired().setText(String.valueOf(asset.getDateAcquired()));
		view.getLblFinancialValue().setText(String.valueOf(asset.getFinancialValue()));
		view.getLblIdentifier().setText(String.valueOf(asset.getID()));
		view.getLblIntegrityValue().setText(String.valueOf(asset.getIntegrityValue()));
		view.getLblMaintenance().setText(String.valueOf(asset.getMaintID()));
		view.getLblName().setText(String.valueOf(asset.getName()));
		view.getLblOwner().setText(String.valueOf(asset.getOwnerID()));
		view.getLblStorageLocation().setText(String.valueOf(asset.getStorageID()));
		view.getLblType().setText(String.valueOf(asset.getTypeID()));
		


	}
	public void addAsset() {
		main.gotoAddAssetScreen();
	}
	public void updateAsset() {
		main.gotoEditAssetScreen();
	}
	

}
