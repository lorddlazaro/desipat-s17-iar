package tablePanels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("User");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("Old Value");
		model.addColumn("New Value");
		
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat time = new SimpleDateFormat("hh:mm");
		
		for(AssetChangeLog assetChangeLog : AssetChangeLogTable.getInstance().getAllEntries()){
			Vector<Object> row = new Vector<Object>();
			
			row.add(date.format(assetChangeLog.getActionLog().getActionDate()));
			row.add(time.format(assetChangeLog.getActionLog().getActionTime()));
			row.add(assetChangeLog.getActionLog().getUser().getUsername());
			row.add(assetChangeLog.getAsset().getName());
			row.add(assetChangeLog.getAssetField());
			row.add(assetChangeLog.getOldValue());
			row.add(assetChangeLog.getNewValue());
			
			model.addRow(row);
		}
		
		table.setModel(model);
	}
}
