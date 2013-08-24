package screenBehaviourStrategy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import screens.AccountSettingsScreen;
import screens.AdminScreen;
import screens.MainScreen;

public class AccountSettingsScreenBehavior implements AccountSettingsScreenBehaviourStrategy{
	private AccountSettingsScreen myScreen;
	private UserAccount currUser;
	
	public AccountSettingsScreenBehavior() {
		myScreen = new AccountSettingsScreen(this);
		myScreen.setChangeDetailsButtonListener(new ChangeDetailsButtonListener());
		myScreen.setSaveDetailsButtonListener(new SaveDetailsButtonListener());
		myScreen.setChangeNameButtonListener(new ChangeNameButtonListener());
	}
	
	class ChangeDetailsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			changeDetails();
		}
	}
	
	class SaveDetailsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			saveAcctDetails();
		}
	}
	
	class ChangeNameButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			updateName();
		}
	}

	public void changeDetails() {
		if (myScreen.getChangeDetailsButton().getText().equals("Change Details")) {
			myScreen.getChangeDetailsButton().setText("Cancel");
			
			myScreen.getPasswordField().setEditable(true);
			myScreen.getPasswordField().setText("");
	
			myScreen.getNewPasswordField().setText("");
			myScreen.getNewPasswordField().setVisible(true);
			myScreen.getNewPasswordLabel().setVisible(true);
			myScreen.getSaveDetailsButton().setVisible(true);
		}
		else {
			myScreen.initSettings();
		}

	}

	public void updateName() {
		if (myScreen.getChangeNameButton().getText().equals("Update Name")) {
			myScreen.getChangeNameButton().setText("Save");
			myScreen.getFirstNameLabel().setVisible(true);
			myScreen.getMiddleInitLabel().setVisible(true);
			myScreen.getLastNameLabel().setVisible(true);
	
			myScreen.getFirstNameTextField().setVisible(true);
			myScreen.getMiddleInitialTextField().setVisible(true);
			myScreen.getLastNameTextField().setVisible(true);
		}
		else {
			if (!myScreen.checkUpdateName()) {
				System.out.println("sadsd");
				return;
			}
			
			Person p = PersonTable.getInstance().getEntry(currUser.getPersonID());
			
			p.setFirstName(myScreen.getFirstNameTextField().getText());
			p.setMiddleInitial(myScreen.getMiddleInitialTextField().getText().charAt(0));
			p.setLastName(myScreen.getLastNameTextField().getText());
			
			PersonTable.getInstance().editEntry(p);
			
			myScreen.initSettings();
		}
	}
	
	public AccountSettingsScreen getView() {
		return myScreen;
	}

	public void saveAcctDetails() {
		if (!myScreen.checkNewPassword())
			return;
		currUser.setPassword(myScreen.getNewPasswordField().getText());
		
		UserAccountTable.getInstance().editEntry(currUser);
		myScreen.initSettings();
	}
	

	public UserAccount getCurrUser() {
		return currUser;
	}

	public void setCurrUser(UserAccount currUser) {
		this.currUser = currUser;
	}
}
