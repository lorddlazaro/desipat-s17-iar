package screenBehaviourStrategy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.UserAccountTable;
import screens.AccountSettingsScreen;
import screens.MainScreen;

public class AccountSettingsScreenBehavior implements AccountSettingsScreenBehaviourStrategy{
	private AccountSettingsScreen myScreen;
	
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
		if (!myScreen.isEditPasswordMode()) { //edit details
			myScreen.changeToEditPasswordMode();
		}
		else { //cancel
			myScreen.initSettings(MainScreen.getCurrentUser());
		}
	}

	public void updateName() {
		if(!myScreen.isEditNameMode()){
			myScreen.changeToUpdateNameMode();
		}
		else {
			if (!myScreen.checkUpdateName()) {
				return;
			}
			
			Person p = PersonTable.getInstance().getEntry(MainScreen.getCurrentUser().getPersonID());
			
			p.setFirstName(myScreen.getFirstName());
			p.setMiddleInitial(myScreen.getMiddleInitial().charAt(0));
			p.setLastName(myScreen.getLastName());
			
			PersonTable.getInstance().editEntry(p);
			
			myScreen.initSettings(MainScreen.getCurrentUser());
		}
	}
	
	public void saveAcctDetails() {
		if (!myScreen.checkNewPassword(MainScreen.getCurrentUser()))
			return;
		MainScreen.getCurrentUser().setPassword(myScreen.getNewPassword());
		
		UserAccountTable.getInstance().editEntry(MainScreen.getCurrentUser());
		myScreen.initSettings(MainScreen.getCurrentUser());
	}
	
	public AccountSettingsScreen getView() {
		return myScreen;
	}

}
