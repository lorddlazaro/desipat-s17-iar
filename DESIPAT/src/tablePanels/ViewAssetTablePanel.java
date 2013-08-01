package tablePanels;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import screens.TableObserver;

import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.TableSubject;

public abstract class ViewAssetTablePanel extends TablePanel implements TableObserver{
	private JTable table;
	AssetTable assetTable;
	
	public void initialize(){
		setBounds(10, 61, 205, 382);
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//TODO: connect
				//updateLabels();
			}
		});
	}
	
	public void fillTable(TableSubject tableSubject){
		assetTable = (AssetTable)tableSubject;
		assetTable.registerObserver(this);
		ArrayList<TableEntry> assetList = assetTable.getAllEntries();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Name");
		for(TableEntry tableEntry:assetList){
			Asset asset = (Asset)tableEntry;
			Vector<Object> row = new Vector<Object>();
			row.add(asset.getID());
			row.add(asset.getName());
			
			model.addRow(row);
		}
		table.setModel(model);
	}
}
