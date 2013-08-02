package screenBehaviourStrategy;

import dataObjects.UserAccountTable;
import screens.MainScreen;
import phase2.MainFrame;;

public class MainScreenBehaviour implements MainScreenBehaviourStrategy {

	MainScreen mainScreen;
	MainFrame mainFrame;
	public MainScreenBehaviour(MainFrame frame){
		mainScreen = new MainScreen(this);
		mainFrame = frame;
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
