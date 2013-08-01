package screenBehaviourStrategy;

import dataObjects.UserAccountTable;
import screens.MainScreen;

public class MainScreenBehaviour implements MainScreenBehaviourStrategy {

	MainScreen mainScreen;
	public MainScreenBehaviour(){
		mainScreen = new MainScreen(this);
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
