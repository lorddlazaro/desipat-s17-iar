package tablePanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.EditAssetScreenBehavior;
import screenBehaviourStrategy.LogsScreenBehaviorStrategy;

import dataObjects.ActionLog; 
import dataObjects.ActionLogTable;

public class ActionLogTablePanel extends TablePanel{
	
	LogsScreenBehaviorStrategy  controller;
	
	public ActionLogTablePanel(LogsScreenBehaviorStrategy  newController){
		super();
		
		this.controller = newController;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public void fillTable(DefaultTableModel model){	
		table.setModel(model);
	}
}
