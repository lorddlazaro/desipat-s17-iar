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
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;

public class UserAccountTablePanel extends TablePanel implements TableObserver{
	private JTable table;
	UserAccountTable userAccountTable;
	
	public void initialize(){
		
		setBounds(0, 0, 752, 240);
		
		table = new JTable();
		//table.addMouseListener(new MouseAdapter();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		//setViewportView(table);
	}
	
	
	public JTable getTable(){
		return table;
	}
	
	public void fillTable(UserAccountTable userAccountTable){
		this.userAccountTable = userAccountTable;
		userAccountTable.registerObserver(this);
		ArrayList<UserAccount> userAccountList = userAccountTable.getAllEntries(true);
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("UserID");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Clearance");
		for(TableEntry tableEntry:userAccountList){
			UserAccount actionLog = (UserAccount)tableEntry;
			Vector<Object> row = new Vector<Object>();
			row.add(actionLog.getPersonID());
			row.add(actionLog.getUsername());
			row.add(actionLog.getPassword());
			row.add(actionLog.getClearanceID());
			
			model.addRow(row);
		}	
	}

	@Override
	protected void fillTable() {
		// TODO Auto-generated method stub
		
	}
}
