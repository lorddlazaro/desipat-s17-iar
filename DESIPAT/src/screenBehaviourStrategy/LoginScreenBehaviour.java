package screenBehaviourStrategy;

import screens.LoginScreen;

public class LoginScreenBehaviour implements LoginScreenBehaviourStrategy{

	//private Model model;
	private LoginScreen loginScreen;
	
	//add model parameter to loginscreenbehaviour's constructor
	public LoginScreenBehaviour(){
		//add model to the new loginScreen constructor parameter
		loginScreen = new LoginScreen(this);
		//this.model = model;
	}
	
	public LoginScreen getView(){return loginScreen;}
	public void login() {
	
	}

}
