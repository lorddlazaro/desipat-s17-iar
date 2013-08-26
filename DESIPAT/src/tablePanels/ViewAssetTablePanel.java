package tablePanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.ViewAssetScreenBehaviourStrategy;

import dataObjects.Asset;
import dataObjects.AssetTable;

public class ViewAssetTablePanel extends TablePanel{
	
	ViewAssetScreenBehaviourStrategy controller;
	
	public ViewAssetTablePanel(ViewAssetScreenBehaviourStrategy newController){
		super();
		
		this.controller = newController;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				controller.selectAsset();
			}
		});
	}
	
	
	public void fillTable(DefaultTableModel model){	
		table.setModel(model);
	}
	
	public int getSelectedAssetID(){
		if(table.getSelectedRow() != -1)
			return (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
		else
			return -1;
	}
}
