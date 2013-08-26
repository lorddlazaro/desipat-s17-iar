package tablePanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.ViewAssetScreenBehaviourStrategy;

import dataObjects.Asset;
import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;
import dataObjects.AssetTable;

public class SelectedAssetChangeLogTablePanel extends TablePanel{
	
	ViewAssetScreenBehaviourStrategy controller;

	public SelectedAssetChangeLogTablePanel(ViewAssetScreenBehaviourStrategy newController){
		super();
		
		this.controller = newController;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
