package screenBehaviourStrategy;

import actionLogger.ActionLogIn;
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
	}
	
	public LoginScreen getView(){
		return loginScreen;
	}
	
	public void login() {
		for(UserAccount userAccount:userAccountTable.getAllEntries()){
			if(loginScreen.getUsernameInput().equals(userAccount.getUsername()))
				if(loginScreen.getPasswordInput().equals(userAccount.getPassword())){
					MainScreen.setCurrentUser(userAccount);
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
		
		// TODO: Logging, account clearance
	}
}
