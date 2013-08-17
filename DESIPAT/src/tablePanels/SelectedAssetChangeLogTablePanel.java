package tablePanels;

import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;

public class SelectedAssetChangeLogTablePanel extends TablePanel{
	
	private int selectedAssetID;
	
	public SelectedAssetChangeLogTablePanel(){
		super();
		
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
		
		AssetChangeLog assetChangeLog = AssetChangeLogTable.getInstance().getEntry(selectedAssetID);
		
		if(assetChangeLog != null){
			Vector<Object> row = new Vector<Object>();
				
			row.add(assetChangeLog.getActionLog().getActionDate());
			row.add(assetChangeLog.getActionLog().getActionTime());
			row.add(assetChangeLog.getActionLog().getUser().getUsername());
			row.add(assetChangeLog.getAsset());
			row.add(assetChangeLog.getAssetField());
			row.add(assetChangeLog.getOldValue());
			row.add(assetChangeLog.getNewValue());	
			
			model.addRow(row);
		}
		
		table.setModel(model);
	}
	
	public void changeSelectedAsset(int selectedAssetID){
		this.selectedAssetID = selectedAssetID;
		refresh();
	}
}
