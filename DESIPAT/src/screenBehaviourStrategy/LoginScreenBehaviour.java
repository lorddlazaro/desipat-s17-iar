package screenBehaviourStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import phase1.ActionLogger;
import phase1.DBConnection;
import phase1.UserScreen;
import phase2.MainFrame;
import screens.LoginScreen;
import dataObjects.TableEntry;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import phase2.MainFrame;
import screens.MainScreen;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	UserAccountTable userAccountTable;
	private LoginScreen loginScreen;
	private MainFrame mainFrame;
	
	public LoginScreenBehaviour(MainFrame frame){
		userAccountTable = userAccountTable.getInstance();
		
		loginScreen = new LoginScreen(this);
		
		mainFrame = frame;
	}
	
	public LoginScreen getView(){
		return loginScreen;
	}
	public void login() {
		System.out.println( userAccountTable.getAllEntries().size());
		
<<<<<<< .mine
		for(UserAccount userAccount:userAccountTable.getAllEntries()){
			if(loginScreen.getPasswordInput().equals(userAccount.getPassword()) && loginScreen.getUsernameInput().equals(userAccount.getUsername())){
				MainScreen.setCurrentUser(userAccount);
=======
		for(TableEntry tableEntry:table.getAllEntries()){
			UserAccount userAccount = (UserAccount) tableEntry;
			if(loginScreen.getPasswordInput().equals(userAccount.getPassword()) && loginScreen.getUsernameInput().equals(userAccount.getUsername())) {
>>>>>>> .r293
				mainFrame.swapToMainScreenCard();
<<<<<<< .mine
			}
		
=======
			}
>>>>>>> .r293
		}
		
		//Log action
		//Swap Card
		//Set account clearance level
	}
}
