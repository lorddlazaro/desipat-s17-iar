package screenBehaviourStrategy;

import java.awt.CardLayout;

import javax.swing.JPanel;

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
		mainFrame.swapToLoginScreenCard();
	}

}
