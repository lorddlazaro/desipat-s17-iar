package screens;
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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;

import screenBehaviourStrategy.AdminScreenBehavior;
import screenBehaviourStrategy.AdminScreenBehaviorStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class AdminScreen extends JPanel {
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
	
	AdminScreenBehaviorStrategy myBehavior;
	
	public AdminScreen(AdminScreenBehavior myBehavior) {
		this.myBehavior=myBehavior;
		initialize();
	}
	
	public void initialize() {
		setBackground(new Color(46, 139, 87));
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
		getUserTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myBehavior.selectedCellChanged();
			}
		});
		scrollPane.setViewportView(getUserTable());
		getUserTable().setModel(new DefaultTableModel(
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
		lblAdminSettings.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		
		detailsPanel = new JPanel();
		detailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		detailsPanel.setBounds(10, 307, 752, 140);
		add(detailsPanel);
		detailsPanel.setLayout(null);
		
		lblUserDetails = new JLabel("User Details");
		lblUserDetails.setFont(new Font("Segoe WP", Font.PLAIN, 19));
		lblUserDetails.setBounds(10, 11, 172, 19);
		detailsPanel.add(lblUserDetails);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblUsername.setBounds(10, 52, 73, 14);
		detailsPanel.add(lblUsername);
		
		usernameTextField = new JTextField();
		getUsernameTextField().setBounds(84, 49, 195, 20);
		detailsPanel.add(getUsernameTextField());
		getUsernameTextField().setColumns(10);
		
		passwordTextField = new JTextField();
		getPasswordTextField().setColumns(10);
		getPasswordTextField().setBounds(84, 77, 195, 20);
		detailsPanel.add(getPasswordTextField());
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword.setBounds(10, 80, 73, 14);
		detailsPanel.add(lblPassword);
		
		lblClearanceLevel = new JLabel("Clearance:");
		lblClearanceLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblClearanceLevel.setBounds(10, 111, 73, 17);
		detailsPanel.add(lblClearanceLevel);
		
		clearanceComboBox = new JComboBox<String>();
		getClearanceComboBox().setBounds(84, 108, 195, 20);
		detailsPanel.add(getClearanceComboBox());
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFirstName.setBounds(314, 52, 73, 14);
		detailsPanel.add(lblFirstName);
		
		firstNameTextField = new JTextField();
		getFirstNameTextField().setColumns(10);
		getFirstNameTextField().setBounds(397, 49, 181, 20);
		detailsPanel.add(getFirstNameTextField());
		
		lblMiddleInitial = new JLabel("Middle Init:");
		lblMiddleInitial.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMiddleInitial.setBounds(314, 80, 73, 14);
		detailsPanel.add(lblMiddleInitial);
		
		middleInitTextField = new JTextField();
		getMiddleInitTextField().setColumns(10);
		getMiddleInitTextField().setBounds(397, 77, 181, 20);
		detailsPanel.add(getMiddleInitTextField());
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLastName.setBounds(314, 111, 73, 14);
		detailsPanel.add(lblLastName);
		
		lastNameTextField = new JTextField();
		getLastNameTextField().setColumns(10);
		getLastNameTextField().setBounds(397, 108, 181, 20);
		detailsPanel.add(getLastNameTextField());
		
		deleteUserButton = new JButton("Delete User");
		deleteUserButton.setBackground(new Color(107, 142, 35));
		deleteUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myBehavior.deleteUserClicked();
			}
		});
		deleteUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		deleteUserButton.setBounds(626, 105, 116, 23);
		detailsPanel.add(deleteUserButton);
		
		setChangeDetailsButton(new JButton("Change Details"));
		getChangeDetailsButton().setBackground(new Color(107, 142, 35));
		getChangeDetailsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInputs();
				myBehavior.changeDetailsClicked();
			}
		});
		getChangeDetailsButton().setFont(new Font("Calibri", Font.PLAIN, 11));
		getChangeDetailsButton().setBounds(626, 75, 116, 23);
		detailsPanel.add(getChangeDetailsButton());
		
		cancelChangesButton = new JButton("Cancel Changes");
		cancelChangesButton.setBackground(new Color(107, 142, 35));
		cancelChangesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshScreen();
			}
		});
		cancelChangesButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		cancelChangesButton.setBounds(626, 47, 116, 23);
		detailsPanel.add(cancelChangesButton);
		
		addUserButton = new JButton("Add User");
		addUserButton.setBackground(new Color(107, 142, 35));
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myBehavior.addUserClicked();
			}
		});
		addUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		addUserButton.setBounds(626, 13, 116, 23);
		detailsPanel.add(addUserButton);
		
		lblExistingPersons = new JLabel("Existing Persons:");
		lblExistingPersons.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblExistingPersons.setBounds(314, 17, 97, 14);
		detailsPanel.add(lblExistingPersons);
		
		selectExistingComboBox = new JComboBox<String>();
		getSelectExistingComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myBehavior.selectedChanged();
			}
		});
		getSelectExistingComboBox().setEnabled(false);
		getSelectExistingComboBox().setBounds(421, 13, 157, 20);
		detailsPanel.add(getSelectExistingComboBox());
	}
	
	public boolean checkInputs() {
		if (usernameTextField.getText().length() == 0) {
			usernameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (passwordTextField.getText().length() == 0) {
			passwordTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (firstNameTextField.getText().length() == 0) {
			firstNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lastNameTextField.getText().length() == 0) {
			lastNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "No field can be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		boolean contFlag = true;
		
		String firstName = firstNameTextField.getText();
		for (int i = 0; i < firstName.length() && contFlag; i++) {
			if (!((firstName.charAt(i) >= 'A' && firstName.charAt(i) <= 'Z') || (firstName.charAt(i) >= 'a' && firstName.charAt(i) <= 'z') || (firstName.charAt(i) == ' ')))
				contFlag = false;
		}

		if (!contFlag) {
			firstNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		String lastName = lastNameTextField.getText();
		for (int i = 0; i < lastName.length() && contFlag; i++) {
			if (!((lastName.charAt(i) >= 'A' && lastName.charAt(i) <= 'Z') || (lastName.charAt(i) >= 'a' && lastName.charAt(i) <= 'z') || (lastName.charAt(i) == ' ')))
				contFlag = false;
		}

		if (!contFlag) {
			lastNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		String username = usernameTextField.getText();
		for (int i = 0; i < username.length() && contFlag; i++) {
			if (!((username.charAt(i) >= 'A' && username.charAt(i) <= 'Z') || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) == ' ')))
				contFlag = false;
		}

		if (!contFlag) {
			usernameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		String password = passwordTextField.getText();
		for (int i = 0; i < password.length() && contFlag; i++) {
			if (!((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') || (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') || (password.charAt(i) == ' ')))
				contFlag = false;
		}

		if (!contFlag) {
			passwordTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		String middleInit = middleInitTextField.getText();
		
		return true;
	}

	public void refreshScreen() {
		myBehavior.fillTable();
		
		usernameTextField.setEditable(false);
		passwordTextField.setEditable(false);
		clearanceComboBox.setEnabled(false);
		selectExistingComboBox.setEnabled(false);
		firstNameTextField.setEditable(false);
		middleInitTextField.setEditable(false);
		lastNameTextField.setEditable(false);
		
		changeDetailsButton.setText("Change Details");
		
		this.validate();
	}

	public JTable getUserTable() {
		return userTable;
	}

	public JComboBox <String> getSelectExistingComboBox() {
		return selectExistingComboBox;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public JComboBox <String> getClearanceComboBox() {
		return clearanceComboBox;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public JTextField getMiddleInitTextField() {
		return middleInitTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public JButton getChangeDetailsButton() {
		return changeDetailsButton;
	}

	public void setChangeDetailsButton(JButton changeDetailsButton) {
		this.changeDetailsButton = changeDetailsButton;
	}

	public void personAlreadyExists() {
		JOptionPane.showMessageDialog(null, "The person you tried to add to the account already exists.", "Error", JOptionPane.WARNING_MESSAGE);
	}
}