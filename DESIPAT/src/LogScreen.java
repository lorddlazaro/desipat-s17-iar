import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;


public class LogScreen extends JPanel {
	private JTable table;
	
	private DBConnection dbHandler;
	private Connection conn;

	/**
	 * Create the panel.
	 */
	public LogScreen() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(86, 39, 655, 205);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
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

		fillTable();
	}
	

	public void fillTable() {
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
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
