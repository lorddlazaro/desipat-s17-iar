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
		int selectedAssetIdentifier = view.getAssetTableSelectedAssetID();
		
		Asset asset = AssetTable.getInstance().getEntry(selectedAssetIdentifier);
		view.getLblAvailabilityValue().setText(String.valueOf(asset.getAvailabilityValue()));
		view.getLblClassification().setText(String.valueOf(asset.getClassification().getClassification()));
		view.getLblConfidentialValue().setText(String.valueOf(asset.getConfidentialValue()));
		view.getLblCustodian().setText(String.valueOf(asset.getCustodian().getName()));
		view.getLblDateAcquired().setText(String.valueOf(asset.getDateAcquired()));
		view.getLblFinancialValue().setText(String.valueOf(asset.getFinancialValue()));
		view.getLblIdentifier().setText(String.valueOf(asset.getID()));
		view.getLblIntegrityValue().setText(String.valueOf(asset.getIntegrityValue()));
		view.getLblMaintenance().setText(String.valueOf(asset.getMaintenance().getMaintenance()));
		view.getLblName().setText(String.valueOf(asset.getName()));
		view.getLblOwner().setText(String.valueOf(asset.getOwner().getName()));
		view.getLblStorageLocation().setText(String.valueOf(asset.getStorage().getStorageLocation()));
		view.getLblType().setText(String.valueOf(asset.getType().getType()));
		
		view.updateChangeLogTable(selectedAssetIdentifier);
	}
	public void addAsset() {
		main.gotoAddAssetScreen();
	}
	public void updateAsset() {
		/*main.setSelectedAsset(view.)
		main.gotoEditAssetScreen();*/
	}
	

}
