package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dataObjects.ClearanceLookUpTable;
import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;

import screens.AdminScreen;
import screens.TableObserver;


public class AdminScreenBehavior implements AdminScreenBehaviorStrategy, TableObserver{

	AdminScreen myScreen;
	
	private boolean makingNewUser = false;
	
	public AdminScreenBehavior() {
		myScreen = new AdminScreen(this);
		fillClearance();
		myScreen.refreshScreen();
		myScreen.setDeleteUserButtonListener(new DeleteUserButtonListener());
		myScreen.setChangeDetailsButtonListener(new ChangeDetailsButtonListener());
		myScreen.setCancelChangesButtonListener(new CancelChangesButtonListener());
		myScreen.setAddUserButtonListener(new AddUserButtonListener());
		myScreen.setUserTableListener(new UserTableListener());
		myScreen.setSelectExistingComboBoxListener(new SelectExistingComboBoxListener());
		refresh();
	}
	
	class DeleteUserButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			deleteUserClicked();
		}
	}
	
	class ChangeDetailsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			changeDetailsClicked();
		}
	}
	
	class CancelChangesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			makingNewUser = false;
			myScreen.refreshScreen();			
		}
	}
	
	class AddUserButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			addUserClicked();
		}
	}
	
	class UserTableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			selectedCellChanged();
		}
	}
	
	class SelectExistingComboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			selectedChanged();
		}
	}
	
	public void selectedCellChanged() {
		int selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
		UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
		
		myScreen.getUsernameTextField().setText(u.getUsername());
		myScreen.getPasswordTextField().setText(u.getPassword());
		myScreen.getClearanceComboBox().setSelectedItem(u.getClearance().getClearanceLevel());
		myScreen.getFirstNameTextField().setText(u.getPersonFirstName());
		myScreen.getMiddleInitTextField().setText(u.getPersonMiddleName());
		myScreen.getLastNameTextField().setText(u.getPersonLastName());
		
		fillSelectExisting();
	}
	
	public void fillSelectExisting() {
		myScreen.getSelectExistingComboBox().removeAllItems();
		myScreen.getSelectExistingComboBox().addItem("");
		
		ArrayList<Person> list = PersonTable.getInstance().getPersonsWithNoAccount();
		
		for (int i = 0; i < list.size(); i++)
			myScreen.getSelectExistingComboBox().addItem(list.get(i).getFirstName() + " " + list.get(i).getMiddleInitial() + ". " + list.get(i).getLastName());
	}

	public void deleteUserClicked() {
		if (myScreen.getUserTable().getSelectedRow() == -1)
			return;
		
		int selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
		UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
		UserAccountTable.getInstance().deleteEntry(u);
		System.out.println("deleted user");
		myScreen.refreshScreen();

		myScreen.getUsernameTextField().setText("");
		myScreen.getPasswordTextField().setText("");
		myScreen.getFirstNameTextField().setText("");
		myScreen.getMiddleInitTextField().setText("");
		myScreen.getLastNameTextField().setText("");
	}

	public void changeDetailsClicked() {
		if (myScreen.getChangeDetailsButton().getText().equals("Change Details")) {
			myScreen.getUsernameTextField().setEditable(false);
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
			
			int clearanceID = ClearanceLookUpTable.getInstance().getEntry(myScreen.getClearanceComboBox().getSelectedItem().toString()).getID();
			
			String firstName = myScreen.getFirstNameTextField().getText();
			String middleInit = myScreen.getMiddleInitTextField().getText();
			String lastName = myScreen.getLastNameTextField().getText();
			
			if (makingNewUser) {
				Person p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);

				if (p == null) { // new person
					p = new Person(-1, firstName, middleInit.charAt(0), lastName);
					PersonTable.getInstance().addEntry(p);
				}
				else { // existing person
					if (UserAccountTable.getInstance().checkForUser(p)) {
						myScreen.personAlreadyExists();
						return;
					}
				}

				UserAccount u = new UserAccount(-1, username, password, clearanceID, p.getID(), 1);
				UserAccountTable.getInstance().addEntry(u);
			}
			else {
				if (myScreen.getUserTable().getSelectedRow() != -1)
					selectedUserID = Integer.parseInt(myScreen.getUserTable().getModel().getValueAt(myScreen.getUserTable().getSelectedRow(), 0) + "");
				else {
					myScreen.showErrorNoSelectedUser();
					return;
				}
				
				UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
				Person p = PersonTable.getInstance().getEntry(u.getPersonID());
				
				if (p == null) { // person not in list f persons, new person
					System.out.println("new person");
					p = new Person(-1, firstName, middleInit.charAt(0), lastName);
					PersonTable.getInstance().addEntry(p);
				}
				else if (PersonTable.getInstance().getEntry(firstName, middleInit, lastName) == null) {
					// person in list of persons but name was changed
					System.out.println("update person");
					p.setFirstName(firstName);
					p.setMiddleInitial(middleInit.charAt(0));
					p.setLastName(lastName);
					
					PersonTable.getInstance().editEntry(p);
				}
				else { // person not changed at all
					System.out.println("nothing person");
					p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);
				}
				
				u.setUsername(username);
				u.setPassword(password);
				u.setClearanceID(clearanceID);
				u.setPersonID(p.getID());

				UserAccountTable.getInstance().editEntry(u);
			}

			makingNewUser = false;
			myScreen.getChangeDetailsButton().setText("Change Details");
			myScreen.refreshScreen();
		}
	}

	public void fillTable() {
		DefaultTableModel model = (DefaultTableModel)myScreen.getUserTable().getModel();
		
		int rowCount = model.getRowCount();
		for (int i = 0; i < rowCount; i++)
			model.removeRow(0);
		
		ArrayList<UserAccount> list = UserAccountTable.getInstance().getAllEntries(true);
		
		for (int i = 0; i < list.size(); i++)
			model.addRow(new Object[] {list.get(i).getID(), list.get(i).getUsername(), list.get(i).getPassword(), list.get(i).getClearance().getClearanceLevel(), list.get(i).getPersonFirstName(), list.get(i).getPersonMiddleName(), list.get(i).getPersonLastName()});
	}

	public void addUserClicked() {
		myScreen.refreshScreen();
		makingNewUser = true;
		
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
	
	public AdminScreen getView() {
		return myScreen;
	}

	public void fillClearance() {
		for (int i = 0; i < ClearanceLookUpTable.getInstance().getAllEntries().size(); i++) {
			myScreen.getClearanceComboBox().addItem(ClearanceLookUpTable.getInstance().getAllEntries().get(i).getClearanceLevel());
		}
	}

	@Override
	public void refresh() {
		myScreen.setUserTableModel(UserAccountTable.getInstance().createTableModel());
	}
}
