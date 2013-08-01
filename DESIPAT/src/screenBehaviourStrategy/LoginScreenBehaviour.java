package screenBehaviourStrategy;

import screens.LoginScreen;
import dataObjects.UserAccountTable;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	//private Model model;
	UserAccountTable table;
	private LoginScreen loginScreen;
	
	//add model parameter to loginscreenbehaviour's constructor
	public LoginScreenBehaviour(UserAccountTable table){
		//add model to the new loginScreen constructor parameter
		this.table = table;
		loginScreen = new LoginScreen(this);
		//this.model = model;
		
	}
	
	public LoginScreen getView(){return loginScreen;}
	public void login() {
	
	}

}
