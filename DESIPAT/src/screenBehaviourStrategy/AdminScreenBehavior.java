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
		myScreen.resetScreen();
		myScreen.setDeleteUserButtonListener(new DeleteUserButtonListener());
		myScreen.setChangeDetailsButtonListener(new ChangeDetailsButtonListener());
		myScreen.setCancelChangesButtonListener(new CancelChangesButtonListener());
		myScreen.setAddUserButtonListener(new AddUserButtonListener());
		myScreen.setUserTableListener(new UserTableListener());
		myScreen.setSelectExistingComboBoxListener(new SelectExistingComboBoxListener());
		refresh();
	}
	
	//Action Listeners
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
			myScreen.resetScreen();			
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
	
	
	
	//Methods called by the action listeners
	public void selectedCellChanged() {
		int selectedUserID = myScreen.getSelectedUserID();
		UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
		myScreen.displayUser(u);
	}
	
	public void fillSelectExisting(){
		myScreen.setPersonsWithNoAccount(PersonTable.getInstance().getPersonsWithNoAccount());
	}
	
	public void deleteUserClicked() {
		int selectedUserID = myScreen.getSelectedUserID();
		
		if (selectedUserID != -1)
		{
			UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
			UserAccountTable.getInstance().deleteEntry(u);
			myScreen.resetScreen();
			myScreen.clearUserDetails();
		}
	}

	public void changeDetailsClicked() {
		if (!myScreen.isEditMode()) {
			myScreen.setModeToChangeDetails();
		}
		else { //save changes
			if (!myScreen.checkInputs())
				return;
			int selectedUserID = -1;

			String username = myScreen.getUsername();
			String password = myScreen.getPassword();
			
			int clearanceID = ClearanceLookUpTable.getInstance().getEntry(myScreen.getSelectedClearance()).getID();
			
			String firstName = myScreen.getFirstName();
			String middleInit = myScreen.getMiddleInitial();
			String lastName = myScreen.getLastName();
			
			if (makingNewUser) {
				Person p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);

				if (p == null) { // new person
					p = new Person(-1, firstName, middleInit.charAt(0), lastName);
					PersonTable.getInstance().addEntry(p);
				}
				else { // existing person
					if (UserAccountTable.getInstance().checkForUser(p)) {
						myScreen.displayError("This person already has an account.");
						return;
					}
				}

				UserAccount u = new UserAccount(-1, username, password, clearanceID, p.getID(), 1);
				UserAccountTable.getInstance().addEntry(u);
			}
			else {
				selectedUserID = myScreen.getSelectedUserID();
				
				if(selectedUserID == -1){
					myScreen.displayError("Please select a person on the table before editing.");
					return;
				}
				
				UserAccount u = UserAccountTable.getInstance().getEntry(selectedUserID);
				Person p = PersonTable.getInstance().getEntry(u.getPersonID());
				
				if (p == null) { // person not in list of persons, new person
					p = new Person(-1, firstName, middleInit.charAt(0), lastName);
					PersonTable.getInstance().addEntry(p);
				}
				else if (PersonTable.getInstance().getEntry(firstName, middleInit, lastName) == null) {
					// person in list of persons but name was changed
					p.setFirstName(firstName);
					p.setMiddleInitial(middleInit.charAt(0));
					p.setLastName(lastName);
					
					PersonTable.getInstance().editEntry(p);
				}
				else { // person not changed at all
					p = PersonTable.getInstance().getEntry(firstName, middleInit, lastName);
				}
				
				u.setUsername(username);
				u.setPassword(password);
				u.setClearanceID(clearanceID);
				u.setPersonID(p.getID());

				UserAccountTable.getInstance().editEntry(u);
			}

			makingNewUser = false;
			myScreen.resetScreen();
		}
	}

	public void fillTable() {
		myScreen.displayUserList(UserAccountTable.getInstance().createTableModel());	
	}

	public void addUserClicked() {
		myScreen.resetScreen();
		makingNewUser = true;
		myScreen.setModeToAddUser();
	}

	public void selectedChanged() {
		
		String fullName = myScreen.getSelectedPerson();
		
		if(fullName == null || fullName.trim().isEmpty())
			return;
		
		String[] nameArray = fullName.split("\\.");
		
		String lastName = nameArray[1].substring(1);
		char middleInit = nameArray[0].charAt(nameArray[0].length()-1);
		String firstName = nameArray[0].substring(0, nameArray[0].length()-2);
		
		myScreen.setFirstName(firstName);
		myScreen.setMiddleInitial(middleInit);
		myScreen.setFirstName(lastName);
	}
		
	public AdminScreen getView() {
		return myScreen;
	}

	public void fillClearance() {
		myScreen.setClearanceChoices(ClearanceLookUpTable.getInstance().getAllEntries());
	}

	
	
	
	//Called by TableSubject when it is notifying observers.
	@Override
	public void refresh() {
		fillTable();
	}
}
