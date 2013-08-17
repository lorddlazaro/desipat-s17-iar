package tablePanels;

import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;

public class AssetChangeLogTablePanel extends TablePanel{
	
	public AssetChangeLogTablePanel(String title){
		super(title);
		
		AssetChangeLogTable.getInstance().registerObserver(this);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	protected void fillTable(){
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Action");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("New Value");
		model.addColumn("Old Value");
		
		for(AssetChangeLog assetChangeLog : AssetChangeLogTable.getInstance().getAllEntries()){
			Vector<Object> row = new Vector<Object>();
			
			row.add(assetChangeLog.getActionID());
			row.add(assetChangeLog.getAssetID());
			row.add(assetChangeLog.getAssetField());
			row.add(assetChangeLog.getOldValue());
			row.add(assetChangeLog.getNewValue());
			
			model.addRow(row);
		}
		
		table.setModel(model);
	}
}
