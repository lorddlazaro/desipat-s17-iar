package screenBehaviourStrategy;

import screens.LoginScreen;
import dataObjects.UserAccountTable;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	//private Model model;
	UserAccountTable table;
	private LoginScreen loginScreen;
	
	//add model parameter to loginscreenbehaviour's constructor
	public LoginScreenBehaviour(){
		//add model to the new loginScreen constructor parameter
		table = table.getInstance();
		loginScreen = new LoginScreen(this);
		table.registerObserver(loginScreen);
		//this.model = model;
		
	}
	
	public LoginScreen getView(){return loginScreen;}
	public void login() {
	
	}

}
