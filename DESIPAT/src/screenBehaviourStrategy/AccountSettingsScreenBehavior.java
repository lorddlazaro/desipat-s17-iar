package screenBehaviourStrategy;

import dataObjects.UserAccount;
import screens.AccountSettingsScreen;

public class AccountSettingsScreenBehavior implements AccountSettingsScreenBehaviourStrategy{
	private AccountSettingsScreen myScreen;

	public AccountSettingsScreenBehavior(AccountSettingsScreen s) {
		myScreen = s;
	}
	
	public void changeDetails() {
		if (myScreen.getChangeDetailsButton().getText().equals("Change Details")) {
			myScreen.getChangeDetailsButton().setText("Cancel");
			
			myScreen.getPasswordField().setEditable(true);
			myScreen.getPasswordField().setText("");
	
			myScreen.getNewPasswordLabel().setText("");
			myScreen.getNewPasswordLabel().setVisible(true);
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
	}
}
