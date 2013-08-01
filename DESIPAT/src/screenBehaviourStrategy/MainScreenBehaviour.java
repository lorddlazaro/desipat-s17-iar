package screenBehaviourStrategy;

import screens.MainScreen;

public class MainScreenBehaviour implements MainScreenBehaviourStrategy {

	//private Model model;
	MainScreen mainScreen;
	
	//todo: add model to mainscreenbehaviour's constructor parameter
	public MainScreenBehaviour(){
		//pass model to new mainscreen 
		mainScreen = new MainScreen(this);
		//this.model=model;
	}
	
	public MainScreen getView(){
		return mainScreen;
	}

	public void gotoViewAssetScreen() {
	}

	public void gotoAdminScreen() {
	}

	public void gotoAccountScreen() {
	}

	public void gotoLogScreen() {
	}

	public void logout() {
	}

}
