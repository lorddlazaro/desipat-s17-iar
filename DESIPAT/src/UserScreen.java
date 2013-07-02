import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.regex.*;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class UserScreen extends JPanel {
	private JTextField usernameField;
	private JLabel lblName;
	private JLabel nameLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleInitialTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JPasswordField newPasswordField;
	private JButton changeDetailsButton;
	private JButton saveDetailsButton;
	private JLabel newPasswordLabel;
	private JPanel userSettingsPanel;
	private JLabel usernameLabel;
	private JLabel lblUserSettings;
	private JPanel namePanel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel middleInitLabel;
	private JPanel assetSummary;
	private JLabel lblSummaryTable;
	private JTextPane lblNetWorthList;
	private JTextPane lblNewestAssetList;
	private JTextPane lblMostValuableAssetList;
	
	private User currUser;
	private int currUserID;
	private DBConnection dbHandler;
	private Connection conn;
	private JButton changeNameButton;
	
	/**
	 * Create the panel.
	 */
	public UserScreen() {
		setBackground(new Color(128, 128, 128));

		setLayout(null);
		this.setBounds(0, 0, 772, 454);
		
		userSettingsPanel = new JPanel();
		userSettingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userSettingsPanel.setBounds(10, 11, 368, 140);
		add(userSettingsPanel);
		userSettingsPanel.setLayout(null);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(5, 51, 72, 19);
		userSettingsPanel.add(usernameLabel);
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(5, 81, 66, 19);
		userSettingsPanel.add(passwordLabel);
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setBounds(112, 51, 138, 20);
		userSettingsPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 81, 138, 20);
		userSettingsPanel.add(passwordField);
		passwordField.setColumns(10);
		
		lblUserSettings = new JLabel("User Settings");
		lblUserSettings.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUserSettings.setBounds(5, 11, 172, 19);
		userSettingsPanel.add(lblUserSettings);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBackground(new Color(220, 220, 220));
		changeDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateDetailsClicked();
			}
		});
		changeDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeDetailsButton.setBounds(254, 80, 105, 23);
		userSettingsPanel.add(changeDetailsButton);
		
		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		newPasswordLabel.setBounds(5, 108, 105, 19);
		userSettingsPanel.add(newPasswordLabel);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(112, 108, 138, 20);
		userSettingsPanel.add(newPasswordField);
		
		saveDetailsButton = new JButton("Save");
		saveDetailsButton.setBackground(new Color(220, 220, 220));
		saveDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveAccountDetails();
			}
		});
		saveDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		saveDetailsButton.setBounds(254, 107, 105, 23);
		userSettingsPanel.add(saveDetailsButton);
		
		namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		namePanel.setBounds(388, 11, 374, 140);
		add(namePanel);
		namePanel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 63, 14);
		namePanel.add(lblName);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		nameLabel = new JLabel("<namehere>");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 39, 366, 14);
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 109, 141, 20);
		namePanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setBounds(168, 109, 48, 20);
		namePanel.add(middleInitialTextField);
		middleInitialTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(222, 109, 141, 20);
		namePanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setBounds(20, 90, 141, 14);
		namePanel.add(firstNameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setBounds(222, 90, 141, 14);
		namePanel.add(lastNameLabel);
		
		middleInitLabel = new JLabel("MI");
		middleInitLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		middleInitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		middleInitLabel.setBounds(168, 90, 48, 14);
		namePanel.add(middleInitLabel);
		
		changeNameButton = new JButton("Update Name");
		changeNameButton.setBackground(new Color(220, 220, 220));
		changeNameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateNameClicked();
			}
		});
		changeNameButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeNameButton.setBounds(258, 64, 105, 23);
		namePanel.add(changeNameButton);
		
		assetSummary = new JPanel();
		assetSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		assetSummary.setBounds(10, 162, 752, 281);
		add(assetSummary);
		assetSummary.setLayout(null);
		
		lblSummaryTable = new JLabel("Summary");
		lblSummaryTable.setBounds(10, 11, 269, 22);
		lblSummaryTable.setFont(new Font("Calibri", Font.PLAIN, 18));
		assetSummary.add(lblSummaryTable);
		
		JLabel lblNetWorth = new JLabel("Net worth");
		lblNetWorth.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNetWorth.setBounds(10, 44, 76, 14);
		assetSummary.add(lblNetWorth);
		
		JLabel lblNewestAssets = new JLabel("Newest Assets");
		lblNewestAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewestAssets.setBounds(10, 113, 99, 14);
		assetSummary.add(lblNewestAssets);
		
		JLabel lblMostValuableAssets = new JLabel("Most Valuable Assets");
		lblMostValuableAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMostValuableAssets.setBounds(10, 184, 139, 14);
		assetSummary.add(lblMostValuableAssets);
		
		lblNetWorthList = new JTextPane();
		lblNetWorthList.setBackground(UIManager.getColor("Button.background"));
		lblNetWorthList.setEditable(false);
		lblNetWorthList.setBounds(10, 59, 139, 22);
		assetSummary.add(lblNetWorthList);
		
		lblNewestAssetList = new JTextPane();
		lblNewestAssetList.setBackground(UIManager.getColor("Button.background"));
		lblNewestAssetList.setEditable(false);
		lblNewestAssetList.setBounds(10, 127, 172, 46);
		assetSummary.add(lblNewestAssetList);
		
		lblMostValuableAssetList = new JTextPane();
		lblMostValuableAssetList.setBackground(UIManager.getColor("Button.background"));
		lblMostValuableAssetList.setEditable(false);
		lblMostValuableAssetList.setBounds(10, 209, 172, 46);
		assetSummary.add(lblMostValuableAssetList);

	}
	
	public UserScreen(int currUserID) {
		this();
		this.currUserID = currUserID;
		dbHandler = new DBConnection();
		conn = dbHandler.open();
		updateUser();
		InitSettings();
	}
	
	public void updateUser() {
		try {
		ResultSet rs = dbHandler.executeQuery(conn, "SELECT username, password, clearanceID FROM UserAccount WHERE userID = " + currUserID + ";");
		rs.first();
		currUser = new User(currUserID, rs.getString(1), rs.getString(2), rs.getInt(3)); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void InitSettings() {
		updateUser();
		
		usernameField.setText(currUser.getUsername());
		passwordField.setText(currUser.getPassword());
		
		changeDetailsButton.setText("Change Details");
		changeNameButton.setText("Update Name");
		
		passwordField.setEditable(false);
		newPasswordField.setVisible(false);
		newPasswordLabel.setVisible(false);
		saveDetailsButton.setVisible(false);
		
		
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT * FROM Person WHERE personID IN (SELECT personID FROM UserAccount WHERE userID = " + currUser.getUserID() + ");");
			rs.first();
			currUser.setPerson(new Person(rs.getInt(1), rs.getString(2), (rs.getString(3).length()==0)? ' ' : rs.getString(3).charAt(0), rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		nameLabel.setText(currUser.getPerson().getFirstName() + " " + currUser.getPerson().getMiddleInit() + ". " + currUser.getPerson().getLastName());
		firstNameTextField.setText(currUser.getPerson().getFirstName());
		middleInitialTextField.setText(currUser.getPerson().getMiddleInit() + "");
		lastNameTextField.setText(currUser.getPerson().getLastName());
		
		firstNameLabel.setVisible(false);
		middleInitLabel.setVisible(false);
		lastNameLabel.setVisible(false);

		firstNameTextField.setVisible(false);
		middleInitialTextField.setVisible(false);
		lastNameTextField.setVisible(false);
		lookUpNetWorth();
		lookUpNewestAssets();
		lookUpMostValuableAssets();
		this.validate();
	}
	
	public void updateDetailsClicked() {
		
		if (changeDetailsButton.getText().equals("Change Details")) {
			changeDetailsButton.setText("Cancel");
			
			passwordField.setEditable(true);
			passwordField.setText("");
	
			newPasswordField.setText("");
			newPasswordField.setVisible(true);
			newPasswordLabel.setVisible(true);
			saveDetailsButton.setVisible(true);
		}
		else {
			InitSettings();
		}
	}
	
	public void saveAccountDetails() {
		
		if (passwordField.getPassword().length == 0) {
			passwordField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please input old password.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (!currUser.getPassword().equals(passwordField.getText())) {
			passwordField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Wrong password.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (newPasswordField.getPassword().length == 0) {
			newPasswordField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "New password cannot be blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		passwordField.setBackground(Color.WHITE);
		newPasswordField.setBackground(Color.WHITE);
		
		dbHandler.executeUpdate(conn, "UPDATE UserAccount SET password = '" + newPasswordField.getText() + "' WHERE userID = " + currUser.getUserID() + ";");
		
		InitSettings();
	}
	
	public void updateNameClicked() {
		if (changeNameButton.getText().equals("Update Name")) {
			changeNameButton.setText("Save");
			firstNameLabel.setVisible(true);
			middleInitLabel.setVisible(true);
			lastNameLabel.setVisible(true);
	
			firstNameTextField.setVisible(true);
			middleInitialTextField.setVisible(true);
			lastNameTextField.setVisible(true);
		}
		else {
			boolean contFlag = true;
			if (firstNameTextField.getText().length() == 0) {
				firstNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "First or last name fields cannot be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (lastNameTextField.getText().length() == 0) {
				lastNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "First or last name fields cannot be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String firstName = firstNameTextField.getText();
			for (int i = 0; i < firstName.length() && contFlag; i++) {
				if (!((firstName.charAt(i) >= 'A' && firstName.charAt(i) <= 'Z') || (firstName.charAt(i) >= 'a' && firstName.charAt(i) <= 'z') || (firstName.charAt(i) == ' ')))
					contFlag = false;
			}

			if (!contFlag) {
				firstNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String lastName = lastNameTextField.getText();
			for (int i = 0; i < lastName.length() && contFlag; i++) {
				if (!((lastName.charAt(i) >= 'A' && lastName.charAt(i) <= 'Z') || (lastName.charAt(i) >= 'a' && lastName.charAt(i) <= 'z') || (lastName.charAt(i) == ' ')))
					contFlag = false;
			}
			
			if (!contFlag) {
				lastNameTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Please use only alphabetical characters for names.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String middleInit = "";
			if (middleInitialTextField.getText().length() != 0) {
				middleInit = middleInitialTextField.getText().charAt(0) + "";
				middleInit = middleInit.toUpperCase();
				if (!(middleInit.charAt(0) >= 'A' && middleInit.charAt(0) <= 'Z')) {
					contFlag = false;
				}
			}
			
			if (!contFlag) {
				middleInitialTextField.setBackground(Color.PINK);
				JOptionPane.showMessageDialog(null, "Middle Initial must be a letter.", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			firstNameTextField.setBackground(Color.WHITE);
			lastNameTextField.setBackground(Color.WHITE);
			
			dbHandler.executeUpdate(conn, "UPDATE Person SET firstName = '" + firstName + "', middleInitial = '" + middleInit + "', lastName = '" + lastName + "' WHERE personID = " + currUser.getPerson().getPersonID());
			
			InitSettings();
		}
		
	}
	public void lookUpNetWorth()
	{
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT SUM(financialValue) FROM Asset WHERE ownerID IN (SELECT personID FROM UserAccount WHERE userID = " + currUser.getUserID() + ");");
			if (rs.isBeforeFirst()) {
				rs.first();
				lblNetWorthList.setText(rs.getInt(1) + "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void lookUpNewestAssets()
	{
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT name FROM Asset WHERE ownerID IN (SELECT personID FROM UserAccount WHERE userID = " + currUser.getUserID() + ") ORDER BY dateAcquired ASC;");
			if (rs.isBeforeFirst()) {
				rs.first();
				int count = 1;
				while (!rs.isAfterLast() && count <= 5) {
					lblNewestAssetList.setText(rs.getString(1) + "\n" + lblNewestAssetList.getText());
					rs.next();
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void lookUpMostValuableAssets()
	{
		try {
			ResultSet rs = dbHandler.executeQuery(conn, "SELECT name FROM Asset WHERE ownerID IN (SELECT personID FROM UserAccount WHERE userID = " + currUserID + ") ORDER BY financialValue ASC;");
			if (rs.isBeforeFirst()) {
				rs.first();
				int count = 1;
				while (!rs.isAfterLast() && count <= 5) {
					lblMostValuableAssetList.setText(rs.getString(1) + "\n" + lblMostValuableAssetList.getText());
					rs.next();
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}