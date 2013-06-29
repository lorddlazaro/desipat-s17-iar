import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;


public class AdminUserScreen extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public AdminUserScreen() {
		setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePanel.setBounds(10, 56, 692, 258);
		add(tablePanel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"UserID", "Username", "Clearance", "Last Name", "First Name"
			}
		));
		table.setBounds(10, 11, 672, 236);
		tablePanel.add(table);
		
		JLabel lblAdminSettings = new JLabel("Admin Settings");
		lblAdminSettings.setBounds(10, 11, 258, 34);
		add(lblAdminSettings);
		lblAdminSettings.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		detailsPanel.setBounds(10, 325, 692, 158);
		add(detailsPanel);
		detailsPanel.setLayout(null);
		
		JLabel lblUserDetails = new JLabel("User Details");
		lblUserDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserDetails.setBounds(10, 11, 172, 19);
		detailsPanel.add(lblUserDetails);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblUsername.setBounds(10, 52, 73, 14);
		detailsPanel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(84, 49, 195, 20);
		detailsPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 77, 195, 20);
		detailsPanel.add(textField_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword.setBounds(10, 80, 73, 14);
		detailsPanel.add(lblPassword);
		
		JLabel lblClearanceLevel = new JLabel("Clearance:");
		lblClearanceLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblClearanceLevel.setBounds(10, 111, 73, 17);
		detailsPanel.add(lblClearanceLevel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 108, 195, 20);
		detailsPanel.add(comboBox);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFirstName.setBounds(292, 52, 73, 14);
		detailsPanel.add(lblFirstName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(375, 49, 181, 20);
		detailsPanel.add(textField_2);
		
		JLabel lblMiddleInitial = new JLabel("Middle Init:");
		lblMiddleInitial.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMiddleInitial.setBounds(292, 80, 73, 14);
		detailsPanel.add(lblMiddleInitial);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(375, 77, 181, 20);
		detailsPanel.add(textField_3);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLastName.setBounds(292, 111, 73, 14);
		detailsPanel.add(lblLastName);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(375, 108, 181, 20);
		detailsPanel.add(textField_4);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(566, 107, 116, 23);
		detailsPanel.add(btnDeleteUser);
		
		JButton btnChangeDetails = new JButton("Change Details");
		btnChangeDetails.setBounds(566, 76, 116, 23);
		detailsPanel.add(btnChangeDetails);
		
		JButton btnCancelChanges = new JButton("Cancel Changes");
		btnCancelChanges.setBounds(566, 48, 116, 23);
		detailsPanel.add(btnCancelChanges);
		
		JButton btnNewButton = new JButton("Back to Main");
		btnNewButton.setBounds(597, 494, 105, 23);
		add(btnNewButton);

	}
}
