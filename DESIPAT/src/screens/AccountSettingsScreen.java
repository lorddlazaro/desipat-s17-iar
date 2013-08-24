package screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import phase1.Person;
import screenBehaviourStrategy.AccountSettingsScreenBehavior;
import screenBehaviourStrategy.AccountSettingsScreenBehaviourStrategy;
import dataObjects.PersonTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;


public class AccountSettingsScreen extends Screen implements TableObserver{
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
	
	private AccountSettingsScreenBehavior controller;
	
	private UserAccount currUser;
	private Connection conn;
	private JButton changeNameButton;
	
	/**
	 * Create the panel.
	 */
	public AccountSettingsScreen(AccountSettingsScreenBehavior b){
		this.controller = b;
		initialize();
	}

	public void setCurrentUser() {
		currUser = MainScreen.getCurrentUser();
		controller.setCurrUser(currUser);
		initSettings();
	}

	public void initialize() {
		setBackground(new Color(128, 128, 128));

		setLayout(null);
		this.setBounds(0, 0, 772, 454);
		
		userSettingsPanel = new JPanel();
		userSettingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userSettingsPanel.setBounds(10, 11, 368, 140);
		userSettingsPanel.setLayout(null);
		add(userSettingsPanel);
		
		lblUserSettings = new JLabel("User Settings");
		lblUserSettings.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUserSettings.setBounds(5, 11, 172, 19);
		userSettingsPanel.add(lblUserSettings);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(5, 51, 72, 19);
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		userSettingsPanel.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setBounds(112, 51, 138, 20);
		usernameField.setColumns(10);
		userSettingsPanel.add(usernameField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(5, 81, 66, 19);
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		userSettingsPanel.add(passwordLabel);
		
		setPasswordField(new JPasswordField());
		getPasswordField().setBounds(112, 81, 138, 20);
		getPasswordField().setColumns(10);
		userSettingsPanel.add(getPasswordField());
		
		
		setChangeDetailsButton(new JButton("Change Details"));
		getChangeDetailsButton().setBackground(new Color(220, 220, 220));
		getChangeDetailsButton().setFont(new Font("Calibri", Font.PLAIN, 11));
		getChangeDetailsButton().setBounds(254, 80, 105, 23);
		userSettingsPanel.add(getChangeDetailsButton());
		
		setNewPasswordLabel(new JLabel("New Password:"));
		getNewPasswordLabel().setFont(new Font("Calibri", Font.PLAIN, 16));
		getNewPasswordLabel().setBounds(5, 108, 105, 19);
		userSettingsPanel.add(getNewPasswordLabel());
		
		setNewPasswordField(new JPasswordField());
		getNewPasswordField().setColumns(10);
		getNewPasswordField().setBounds(112, 108, 138, 20);
		userSettingsPanel.add(getNewPasswordField());
		
		setSaveDetailsButton(new JButton("Save"));
		getSaveDetailsButton().setBackground(new Color(220, 220, 220));
		getSaveDetailsButton().setFont(new Font("Calibri", Font.PLAIN, 11));
		getSaveDetailsButton().setBounds(254, 107, 105, 23);
		userSettingsPanel.add(getSaveDetailsButton());
		
		
		
		namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		namePanel.setBounds(388, 11, 374, 140);
		namePanel.setLayout(null);
		add(namePanel);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 63, 14);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		namePanel.add(lblName);
		
		nameLabel = new JLabel("<namehere>");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 39, 366, 14);
		nameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		namePanel.add(nameLabel);
		
		setFirstNameLabel(new JLabel("First Name"));
		getFirstNameLabel().setFont(new Font("Calibri", Font.PLAIN, 12));
		getFirstNameLabel().setHorizontalAlignment(SwingConstants.CENTER);
		getFirstNameLabel().setBounds(20, 90, 141, 14);
		namePanel.add(getFirstNameLabel());
		
