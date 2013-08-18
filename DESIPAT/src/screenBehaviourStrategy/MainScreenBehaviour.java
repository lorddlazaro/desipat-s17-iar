package screenBehaviourStrategy;

import java.awt.CardLayout;

import javax.swing.JPanel;

import actionLogger.ActionLogIn;
import actionLogger.ActionLogOut;

import dataObjects.UserAccount;
import dataObjects.UserAccountTable;
import screens.MainScreen;
import phase2.MainFrame;;

public class MainScreenBehaviour implements MainScreenBehaviourStrategy {

	MainFrame mainFrame;
	MainScreen mainScreen;
	
	
	
	public MainScreenBehaviour(MainFrame frame){
		mainScreen = new MainScreen(this);
		mainFrame = frame;
	}
	
	public MainScreen getView(){
		return mainScreen;
	}
	

	public void gotoGreetingScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.GREETING_SCREEN);
	}

	public void gotoViewAssetScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.VIEW_ASSET_SCREEN);
	}

	public void gotoAdminScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.ADMIN_SCREEN);
	}

	public void gotoAccountScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.ACCOUNT_SETTINGS_SCREEN);
	}

	public void gotoLogScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.VIEW_LOG_SCREEN);
	}

	public void logout() {
		this.gotoGreetingScreen();
		ActionLogOut action = new ActionLogOut(MainScreen.getCurrentUser().getID());
		action.logAction();
		mainFrame.swapToLoginScreenCard();
	}

	public void gotoAddAssetScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.ADD_ASSET_SCREEN);
	}
	public void gotoEditAssetScreen() {
		CardLayout cl = (CardLayout) mainScreen.getCardPanel().getLayout();
		cl.show(mainScreen.getCardPanel(), mainScreen.EDIT_ASSET_SCREEN);		
	}
}
