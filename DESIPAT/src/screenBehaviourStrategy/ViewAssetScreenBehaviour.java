package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataObjects.Asset;
import dataObjects.AssetChangeLogTable;
import dataObjects.AssetTable;
import screens.MainScreen;
import screens.TableObserver;
import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy,  TableObserver {
	
	private ViewAssetScreen view;
	private MainScreenBehaviourStrategy main;

	public ViewAssetScreenBehaviour(MainScreenBehaviourStrategy main){
		view = new ViewAssetScreen(this);
		view.setBtnAddAssetListener(new AddAssetButtonListener());
		view.setBtnUpdateAssetListener(new UpdateAssetButtonListener());
		this.main = main;
		AssetTable.getInstance().registerObserver(this);
		refresh();
	}
		
	public ViewAssetScreen getView(){ 
		return view;
	}
	
	public void selectAsset() {
		int selectedAssetIdentifier = view.getAssetTableSelectedAssetID();
		
		Asset asset = AssetTable.getInstance().getEntry(selectedAssetIdentifier);
		
		view.setLblIdentifier(String.valueOf(asset.getID()));
		view.setLblName(String.valueOf(asset.getName()));
		view.setLblOwner(String.valueOf(asset.getOwner().getName()));
		view.setLblCustodian(String.valueOf(asset.getCustodian().getName()));
		view.setLblType(String.valueOf(asset.getType().getType()));
		view.setLblDateAcquired(String.valueOf(asset.getDateAcquired()));
		view.setLblMaintenance(String.valueOf(asset.getMaintenance().getMaintenance()));
		view.setLblFinancialValue(String.valueOf(asset.getFinancialValue()));
		view.setLblConfidentialValue(String.valueOf(asset.getConfidentialValue()));
		view.setLblIntegrityValue(String.valueOf(asset.getIntegrityValue()));
		view.setLblAvailabilityValue(String.valueOf(asset.getAvailabilityValue()));
		view.setLblClassification(String.valueOf(asset.getClassification().getClassification()));
		view.setLblStorageLocation(String.valueOf(asset.getStorage().getStorageLocation()));
			
		view.setSelectedAssetChangeLogTableModel(AssetChangeLogTable.getInstance().createSelectedAssetChageLogTableModel(selectedAssetIdentifier));
	}
	public void addAsset() {
		main.gotoAddAssetScreen();
	}
	public void updateAsset() {
		main.loadEntry(view.getAssetTableSelectedAssetID());
		main.gotoEditAssetScreen();
	}
	
	
	class AddAssetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addAsset();
		}		
	}
	
	class UpdateAssetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			updateAsset();
		}
	}

	@Override
	public void refresh() {
		view.setViewAssetTableModel(AssetTable.getInstance().createTableModel());
		view.setSelectedAssetChangeLogTableModel(AssetChangeLogTable.getInstance().createSelectedAssetChageLogTableModel(view.getAssetTableSelectedAssetID()));
	} 
}