		setFirstNameTextField(new JTextField());
		getFirstNameTextField().setBounds(20, 109, 141, 20);
		getFirstNameTextField().setColumns(10);
		namePanel.add(getFirstNameTextField());
		
		setMiddleInitLabel(new JLabel("MI"));
		getMiddleInitLabel().setFont(new Font("Calibri", Font.PLAIN, 12));
		getMiddleInitLabel().setHorizontalAlignment(SwingConstants.CENTER);
		getMiddleInitLabel().setBounds(168, 90, 48, 14);
		namePanel.add(getMiddleInitLabel());
		
		setMiddleInitialTextField(new JTextField());
		getMiddleInitialTextField().setBounds(168, 109, 48, 20);
		getMiddleInitialTextField().setColumns(10);
		namePanel.add(getMiddleInitialTextField());
		
		setLastNameLabel(new JLabel("Last Name"));
		getLastNameLabel().setFont(new Font("Calibri", Font.PLAIN, 12));
		getLastNameLabel().setHorizontalAlignment(SwingConstants.CENTER);
		getLastNameLabel().setBounds(222, 90, 141, 14);
		namePanel.add(getLastNameLabel());
		
		setLastNameTextField(new JTextField());
		getLastNameTextField().setBounds(222, 109, 141, 20);
		getLastNameTextField().setColumns(10);
		namePanel.add(getLastNameTextField());
		
		setChangeNameButton(new JButton("Update Name"));
		getChangeNameButton().setBackground(new Color(220, 220, 220));
		getChangeNameButton().setFont(new Font("Calibri", Font.PLAIN, 11));
		getChangeNameButton().setBounds(258, 64, 105, 23);
		namePanel.add(getChangeNameButton());
		
		assetSummary = new JPanel();
		assetSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		assetSummary.setBounds(10, 162, 752, 281);
		assetSummary.setLayout(null);
		add(assetSummary);
		
		lblSummaryTable = new JLabel("Summary");
		lblSummaryTable.setBounds(10, 11, 269, 22);
		lblSummaryTable.setFont(new Font("Calibri", Font.PLAIN, 18));
		assetSummary.add(lblSummaryTable);
		
		JLabel lblNetWorth = new JLabel("Net worth");
		lblNetWorth.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNetWorth.setBounds(10, 44, 76, 14);
		assetSummary.add(lblNetWorth);
		
		lblNetWorthList = new JTextPane();
		lblNetWorthList.setBackground(UIManager.getColor("Button.background"));
		lblNetWorthList.setEditable(false);
		lblNetWorthList.setBounds(10, 59, 139, 22);
		assetSummary.add(lblNetWorthList);
		
		JLabel lblNewestAssets = new JLabel("Newest Assets");
		lblNewestAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewestAssets.setBounds(10, 113, 99, 14);
		assetSummary.add(lblNewestAssets);
		
		lblNewestAssetList = new JTextPane();
		lblNewestAssetList.setBackground(UIManager.getColor("Button.background"));
		lblNewestAssetList.setEditable(false);
		lblNewestAssetList.setBounds(10, 127, 172, 55);
		assetSummary.add(lblNewestAssetList);
		
		JLabel lblMostValuableAssets = new JLabel("Most Valuable Assets");
		lblMostValuableAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMostValuableAssets.setBounds(10, 184, 139, 14);
		assetSummary.add(lblMostValuableAssets);
		
