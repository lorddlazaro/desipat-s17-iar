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
	
	protected void fillTable(){
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("User");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("New Value");
		model.addColumn("Old Value");
		
		Asset selectedAsset = AssetTable.getInstance().getEntry(selectedAssetID);

		if(selectedAsset != null){
			 
			Vector<Object> row = new Vector<Object>();
			ArrayList<AssetChangeLog> list = AssetChangeLogTable.getInstance().getAllEntries();
			
			for(AssetChangeLog assetChangeLog: list)
				if(assetChangeLog.getAssetID() == selectedAsset.getID()){
					row.add(assetChangeLog.getActionLog().getActionDate());
					row.add(assetChangeLog.getActionLog().getActionTime());
					row.add(assetChangeLog.getActionLog().getUser().getUsername());
					row.add(assetChangeLog.getAsset());
					row.add(assetChangeLog.getAssetField());
					row.add(assetChangeLog.getOldValue());
					row.add(assetChangeLog.getNewValue());	
				}
			
			model.addRow(row);
		}
		
		table.setModel(model);
	}
	
	public void changeSelectedAsset(int selectedAssetID){
		this.selectedAssetID = selectedAssetID;
		refresh();
	}
}
