package tablePanels;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dataObjects.Asset;
import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;
import dataObjects.AssetTable;

public class SelectedAssetChangeLogTablePanel extends TablePanel{
	
	private int selectedAssetID;
	
	public SelectedAssetChangeLogTablePanel(){
		super();
		
		selectedAssetID = - 1;
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/*
	public void changeSelectedAsset(int selectedAssetID){
		this.selectedAssetID = selectedAssetID;
		refresh();
	}
*/
	public void fillTable(DefaultTableModel model) {
		table.setModel(model);
	}
}