		lblMostValuableAssetList = new JTextPane();
		lblMostValuableAssetList.setBackground(UIManager.getColor("Button.background"));
		lblMostValuableAssetList.setEditable(false);
		lblMostValuableAssetList.setBounds(10, 209, 172, 55);
		assetSummary.add(lblMostValuableAssetList);
	}
	
	public void refresh(){ 
		//this was meant to update networth etc i think
	}

	public void initSettings() {
		usernameField.setText(currUser.getUsername());
		passwordField.setText(currUser.getPassword());
		
		changeDetailsButton.setText("Change Details");
		changeNameButton.setText("Update Name");
		
		passwordField.setEditable(false);
		passwordField.setBackground(Color.WHITE);
		getNewPasswordField().setVisible(false);
		newPasswordField.setBackground(Color.WHITE);
		newPasswordLabel.setVisible(false);
		saveDetailsButton.setVisible(false);
		
		nameLabel.setText(currUser.getPersonName());
		firstNameTextField.setText(currUser.getPersonFirstName());
		firstNameTextField.setBackground(Color.WHITE);
		middleInitialTextField.setText(currUser.getPersonMiddleName() + "");
		middleInitialTextField.setBackground(Color.WHITE);
		lastNameTextField.setText(currUser.getPersonLastName());
		lastNameTextField.setBackground(Color.WHITE);
		
		firstNameLabel.setVisible(false);
		middleInitLabel.setVisible(false);
		lastNameLabel.setVisible(false);

		firstNameTextField.setVisible(false);
		middleInitialTextField.setVisible(false);
		lastNameTextField.setVisible(false);
		//lookUpNetWorth();
		//lookUpNewestAssets();
		//lookUpMostValuableAssets();
		this.validate();
	}

	public boolean checkNewPassword() {
		if (new String(passwordField.getPassword()).trim().length() == 0) {
			passwordField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Please input old password.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (!currUser.getPassword().equals(new String(passwordField.getPassword()))) {
			passwordField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "Wrong password.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (getNewPasswordField().getPassword().length == 0) {
			getNewPasswordField().setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "New password cannot be blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean checkUpdateName() {
		boolean contFlag = true;
		if (firstNameTextField.getText().length() == 0) {
			firstNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "First or last name fields cannot be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		if (lastNameTextField.getText().length() == 0) {
			lastNameTextField.setBackground(Color.PINK);
			JOptionPane.showMessageDialog(null, "First or last name fields cannot be left blank.", "Error", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		
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
			return false;
		}
		
		return true;
	}

	public JButton getSaveDetailsButton() {
		return saveDetailsButton;
	}

	public void setSaveDetailsButton(JButton saveDetailsButton) {
		this.saveDetailsButton = saveDetailsButton;
	}

	public JLabel getNewPasswordLabel() {
		return newPasswordLabel;
	}

	public void setNewPasswordLabel(JLabel newPasswordLabel) {
		this.newPasswordLabel = newPasswordLabel;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getChangeDetailsButton() {
		return changeDetailsButton;
	}

	public void setChangeDetailsButton(JButton changeDetailsButton) {
		this.changeDetailsButton = changeDetailsButton;
	}

	public JButton getChangeNameButton() {
		return changeNameButton;
	}

	public void setChangeNameButton(JButton changeNameButton) {
		this.changeNameButton = changeNameButton;
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(JLabel firstNameLabel) {
		this.firstNameLabel = firstNameLabel;
	}

	public JLabel getMiddleInitLabel() {
		return middleInitLabel;
	}

	public void setMiddleInitLabel(JLabel middleInitLabel) {
		this.middleInitLabel = middleInitLabel;
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(JLabel lastNameLabel) {
		this.lastNameLabel = lastNameLabel;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public JTextField getMiddleInitialTextField() {
		return middleInitialTextField;
	}

	public void setMiddleInitialTextField(JTextField middleInitialTextField) {
		this.middleInitialTextField = middleInitialTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public JPasswordField getNewPasswordField() {
		return newPasswordField;
	}

	public void setNewPasswordField(JPasswordField newPasswordField) {
		this.newPasswordField = newPasswordField;
	}
	
	public void setChangeDetailsButtonListener(ActionListener listener){
		changeDetailsButton.addActionListener(listener);
	}
	
	public void setSaveDetailsButtonListener(ActionListener listener){
		saveDetailsButton.addActionListener(listener);
	}
	
	public void setChangeNameButtonListener(ActionListener listener){
		changeNameButton.addActionListener(listener);
	}
	
}