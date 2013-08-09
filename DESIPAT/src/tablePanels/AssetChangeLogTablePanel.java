package tablePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import screens.TableObserver;

import dataObjects.ActionLog;
import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.TableSubject;

public abstract class AssetChangeLogTablePanel extends TablePanel implements TableObserver{
	private JTable table;
	AssetChangeLogTable assetChangeLogTable;
	
	public void initialize(){
		
		setBounds(12, 273, 748, 169);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getViewport().setBackground(Color.LIGHT_GRAY);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		setViewportView(table);
	}
	
	public void fillTable(AssetChangeLogTable assetChangeLogTable){
		this.assetChangeLogTable = assetChangeLogTable;
		assetChangeLogTable.registerObserver(this);
		ArrayList<AssetChangeLog> assetChangeLogList = assetChangeLogTable.getAllEntries();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Action");
		model.addColumn("Asset");
		model.addColumn("Field");
		model.addColumn("New Value");
		model.addColumn("Old Value");
		for(TableEntry tableEntry:assetChangeLogList){
			AssetChangeLog assetChangeLog = (AssetChangeLog)tableEntry;
			Vector<Object> row = new Vector<Object>();
			row.add(assetChangeLog.getActionID());
			row.add(assetChangeLog.getAssetID());
			row.add(assetChangeLog.getAssetField());
			row.add(assetChangeLog.getOldValue());
			row.add(assetChangeLog.getNewValue());
			
			model.addRow(row);
		}
		
	}
}
