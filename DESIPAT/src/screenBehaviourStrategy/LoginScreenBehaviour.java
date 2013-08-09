package screenBehaviourStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import phase1.ActionLogger;
import phase1.DBConnection;
import phase1.MainScreen;
import phase1.UserScreen;
import phase2.MainFrame;
import screens.LoginScreen;
import dataObjects.TableEntry;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import phase2.MainFrame;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	UserAccountTable table;
	private LoginScreen loginScreen;
	private MainFrame mainFrame;
	
	public LoginScreenBehaviour(MainFrame frame){
		table = table.getInstance();
		loginScreen = new LoginScreen(this);
		table.registerObserver(loginScreen);	
		mainFrame = frame;
	}
	
	public LoginScreen getView(){
		return loginScreen;
	}
	public void login() {
		System.out.println( table.getAllEntries().size());
		
		for(TableEntry tableEntry:table.getAllEntries()){
			UserAccount userAccount = (UserAccount) tableEntry;
			if(loginScreen.getPasswordInput().equals(userAccount.getPassword()) && loginScreen.getUsernameInput().equals(userAccount.getUsername()))
				mainFrame.swapToMainScreenCard();
		}
			
		//Log action
		//Swap Card
		//Set account clearance level
	}
}
