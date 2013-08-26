package tablePanels;


import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.LogsScreenBehaviorStrategy;


public class AssetChangeLogTablePanel extends TablePanel{
	
	LogsScreenBehaviorStrategy controller;
	
	public AssetChangeLogTablePanel(LogsScreenBehaviorStrategy newController){
		super();
		
		this.controller = newController;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public void fillTable(DefaultTableModel model){
		table.setModel(model);
	}
}
