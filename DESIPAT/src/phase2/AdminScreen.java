package phase2;
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
	

	public AdminScreen() {
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
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//clickedTable();
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
		deleteUserButton.setBackground(new Color(107, 142, 35));
		deleteUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deleteUserClicked();
			}
		});
		deleteUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		deleteUserButton.setBounds(626, 105, 116, 23);
		detailsPanel.add(deleteUserButton);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBackground(new Color(107, 142, 35));
		changeDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//changeDetailsClicked();
			}
		});
		changeDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeDetailsButton.setBounds(626, 75, 116, 23);
		detailsPanel.add(changeDetailsButton);
		
		cancelChangesButton = new JButton("Cancel Changes");
		cancelChangesButton.setBackground(new Color(107, 142, 35));
		cancelChangesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//refreshScreen();
			}
		});
		cancelChangesButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		cancelChangesButton.setBounds(626, 47, 116, 23);
		detailsPanel.add(cancelChangesButton);
		
		addUserButton = new JButton("Add User");
		addUserButton.setBackground(new Color(107, 142, 35));
		addUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//addUserClicked();
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
				//selectedChanged();
			}
		});
		selectExistingComboBox.setEnabled(false);
		selectExistingComboBox.setBounds(421, 13, 157, 20);
		detailsPanel.add(selectExistingComboBox);

	}
	
	public void refresh() {
	}
	
}