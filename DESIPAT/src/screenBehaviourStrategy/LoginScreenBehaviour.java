package screenBehaviourStrategy;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import phase1.ActionLogger;
import phase1.DBConnection;
import phase1.MainScreen;
import phase1.UserScreen;
import screens.LoginScreen;
import dataObjects.TableEntry;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	UserAccountTable table;
	private LoginScreen loginScreen;
	
	public LoginScreenBehaviour(){
		table = table.getInstance();
		loginScreen = new LoginScreen(this);
		table.registerObserver(loginScreen);
		
	}
	
	public LoginScreen getView(){
		return loginScreen;
	}
	public void login() {
		for(TableEntry tableEntry:table.getAllEntries()){
			UserAccount userAccount = (UserAccount) tableEntry;
			
		}
			
		//Log action
		//Swap Card
		//Set account clearance level
	}
}
