package screens;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.sql.Connection;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;

import screenBehaviourStrategy.AccountSettingsScreenBehavior;

import dataObjects.UserAccount;



public class AccountSettingsScreen extends Screen{
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
	
	private AccountSettingsScreenBehavior controller;
	
	public static final int REGULAR_MODE = 0;
	public static final int EDIT_DETAILS_MODE = 1;
	
	private int currEditPasswordMode;
	private int currEditNameMode;

	private JButton changeNameButton;
	
	/**
	 * Create the panel.
	 */
	public AccountSettingsScreen(AccountSettingsScreenBehavior b){
		this.controller = b;
		initialize();
	}

	public void setCurrentUser(UserAccount currUser) {
		initSettings(currUser);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 81, 138, 20);
		passwordField.setColumns(10);
		userSettingsPanel.add(passwordField);
		
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBackground(new Color(220, 220, 220));
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
		saveDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		saveDetailsButton.setBounds(254, 107, 105, 23);
		userSettingsPanel.add(saveDetailsButton);
		
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
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setBounds(20, 90, 141, 14);
		namePanel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 109, 141, 20);
		firstNameTextField.setColumns(10);
		namePanel.add(firstNameTextField);
		
		middleInitLabel = new JLabel("MI");
		middleInitLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		middleInitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		middleInitLabel.setBounds(168, 90, 48, 14);
		namePanel.add(middleInitLabel);
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setBounds(168, 109, 48, 20);
		middleInitialTextField.setColumns(10);
		namePanel.add(middleInitialTextField);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setBounds(222, 90, 141, 14);
		namePanel.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(222, 109, 141, 20);
		lastNameTextField.setColumns(10);
		namePanel.add(lastNameTextField);
		
		changeNameButton = new JButton("Update Name");
		changeNameButton.setBackground(new Color(220, 220, 220));
		changeNameButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeNameButton.setBounds(258, 64, 105, 23);
		namePanel.add(changeNameButton);
	}
	
	public void initSettings(UserAccount currUser) {
		usernameField.setText(currUser.getUsername());
		passwordField.setText(currUser.getPassword());
		
		changeDetailsButton.setText("Change Details");
		changeNameButton.setText("Update Name");
		
		passwordField.setEditable(false);
		passwordField.setBackground(Color.WHITE);
		newPasswordField.setVisible(false);
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
	
		
		changeEditPasswordMode(REGULAR_MODE);
		changeEditNameMode(REGULAR_MODE);
		
		this.validate();
	}

	public void refresh() {
		
	}

	private void changeEditPasswordMode(int mode){
		if(mode == EDIT_DETAILS_MODE){
			changeDetailsButton.setText("Cancel");
			passwordField.setEditable(true);
			passwordField.setText("");
			newPasswordField.setText("");
			newPasswordField.setVisible(true);
			newPasswordLabel.setVisible(true);
			saveDetailsButton.setVisible(true);
			
			currEditPasswordMode = EDIT_DETAILS_MODE;
		}
		else if(mode == REGULAR_MODE)
		{
			changeDetailsButton.setText("Change Details");
			passwordField.setEditable(false);
			passwordField.setBackground(Color.WHITE);
			newPasswordField.setVisible(false);
			newPasswordField.setBackground(Color.WHITE);
			newPasswordLabel.setVisible(false);
			saveDetailsButton.setVisible(false);
			
			currEditPasswordMode = REGULAR_MODE;
		}
	}
	
	private void changeEditNameMode(int mode){
		if(mode == EDIT_DETAILS_MODE ){
			changeNameButton.setText("Save");
			firstNameLabel.setVisible(true);
			middleInitLabel.setVisible(true);
			lastNameLabel.setVisible(true);

			firstNameTextField.setVisible(true);
			middleInitialTextField.setVisible(true);
			lastNameTextField.setVisible(true);
			
			currEditNameMode = EDIT_DETAILS_MODE;
			
		}
		else{
			changeNameButton.setText("Update Name");
			
			firstNameLabel.setVisible(false);
			middleInitLabel.setVisible(false);
			lastNameLabel.setVisible(false);

			firstNameTextField.setVisible(false);
			middleInitialTextField.setVisible(false);
			lastNameTextField.setVisible(false);
			
			currEditNameMode = REGULAR_MODE;
		}
	}
	
	
	public void changeToEditPasswordMode(){
		changeEditPasswordMode(EDIT_DETAILS_MODE);
	}
	
	public void changeToUpdateNameMode(){
		changeEditNameMode(EDIT_DETAILS_MODE);
	}
	
	
	public boolean isEditPasswordMode(){
		return currEditPasswordMode == EDIT_DETAILS_MODE;
	}
	
	public boolean isEditNameMode(){
		return currEditNameMode == EDIT_DETAILS_MODE;
	}
	
	public boolean checkNewPassword(UserAccount currUser) {
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
		if (newPasswordField.getPassword().length == 0) {
			newPasswordField.setBackground(Color.PINK);
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

	
	public String getFirstName(){
		return firstNameTextField.getText();
	}
	
	public String getMiddleInitial(){
		return middleInitialTextField.getText();
	}
	
	public String getLastName(){
		return lastNameTextField.getText();
	}
	
	public String getNewPassword(){
		return new String(newPasswordField.getPassword());
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