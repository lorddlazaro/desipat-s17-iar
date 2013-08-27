package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import dataObjects.Asset;
import dataObjects.AssetChangeLogTable;
import dataObjects.AssetTable;

import screens.TableObserver;
import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy,  TableObserver {
	
	private ViewAssetScreen view;
	private MainScreenBehaviourStrategy main;

	public ViewAssetScreenBehaviour(MainScreenBehaviourStrategy main){
		view = new ViewAssetScreen(this);
		view.setBtnAddAssetListener(new AddAssetButtonListener());
		view.setBtnUpdateAssetListener(new UpdateAssetButtonListener());
		view.setAssetTableMouseAdapter(new AssetTableMouseAdapter());
		
		this.main = main;
		
		AssetTable.getInstance().registerObserver(this);
		refresh();
	}
		
	public ViewAssetScreen getView(){ 
		return view;
	}
		
	//Action Listeners
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

	class AssetTableMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent arg0) {
			selectAsset();
		}
	}
	
	
	//Methods called by the Action Listeners
	public void selectAsset() {
		int selectedAssetIdentifier = view.getSelectedAssetID();
		
		Asset asset = AssetTable.getInstance().getEntry(selectedAssetIdentifier);
		view.displayAsset(asset);	
		view.setSelectedAssetChangeLogTableModel(AssetChangeLogTable.getInstance().createSelectedAssetChageLogTableModel(selectedAssetIdentifier));
	}
	
	public void addAsset() {
		main.gotoAddAssetScreen();
	}
	
	public void updateAsset() {
		main.loadEntry(view.getSelectedAssetID());
		main.gotoEditAssetScreen();
	}
	
	
	
	//Called by TableSubject when notifying observers.
	@Override
	public void refresh() {
		view.setViewAssetTableModel(AssetTable.getInstance().createTableModel());
		//view.setSelectedAssetChangeLogTableModel(AssetChangeLogTable.getInstance().createSelectedAssetChageLogTableModel(view.getAssetTableSelectedAssetID()));
	} 
}
