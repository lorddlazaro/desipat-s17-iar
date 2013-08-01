package screenBehaviourStrategy;

import screens.LoginScreen;
import dataObjects.UserAccountTable;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	UserAccountTable table;
	private LoginScreen loginScreen;
	
	public LoginScreenBehaviour(){
		table = table.getInstance();
		loginScreen = new LoginScreen(this);
		table.registerObserver(loginScreen);
	}
	
	public LoginScreen getView(){return loginScreen;}
	public void login() {
	
	}

}
