package screenBehaviourStrategy;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import actionLogger.ActionLogIn;
import actionLogger.ActionLogOut;

import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.ClearanceLookUpTable;
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
		mainScreen.setAccountSettingsButtonListener(new AccountSettingsButtonListener());
		mainScreen.setLogOutButtonListener(new LogOutButtonListener());
		mainScreen.setViewAssetsButtonListener(new ViewAssetsButtonListener());
		mainScreen.setManageAccountsButtonListener(new ManageAccountsButtonListener());
		mainScreen.setViewLogsButtonListener(new ViewLogsButtonListener());
	}
	
	class AccountSettingsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			gotoAccountScreen();
		}
	}
	
	class LogOutButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			logout();		
		}
	}
	
	class ViewAssetsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			gotoViewAssetScreen();
		}
	}
	
	class ManageAccountsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			gotoAdminScreen();	
		}
	}
	
	class ViewLogsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			gotoLogScreen();
		}
	}
	
	public MainScreen getView(){
		return mainScreen;
	}
	
	public void logout() {
		
		ActionLogOut action = new ActionLogOut(MainScreen.getCurrentUser().getID());
		action.logAction();
		MainScreen.setCurrentUser(null);
		
		mainScreen.gotoGreetingScreen();
		mainFrame.swapToLoginScreenCard();
	}
	
	public void gotoGreetingScreen() {
		mainScreen.gotoGreetingScreen();
	}
	public void gotoViewAssetScreen() {
		mainScreen.gotoViewAssetScreen();
	}
	public void gotoAdminScreen() {
		mainScreen.gotoAdminScreen();
	}
	public void gotoAccountScreen() {
		mainScreen.gotoAccountScreen();
	}
	public void gotoLogScreen() {
		mainScreen.gotoLogScreen();
	}
	public void gotoAddAssetScreen() {
		mainScreen.gotoAddAssetScreen();
	}
	public void gotoEditAssetScreen() {
		mainScreen.gotoEditAssetScreen();
	}

	public void loadEntry(int id) {
		Asset a = AssetTable.getInstance().getEntry(id);
		if(a!=null)
			mainScreen.loadEntry(a);
	}
}
