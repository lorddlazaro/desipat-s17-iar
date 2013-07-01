import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class LogScreen extends JPanel {
	private JTable actionLogTable;
	
	private DBConnection dbHandler;
	private Connection conn;
	private JTable assetChangeLogTable;

	/**
	 * Create the panel.
	 */
	public LogScreen() {
		setBackground(new Color(255, 250, 205));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 748, 169);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		scrollPane.getViewport().setBackground(Color.LIGHT_GRAY);
		
		actionLogTable = new JTable();
		actionLogTable.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane.setViewportView(actionLogTable);
		actionLogTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User", "Date", "Time", "Header", "Description"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 273, 748, 169);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane_1);
		scrollPane_1.getViewport().setBackground(Color.LIGHT_GRAY);
		
		assetChangeLogTable = new JTable();
		assetChangeLogTable.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetChangeLogTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User", "Date", "Time", "Asset", "Field", "New Value", "Old Value"
			}
		));
		
		scrollPane_1.setViewportView(assetChangeLogTable);
		
		JLabel lblNewLabel = new JLabel("Action Log");
		lblNewLabel.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 752, 38);
		add(lblNewLabel);
		
		JLabel lblAssetChangeLog = new JLabel("Asset Change Log");
		lblAssetChangeLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssetChangeLog.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAssetChangeLog.setBounds(12, 235, 752, 38);
		add(lblAssetChangeLog);

		fillTableActionLog();
		fillTableAssetChangeLog();
	}
	

	public void fillTableAssetChangeLog(){
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		DefaultTableModel model = (DefaultTableModel)assetChangeLogTable.getModel();
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT u.username, al.actionDate, al.actionTime, a.name, acl.assetfield, acl.oldvalue, acl.newvalue  FROM UserAccount AS u, ActionLog AS al, assetchangelog as acl, asset as a WHERE u.userID = al.userID and acl.actionid = al.actionid and a.identifier = acl.assetid;");
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7)});
					rs.next();
				}
			}

			dbHandler.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fillTableActionLog() {
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		DefaultTableModel model = (DefaultTableModel)actionLogTable.getModel();
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT u.username, al.actionDate, al.actionTime, alu.actionHeader, al.actiondesc FROM UserAccount AS u, ActionLog AS al, ActionHeaderLookup alu WHERE u.userID = al.userID AND al.actionheaderid = alu.actionheaderid;");
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)});
					rs.next();
				}
			}

			dbHandler.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
