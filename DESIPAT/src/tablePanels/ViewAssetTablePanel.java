package tablePanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.ViewAssetScreenBehaviourStrategy;
import screens.TableObserver;

import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.TableSubject;

public class ViewAssetTablePanel extends TablePanel implements TableObserver{
	private JTable table;
	AssetTable assetTable;
	ViewAssetScreenBehaviourStrategy controller;
	
	public ViewAssetTablePanel(ViewAssetScreenBehaviourStrategy controller){
		this.controller = controller;
	}
	
	public void initialize(){
		setBounds(10, 61, 205, 382);
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Before Controller");
				controller.selectAsset();
				System.out.println("after Controller");
			}});
	}
	
	public JTable getTable(){
		return table;
	}
	
	public void fillTable(AssetTable assetTable){
		this.assetTable = assetTable;
		assetTable.registerObserver(this);
		ArrayList<Asset> assetList = assetTable.getAllEntries();
		
		DefaultTableModel model = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }};
		
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
