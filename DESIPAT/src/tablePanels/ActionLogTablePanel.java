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
import dataObjects.ActionLogTable;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.TableSubject;

public abstract class ActionLogTablePanel extends TablePanel implements TableObserver{
	private JTable table;
	ActionLogTable actionLogTable;
	
	public void initialize(){
		
		setBounds(12, 50, 748, 162);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getViewport().setBackground(Color.LIGHT_GRAY);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		setViewportView(table);
	}
	
	public void fillTable(TableSubject tableSubject){
		actionLogTable = (ActionLogTable)tableSubject;
		actionLogTable.registerObserver(this);
		ArrayList<TableEntry> actionLogList = actionLogTable.getAllEntries();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("User");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Header");
		model.addColumn("Description");
		for(TableEntry tableEntry:actionLogList){
			ActionLog actionLog = (ActionLog)tableEntry;
			Vector<Object> row = new Vector<Object>();
			row.add(actionLog.getUserID());
			row.add(actionLog.getActionDate());
			row.add(actionLog.getActionTime());
			row.add(actionLog.getActionHeaderID());
			row.add(actionLog.getActionDesc());
			
			model.addRow(row);
		}
		
	}
	public void refresh(){
		this.revalidate();
	}
}
