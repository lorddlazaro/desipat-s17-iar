import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class LogScreen extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public LogScreen() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 30, 196, 205);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"admin", "2013-07-01", "09:28:21", "Log In", "Logged In"},
			},
			new String[] {
				"User", "Date", "Time", "Header", "Description"
			}
		));

	}
}
