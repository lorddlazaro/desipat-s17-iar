package tablePanels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dataObjects.ActionLog; 
import dataObjects.ActionLogTable;

public class ActionLogTablePanel extends TablePanel{
	
	public ActionLogTablePanel(String title){
		super(title);
		
		ActionLogTable.getInstance().registerObserver(this);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	protected void fillTable(){
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("User");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Header");
		model.addColumn("Description");
		
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat time = new SimpleDateFormat("hh:mm");
		
		for(ActionLog actionLog : ActionLogTable.getInstance().getAllEntries()){
			Vector<Object> row = new Vector<Object>();
			
			row.add(actionLog.getUser().getUsername());
			row.add(date.format(actionLog.getActionDate()));
			row.add(time.format(actionLog.getActionTime()));
			row.add(actionLog.getActionHeader().getActionHeader());
			row.add(actionLog.getActionDesc());
			
			model.addRow(row);
		}
		
		table.setModel(model);
	}
}
