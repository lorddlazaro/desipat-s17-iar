package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import actionLogger.ActionLogIn;
import dataObjects.ClearanceLookUpTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import dbHandler.NonQuery;
import phase2.MainFrame;
import screens.LoginScreen;
import screens.MainScreen;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	private UserAccountTable userAccountTable;
	private MainFrame mainFrame;
	private LoginScreen loginScreen;
	
	public LoginScreenBehaviour(MainFrame frame){
		userAccountTable = userAccountTable.getInstance();
		loginScreen = new LoginScreen(this);
		mainFrame = frame;
		loginScreen.setLoginButtonListener(new LoginButtonListener());
	}
	
	public LoginScreen getView(){
		return loginScreen;
	}
	
	class LoginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			login();
		}
		
	}

	public void login() {
		for(UserAccount userAccount:userAccountTable.getAllEntries(true)){
			if(loginScreen.getUsernameInput().equals(userAccount.getUsername()))
				if(loginScreen.getPasswordInput().equals(userAccount.getPassword())){
					MainScreen.setCurrentUser(userAccount);
					setMainScreenRestrictions(userAccount.getClearanceID());
					ActionLogIn action = new ActionLogIn(userAccount.getID());
					action.logAction();
					mainFrame.swapToMainScreenCard();
					return;
				}
				else{
					loginScreen.clearErrorMessages();
					loginScreen.setPasswordFieldErrorMessage("wrong password");
					return;
				}
		}
		loginScreen.clearErrorMessages();
		loginScreen.setUsernameFieldErrorMessage("user not found");
	}
	
	public void setMainScreenRestrictions(int id){
		String clearance =  ClearanceLookUpTable.getInstance().getAllEntries().get(id).getClearanceLevel();
		
		mainFrame.getMainScreen().resetVisibility();

		if(clearance.equals("Admin"))
			mainFrame.getMainScreen().setViewAssetsButtonVisibility(false);
		else if(clearance.equals("Executive") || clearance.equals("User"))
			mainFrame.getMainScreen().setManageAccountsButtonVisibility(false);
		else if(clearance.equals("Auditor")){
			mainFrame.getMainScreen().setViewAssetsButtonVisibility(false);
			mainFrame.getMainScreen().setManageAccountsButtonVisibility(false);
		}
	}
}
