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

import dataObjects.Clearance;
import dataObjects.ClearanceLookUpTable;
import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.UserAccount;

import screenBehaviourStrategy.AdminScreenBehavior;
import screenBehaviourStrategy.AdminScreenBehaviorStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
	public static final int EDIT_DETAILS_MODE = 1;
	public static final int REGULAR_MODE = 0;
	private int currMode;
	
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
		scrollPane.setViewportView(userTable);
		
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
		usernameTextField.setEditable(false);
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
		deleteUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		deleteUserButton.setBounds(626, 105, 116, 23);
		detailsPanel.add(deleteUserButton);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBackground(new Color(107, 142, 35));
		changeDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeDetailsButton.setBounds(626, 75, 116, 23);
		detailsPanel.add(changeDetailsButton);
		
		cancelChangesButton = new JButton("Cancel Changes");
		cancelChangesButton.setBackground(new Color(107, 142, 35));
		cancelChangesButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		cancelChangesButton.setBounds(626, 47, 116, 23);
		detailsPanel.add(cancelChangesButton);
		
		addUserButton = new JButton("Add User");
		addUserButton.setBackground(new Color(107, 142, 35));
		addUserButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		addUserButton.setBounds(626, 13, 116, 23);
		detailsPanel.add(addUserButton);
		
		lblExistingPersons = new JLabel("Existing Persons:");
		lblExistingPersons.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblExistingPersons.setBounds(314, 17, 97, 14);
		detailsPanel.add(lblExistingPersons);
		
		selectExistingComboBox = new JComboBox<String>();
		selectExistingComboBox.setEnabled(false);
		selectExistingComboBox.setBounds(421, 13, 157, 20);
		detailsPanel.add(selectExistingComboBox);
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

	//GUI Changers (Refreshers, Mode Changers)
	public void resetScreen() {
		myBehavior.fillTable();
		myBehavior.fillSelectExisting();
				
		usernameTextField.setEditable(false);
		usernameTextField.setBackground(Color.WHITE);
		passwordTextField.setEditable(false);
		passwordTextField.setBackground(Color.WHITE);
		clearanceComboBox.setEnabled(false);
		selectExistingComboBox.setEnabled(false);
		firstNameTextField.setEditable(false);
		firstNameTextField.setBackground(Color.WHITE);
		middleInitTextField.setEditable(false);
		middleInitTextField.setBackground(Color.WHITE);
		lastNameTextField.setEditable(false);
		lastNameTextField.setBackground(Color.WHITE);

		clearUserDetails();
		changeMode(REGULAR_MODE);
		
		this.validate();
	}

	public void clearUserDetails(){
		usernameTextField.setText("");
		passwordTextField.setText("");
		firstNameTextField.setText("");
		middleInitTextField.setText("");
		lastNameTextField.setText("");
	}
	
	private void changeMode(int mode){
		if(mode == REGULAR_MODE){
			changeDetailsButton.setText("Change Details");
			currMode = REGULAR_MODE;
		}
		else if(mode == EDIT_DETAILS_MODE){
			changeDetailsButton.setText("Save Details");
			currMode = EDIT_DETAILS_MODE;
		}
	}
	
	public void setModeToChangeDetails(){
		usernameTextField.setEditable(false);
		passwordTextField.setEditable(true);
		clearanceComboBox.setEnabled(true);
		selectExistingComboBox.setEnabled(true);
		firstNameTextField.setEditable(true);
		middleInitTextField.setEditable(true);
		lastNameTextField.setEditable(true);
		changeMode(EDIT_DETAILS_MODE);
	}
	
	public void setModeToAddUser(){
		usernameTextField.setEditable(true);
		passwordTextField.setEditable(true);
		clearanceComboBox.setEnabled(true);
		selectExistingComboBox.setEnabled(true);
		firstNameTextField.setEditable(true);
		middleInitTextField.setEditable(true);
		lastNameTextField.setEditable(true);
		
		clearUserDetails();
		changeMode(EDIT_DETAILS_MODE);
	}
	
	
	//Getters for the data
	public String getUsername(){
		return usernameTextField.getText();
	}
	
	public String getPassword(){
		return passwordTextField.getText();
	}
	
	public String getFirstName(){
		return firstNameTextField.getText();
	}
	
	public String getMiddleInitial(){
		return middleInitTextField.getText();
	}
	
	public String getLastName(){
		return lastNameTextField.getText();
	}
	
	public String getSelectedPerson(){
		if(selectExistingComboBox.getSelectedItem() == null)
			return null;
		
		return selectExistingComboBox.getSelectedItem().toString();
	}
	
	public int getSelectedUserID(){
		try{
		 return Integer.parseInt(userTable.getModel().getValueAt(userTable.getSelectedRow(), 0) + "");
		}
		catch(Exception e){
			return -1;
		}
	}
	
	public String getSelectedClearance(){
		if(clearanceComboBox.getSelectedItem() != null)
			return clearanceComboBox.getSelectedItem().toString();
		
		return null;
	}
		
	public boolean isEditMode(){
		return currMode == EDIT_DETAILS_MODE;
	}
	
	//Setters/Display methods for the data
	public void displayError(String errorMsg){
		JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
	public void displayUser(UserAccount u){
		usernameTextField.setText(u.getUsername());
		passwordTextField.setText(u.getPassword());
		clearanceComboBox.setSelectedItem(u.getClearance().getClearanceLevel());
		firstNameTextField.setText(u.getPersonFirstName());
		middleInitTextField.setText(u.getPersonMiddleName());
		lastNameTextField.setText(u.getPersonLastName());	
	}
	
	public void displayUserList(DefaultTableModel model){
		userTable.setModel(model);
	}
	
	public void setClearanceChoices(ArrayList<Clearance> choices){
		for (int i = 0; i < choices.size(); i++) {
			clearanceComboBox.addItem(choices.get(i).getClearanceLevel());
		}
	}
	
	public void setPersonsWithNoAccount(ArrayList<Person> list){
		selectExistingComboBox.removeAllItems();
		selectExistingComboBox.addItem("");
		
		for (int i = 0; i < list.size(); i++)
			selectExistingComboBox.addItem(list.get(i).getFirstName() + " " + list.get(i).getMiddleInitial() + ". " + list.get(i).getLastName());
	}
	
	public void setFirstName(String firstName){
		if(firstName != null)
			firstNameTextField.setText(firstName);
	}
	
	public void setMiddleInitial(char c){
		middleInitTextField.setText(""+c);
	}
	
	public void setLastName(String lastName){
		if(lastName != null)
			lastNameTextField.setText(lastName);
	}
	
	
	
	//Setters for the listeners
	public void setDeleteUserButtonListener(ActionListener listener){
		deleteUserButton.addActionListener(listener);
	}
	
	public void setChangeDetailsButtonListener(ActionListener listener){
		changeDetailsButton.addActionListener(listener);
	}
	
	public void setCancelChangesButtonListener(ActionListener listener){
		cancelChangesButton.addActionListener(listener);
	}
	
	public void setAddUserButtonListener(ActionListener listener){
		addUserButton.addActionListener(listener);
	}
	
	public void setUserTableListener(MouseAdapter adapter){
		userTable.addMouseListener(adapter);
	}
	
	public void setSelectExistingComboBoxListener(ActionListener listener){
		selectExistingComboBox.addActionListener(listener);
	}
	
	
}