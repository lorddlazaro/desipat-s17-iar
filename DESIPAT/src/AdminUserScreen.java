import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminUserScreen extends JPanel {
	private JTable userTable;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField firstNameTextField;
	private JTextField middleInitTextField;
	private JTextField lastNameTextField;
	private JComboBox <String> clearanceComboBox;
	private JPanel tablePanel;
	private JScrollPane scrollPane;
	private JLabel lblAdminSettings;
	private JPanel detailsPanel;
	private JLabel lblUserDetails;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblClearanceLevel;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JLabel lblLastName;
	private JButton btnDeleteUser;
	private JButton btnChangeDetails;
	private JButton btnCancelChanges;
	private JButton addUserButton;
	private JButton btnNewButton;
	
	private DBConnection dbHandler;
	private Connection conn;
	
	/**
	 * Create the panel.
	 */
	public AdminUserScreen() {
		setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePanel.setBounds(10, 56, 692, 258);
		add(tablePanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 692, 258);
		tablePanel.add(scrollPane);
		
		userTable = new JTable();
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedTable();
			}
		});
		scrollPane.setViewportView(userTable);
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UserID", "Username", "Password", "Clearance", "First Name", "Middle Initial", "Last Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		lblAdminSettings = new JLabel("Admin Settings");
		lblAdminSettings.setBounds(10, 11, 258, 34);
		add(lblAdminSettings);
		lblAdminSettings.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		detailsPanel = new JPanel();
		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		detailsPanel.setBounds(10, 325, 692, 158);
		add(detailsPanel);
		detailsPanel.setLayout(null);
		
		lblUserDetails = new JLabel("User Details");
		lblUserDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserDetails.setBounds(10, 11, 172, 19);
		detailsPanel.add(lblUserDetails);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblUsername.setBounds(10, 52, 73, 14);
		detailsPanel.add(lblUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(84, 49, 195, 20);
		detailsPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(84, 77, 195, 20);
		detailsPanel.add(passwordTextField);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword.setBounds(10, 80, 73, 14);
		detailsPanel.add(lblPassword);
		
		lblClearanceLevel = new JLabel("Clearance:");
		lblClearanceLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblClearanceLevel.setBounds(10, 111, 73, 17);
		detailsPanel.add(lblClearanceLevel);
		
		clearanceComboBox = new JComboBox<String>();
		clearanceComboBox.setBounds(84, 108, 195, 20);
		detailsPanel.add(clearanceComboBox);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFirstName.setBounds(292, 52, 73, 14);
		detailsPanel.add(lblFirstName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(375, 49, 181, 20);
		detailsPanel.add(firstNameTextField);
		
		lblMiddleInitial = new JLabel("Middle Init:");
		lblMiddleInitial.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMiddleInitial.setBounds(292, 80, 73, 14);
		detailsPanel.add(lblMiddleInitial);
		
		middleInitTextField = new JTextField();
		middleInitTextField.setColumns(10);
		middleInitTextField.setBounds(375, 77, 181, 20);
		detailsPanel.add(middleInitTextField);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLastName.setBounds(292, 111, 73, 14);
		detailsPanel.add(lblLastName);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(375, 108, 181, 20);
		detailsPanel.add(lastNameTextField);
		
		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnDeleteUser.setBounds(566, 107, 116, 23);
		detailsPanel.add(btnDeleteUser);
		
		btnChangeDetails = new JButton("Change Details");
		btnChangeDetails.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnChangeDetails.setBounds(566, 76, 116, 23);
		detailsPanel.add(btnChangeDetails);
		
		btnCancelChanges = new JButton("Cancel Changes");
		btnCancelChanges.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnCancelChanges.setBounds(566, 48, 116, 23);
		detailsPanel.add(btnCancelChanges);
		
		addUserButton = new JButton("Add User");
		addUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		addUserButton.setBounds(566, 14, 116, 23);
		detailsPanel.add(addUserButton);
		
		btnNewButton = new JButton("Back to Main");
		btnNewButton.setBounds(597, 494, 105, 23);
		add(btnNewButton);

		InitFrame();
	}
	
	public void InitFrame() {
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		fillTable();
		
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT clearanceLevel FROM ClearanceLookUp;");
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					clearanceComboBox.addItem(rs.getString(1)+"");
					rs.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fillTable() {
		DefaultTableModel model = (DefaultTableModel)userTable.getModel();
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT u.userID, u.username, u.password, c.clearanceLevel, p.firstName, p.middleInitial, p.lastName FROM UserAccount AS u, Person AS p, ClearanceLookUp AS c WHERE u.personID = p.personID AND u.clearanceID = c.clearanceID;");
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7)});
					rs.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clickedTable() {
		int selectedIndex = userTable.getSelectedRow();
		int selectedUserID = Integer.parseInt(userTable.getModel().getValueAt(selectedIndex, 0) + "");
		
		ResultSet rs = dbHandler.executeQuery(conn, "SELECT u.username, u.password, c.clearanceLevel, p.firstName, p.middleInitial, p.lastName FROM UserAccount AS u, Person AS p, clearanceLookUp AS c WHERE u.personID = p.personID AND u.clearanceID = c.clearanceID AND u.userID = " + selectedUserID + ";");
		
		try {
			if (rs.isBeforeFirst()) {
				rs.first();
				usernameTextField.setText(rs.getString(1));
				passwordTextField.setText(rs.getString(2));
				clearanceComboBox.setSelectedItem(rs.getString(3));
				firstNameTextField.setText(rs.getString(4));
				middleInitTextField.setText(rs.getString(5));
				lastNameTextField.setText(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
