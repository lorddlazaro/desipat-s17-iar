package screenBehaviourStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import dbHandler.NonQuery;
import dbHandler.Query;
import dbHandler.QueryHandler;
import screens.AdminScreen;
import statements.DeleteUser;
import statements.InsertAndSelectPerson;
import statements.InsertAndSelectUser;
import statements.SelectRemainingPersons;
import statements.SelectRowUserTable;
import statements.SelectUserDetails;
import statements.lookUp.LookUpClassification;
import statements.lookUp.LookUpClearance;
import statements.updateTable.UpdateUser;

public class AdminScreenBehavior implements AdminScreenBehaviorStrategy{

	AdminScreen myScreen;
	
	public AdminScreenBehavior() {
		myScreen = new AdminScreen(this);
	}
	
	public void selectedCellChanged() {
		int selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
		UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
		
		myScreen.getUsernameTextField().setText(u.getUsername());
		myScreen.getPasswordTextField().setText(u.getPassword());
		myScreen.getClearanceComboBox().setSelectedItem(u.getClearanceLevel());
		myScreen.getFirstNameTextField().setText(u.getPersonFirstName());
		myScreen.getMiddleInitTextField().setText(u.getPersonMiddleName());
		myScreen.getLastNameTextField().setText(u.getPersonLastName());
		
		fillSelectExisting();

	}
	
	public void fillSelectExisting() {
		myScreen.getSelectExistingComboBox().removeAllItems();
		myScreen.getSelectExistingComboBox().addItem("");
		
		Query stmt = new SelectRemainingPersons();
		stmt.executeStatement();
		
		for (int i = 0; i < stmt.getResultList().size(); i++)
			myScreen.getSelectExistingComboBox().addItem(stmt.getResultList().get(i).toString());
	}

	public void deleteUserClicked() {
		if (myScreen.getUserTable().getSelectedRow() == -1)
			return;
		
		int selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
		
		NonQuery stmt = new DeleteUser(selectedUserID);
		stmt.executeStatement();
		myScreen.refreshScreen();

		myScreen.getUsernameTextField().setText("");
		myScreen.getPasswordTextField().setText("");
		myScreen.getFirstNameTextField().setText("");
		myScreen.getMiddleInitTextField().setText("");
		myScreen.getLastNameTextField().setText("");
	}

	public void changeDetailsClicked() {
		if (myScreen.getChangeDetailsButton().getText().equals("Change Details")) {
			myScreen.getUsernameTextField().setEditable(true);
			myScreen.getPasswordTextField().setEditable(true);
			myScreen.getClearanceComboBox().setEnabled(true);
			myScreen.getSelectExistingComboBox().setEnabled(true);
			myScreen.getFirstNameTextField().setEditable(true);
			myScreen.getMiddleInitTextField().setEditable(true);
			myScreen.getLastNameTextField().setEditable(true);
			
			myScreen.getChangeDetailsButton().setText("Save Details");
		}
		else {
			if (!myScreen.checkInputs())
				return;
			int selectedUserID = -1;

			String username = myScreen.getUsernameTextField().getText();
			String password = myScreen.getPasswordTextField().getText();
			
			Query stmt = new LookUpClearance(myScreen.getClearanceComboBox().getSelectedItem().toString());
			stmt.executeStatement();
			
			int clearanceID = Integer.parseInt(stmt.getResultList().get(0).toString());
			
			String firstName = myScreen.getFirstNameTextField().getText();
			String middleInit = myScreen.getMiddleInitTextField().getText();
			String lastName = myScreen.getLastNameTextField().getText();

			if (myScreen.getUserTable().getSelectedRow() == -1) {
				Person p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);
				
				if (p != null) {
					myScreen.personAlreadyExists();
					return;
				}
				
				stmt = new InsertAndSelectPerson(firstName, middleInit, lastName);
				stmt.executeStatement();
				int personID = Integer.parseInt(stmt.getResultList().get(0).toString());
				
				
				stmt = new InsertAndSelectUser(username, password, clearanceID, personID);
				stmt.executeStatement();
				selectedUserID = Integer.parseInt(stmt.getResultList().get(0).toString());
				
			}
			else {
				selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
				UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
				Person p = PersonTable.getInstance().getEntry(u.getPersonID());
				
				if (p == null) {
					stmt = new InsertAndSelectPerson(firstName, middleInit, lastName);
					stmt.executeStatement();
					int personID = Integer.parseInt(stmt.getResultList().get(0).toString());
					
					u.setUsername(username);
					u.setPassword(password);
					u.setClearanceID(clearanceID);
					u.setPersonID(personID);
					
					UserAccountTable.getInstance().editEntry(u);
				}
				else if (PersonTable.getInstance().getEntry(firstName, middleInit, lastName) == null) {
					p.setFirstName(firstName);
					p.setMiddleInitial(middleInit.charAt(0));
					p.setLastName(lastName);
					
					PersonTable.getInstance().editEntry(p);

					u.setUsername(username);
					u.setPassword(password);
					u.setClearanceID(clearanceID);
					
					UserAccountTable.getInstance().editEntry(u);
				}
				else {
					p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);
					
					u.setUsername(username);
					u.setPassword(password);
					u.setClearanceID(clearanceID);
					u.setPersonID(p.getID());
					
					UserAccountTable.getInstance().editEntry(u);
				}
			}
			myScreen.refreshScreen();
		}
	}

	public void fillTable() {
		DefaultTableModel model = (DefaultTableModel)myScreen.getUserTable().getModel();
		
		int rowCount = model.getRowCount();
		for (int i = 0; i < rowCount; i++)
			model.removeRow(0);
		
		Query stmt = new SelectRowUserTable();
		stmt.executeStatement();
		
		for (int i = 0; i < stmt.getResultList().size(); i++)
			model.addRow((Vector)stmt.getResultList().get(i));
	}

	public void addUserClicked() {
		myScreen.refreshScreen();
		
		myScreen.getUsernameTextField().setEditable(true);
		myScreen.getUsernameTextField().setText("");
		myScreen.getPasswordTextField().setEditable(true);
		myScreen.getPasswordTextField().setText("");
		myScreen.getClearanceComboBox().setEnabled(true);
		myScreen.getSelectExistingComboBox().setEnabled(true);
		myScreen.getFirstNameTextField().setEditable(true);
		myScreen.getFirstNameTextField().setText("");
		myScreen.getMiddleInitTextField().setEditable(true);
		myScreen.getMiddleInitTextField().setText("");
		myScreen.getLastNameTextField().setEditable(true);
		myScreen.getLastNameTextField().setText("");

		myScreen.getChangeDetailsButton().setText("Save Details");
	}

	public void selectedChanged() {
		if (myScreen.getSelectExistingComboBox().getSelectedIndex() == -1) {
			return;
		}
		if (myScreen.getSelectExistingComboBox().getSelectedItem().equals("")) {
			return;
		}
		
		String fullName = myScreen.getSelectExistingComboBox().getSelectedItem() + "";
		String[] nameArray = fullName.split("\\.");
		
		String lastName = nameArray[1].substring(1);
		String middleInit = nameArray[0].charAt(nameArray[0].length()-1) + "";
		String firstName = nameArray[0].substring(0, nameArray[0].length()-2);
		
		myScreen.getFirstNameTextField().setText(firstName);
		myScreen.getMiddleInitTextField().setText(middleInit);
		myScreen.getLastNameTextField().setText(lastName);
	}
}
