import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


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
	private JButton deleteUserButton;
	private JButton changeDetailsButton;
	private JButton cancelChangesButton;
	private JButton addUserButton;
	private JComboBox <String> selectExistingComboBox;
	private JLabel lblExistingPersons;
	
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
		tablePanel.setBounds(10, 56, 752, 240);
		add(tablePanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 752, 240);
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
		detailsPanel.setBounds(10, 307, 752, 140);
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
		lblFirstName.setBounds(314, 52, 73, 14);
		detailsPanel.add(lblFirstName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(397, 49, 181, 20);
		detailsPanel.add(firstNameTextField);
		
		lblMiddleInitial = new JLabel("Middle Init:");
		lblMiddleInitial.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMiddleInitial.setBounds(314, 80, 73, 14);
		detailsPanel.add(lblMiddleInitial);
		
		middleInitTextField = new JTextField();
		middleInitTextField.setColumns(10);
		middleInitTextField.setBounds(397, 77, 181, 20);
		detailsPanel.add(middleInitTextField);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLastName.setBounds(314, 111, 73, 14);
		detailsPanel.add(lblLastName);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(397, 108, 181, 20);
		detailsPanel.add(lastNameTextField);
		
		deleteUserButton = new JButton("Delete User");
		deleteUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteUserClicked();
			}
		});
		deleteUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		deleteUserButton.setBounds(626, 105, 116, 23);
		detailsPanel.add(deleteUserButton);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeDetailsClicked();
			}
		});
		changeDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeDetailsButton.setBounds(626, 75, 116, 23);
		detailsPanel.add(changeDetailsButton);
		
		cancelChangesButton = new JButton("Cancel Changes");
		cancelChangesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshScreen();
			}
		});
		cancelChangesButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		cancelChangesButton.setBounds(626, 47, 116, 23);
		detailsPanel.add(cancelChangesButton);
		
		addUserButton = new JButton("Add User");
		addUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addUserClicked();
			}
		});
		addUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		addUserButton.setBounds(626, 13, 116, 23);
		detailsPanel.add(addUserButton);
		
		lblExistingPersons = new JLabel("Existing Persons:");
		lblExistingPersons.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblExistingPersons.setBounds(314, 17, 97, 14);
		detailsPanel.add(lblExistingPersons);
		
		selectExistingComboBox = new <String> JComboBox();
		selectExistingComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedChanged();
			}
		});
		selectExistingComboBox.setEnabled(false);
		selectExistingComboBox.setBounds(421, 13, 157, 20);
		detailsPanel.add(selectExistingComboBox);

		InitFrame();
	}
	
	public void InitFrame() {
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		refreshScreen();
		
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
	
	public void refreshScreen() {
		fillTable();
		
		usernameTextField.setEditable(false);
		passwordTextField.setEditable(false);
		clearanceComboBox.setEnabled(false);
		selectExistingComboBox.setEnabled(false);
		firstNameTextField.setEditable(false);
		middleInitTextField.setEditable(false);
		lastNameTextField.setEditable(false);
		
		changeDetailsButton.setText("Change Details");
	}
	
	public void fillTable() {
		DefaultTableModel model = (DefaultTableModel)userTable.getModel();
		
		int rowCount = model.getRowCount();
		for (int i = 0; i < rowCount; i++)
			model.removeRow(0);
		
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
		int selectedUserID = Integer.parseInt(userTable.getModel().getValueAt(userTable.getSelectedRow(), 0) + "");
		
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
		
		fillSelectExisting();
	}
	
	public void changeDetailsClicked() {
		if (userTable.getSelectedRow() == -1)
			return;
		
		int selectedUserID = Integer.parseInt(userTable.getModel().getValueAt(userTable.getSelectedRow(), 0) + "");

		if (changeDetailsButton.getText().equals("Change Details")) {
			usernameTextField.setEditable(true);
			passwordTextField.setEditable(true);
			clearanceComboBox.setEnabled(true);
			firstNameTextField.setEditable(true);
			middleInitTextField.setEditable(true);
			lastNameTextField.setEditable(true);
			
			changeDetailsButton.setText("Save Details");
		}
		else {
			String username = "", password = "", middleInit = "", firstName = "", lastName = "";
			
			if (usernameTextField.getText().length() == 0) {
				usernameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (passwordTextField.getText().length() == 0) {
				passwordTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (firstNameTextField.getText().length() == 0) {
				firstNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (lastNameTextField.getText().length() == 0) {
				lastNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			boolean contFlag = true;
			
			firstName = firstNameTextField.getText();
			for (int i = 0; i < firstName.length() && contFlag; i++) {
				if (!((firstName.charAt(i) >= 'A' && firstName.charAt(i) <= 'Z') || (firstName.charAt(i) >= 'a' && firstName.charAt(i) <= 'z') || (firstName.charAt(i) == ' ')))
					contFlag = false;
			}

			if (!contFlag) {
				firstNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			lastName = lastNameTextField.getText();
			for (int i = 0; i < lastName.length() && contFlag; i++) {
				if (!((lastName.charAt(i) >= 'A' && lastName.charAt(i) <= 'Z') || (lastName.charAt(i) >= 'a' && lastName.charAt(i) <= 'z') || (lastName.charAt(i) == ' ')))
					contFlag = false;
			}

			if (!contFlag) {
				lastNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			username = usernameTextField.getText();
			for (int i = 0; i < username.length() && contFlag; i++) {
				if (!((username.charAt(i) >= 'A' && username.charAt(i) <= 'Z') || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) == ' ')))
					contFlag = false;
			}

			if (!contFlag) {
				usernameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			password = passwordTextField.getText();
			for (int i = 0; i < password.length() && contFlag; i++) {
				if (!((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') || (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') || (password.charAt(i) == ' ')))
					contFlag = false;
			}

			if (!contFlag) {
				passwordTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			middleInit = middleInitTextField.getText();
			
			dbHandler.executeUpdate(conn, "UPDATE UserAccount SET username = '" + username + "', password = '" + password + "' WHERE userID = " + selectedUserID + ";");
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT clearanceID FROM ClearanceLookUp WHERE clearanceLevel = '" + clearanceComboBox.getSelectedItem() + "';");
			
			try {
				if (rs.isBeforeFirst()) {
					rs.first();
					dbHandler.executeUpdate(conn, "UPDATE UserAccount SET clearanceID = " + rs.getString(1) + " WHERE userID = " + selectedUserID + ";");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (getExistingID(firstName, middleInit, lastName) == -1) {
				dbHandler.executeUpdate(conn, "UPDATE Person SET firstName = '" + firstName + "', middleInitial = '" + ((middleInit.length() == 0)? "" : middleInit.charAt(0)) + "', lastName = '" + lastName + "' WHERE personID = (SELECT personID FROM UserAccount WHERE userID = " + selectedUserID + ");");
			}
			else {
				dbHandler.executeUpdate(conn, "UPDATE UserAccount SET personID = " + getExistingID(firstName, middleInit, lastName) + " WHERE userID = " + selectedUserID + ";");
			}
			
			refreshScreen();
		}
	}
	
	public int getExistingID(String fn, String mi, String ln) {
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT personID FROM Person WHERE firstName = '" + fn + "' AND middleInitial = '" + mi + "' AND lastName = '" + ln + "';");
			if (!rs.isBeforeFirst()) {
				rs.first();
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void deleteUserClicked() {
		if (userTable.getSelectedRow() == -1)
			return;
		
		int selectedUserID = Integer.parseInt(userTable.getModel().getValueAt(userTable.getSelectedRow(), 0) + "");

		dbHandler.executeUpdate(conn, "DELETE FROM UserAccount WHERE userID = " + selectedUserID + ";");
		refreshScreen();
	}
	
	public void fillSelectExisting() {
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT firstName, middleInitial, lastName FROM Person WHERE personID NOT IN (SELECT personID FROM UserAccount);");
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					selectExistingComboBox.addItem(rs.getString(1) + " " + rs.getString(2) + ". " + rs.getString(3));
					rs.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (selectExistingComboBox.getItemCount() != 0)
			selectExistingComboBox.setEnabled(true);
	}
	
	public void addUserClicked() {
		refreshScreen();
		
		usernameTextField.setEditable(true);
		usernameTextField.setText("");
		passwordTextField.setEditable(true);
		passwordTextField.setText("");
		clearanceComboBox.setEnabled(true);
		firstNameTextField.setEditable(true);
		firstNameTextField.setText("");
		middleInitTextField.setEditable(true);
		middleInitTextField.setText("");
		lastNameTextField.setEditable(true);
		lastNameTextField.setText("");

		changeDetailsButton.setText("Save Details");
	}
	
	public void selectedChanged() {
		if (selectExistingComboBox.getSelectedIndex() == -1) {
			return;
		}
		
		String fullName = selectExistingComboBox.getSelectedItem() + "";
		String[] nameArray = fullName.split("\\.");
		
		String lastName = nameArray[1].substring(1);
		String middleInit = nameArray[0].charAt(nameArray[0].length()-1) + "";
		String firstName = nameArray[0].substring(0, nameArray[0].length()-3);
		
		firstNameTextField.setText(firstName);
		middleInitTextField.setText(middleInit);
		lastNameTextField.setText(lastName);
	}
}