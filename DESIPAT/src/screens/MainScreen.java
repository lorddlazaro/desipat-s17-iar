package screens;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import screenBehaviourStrategy.AccountSettingsScreenBehavior;
import screenBehaviourStrategy.AddAssetScreenBehavior;
import screenBehaviourStrategy.AdminScreenBehavior;
import screenBehaviourStrategy.EditAssetScreenBehavior;
import screenBehaviourStrategy.LogsScreenBehavior;
import screenBehaviourStrategy.MainScreenBehaviourStrategy;
import screenBehaviourStrategy.ViewAssetScreenBehaviour;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.UserAccount;
import dataObjects.UserAccountTable;


public class MainScreen extends Screen{

	public final String GREETING_SCREEN = "greeting";
	public final String ACCOUNT_SETTINGS_SCREEN = "accountsetting";
	public final String VIEW_ASSET_SCREEN = "viewasset";
	public final String ADD_ASSET_SCREEN = "addasset";
	public final String EDIT_ASSET_SCREEN = "editasset";
	public final String ADMIN_SCREEN = "adminuser";
	public final String VIEW_LOG_SCREEN = "viewlog";
	
	private MainScreenBehaviourStrategy behaviour;
	
	private JLabel lblGreeting;
	private JLabel lblCurrentUser;
	private JButton btnAccountSettings;
	private JButton btnLogOut;
	
	private JPanel menuBar;
	private JButton btnViewAssets;
	private JButton btnManageAccounts;
	private JButton btnViewLogs;
	
	private JPanel cardPanel;

	private JPanel greetingCard;
	private AccountSettingsScreen accountSettingsCard;
	private ViewAssetScreen viewAssetCard;
	private FormAssetScreen addAssetCard;
	private FormAssetScreen editAssetCard;
	private AdminScreen adminCard;
	private LogScreen viewLogsCard;
	
	private static UserAccount currentUser;
	
	public MainScreen(MainScreenBehaviourStrategy behaviour) {
		this.behaviour = behaviour;
		initialize();
	}
	
	public void initialize(){
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		// TOP BAR
		lblGreeting = new JLabel("Hello,");
		lblGreeting.setBounds(12, 16, 46, 14);
		lblGreeting.setFont(new Font("Calibri", Font.PLAIN, 16));
		add(lblGreeting);
		
		lblCurrentUser = new JLabel("user");
		lblCurrentUser.setBounds(54, 16, 191, 14);
		lblCurrentUser.setFont(new Font("Calibri", Font.BOLD, 18));
		add(lblCurrentUser);
		
		btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.setBounds(538, 12, 143, 23);
		btnAccountSettings.setBackground(new Color(128, 128, 128));
		btnAccountSettings.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(btnAccountSettings);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(693, 12, 89, 23);
		btnLogOut.setForeground(new Color(139, 0, 0));
		btnLogOut.setBackground(new Color(255, 127, 80));
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(btnLogOut);
		
		menuBar = new JPanel();
		menuBar.setBounds(10, 47, 772, 50);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(188, 143, 143));
		menuBar.setLayout(null);
		add(menuBar);
		
		
		// BUTTON BAR
		JLabel lblTitle = new JLabel("Asset Management Registry");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(102, 0, 0));
		lblTitle.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblTitle.setBounds(12, -6, 339, 50);
		menuBar.add(lblTitle);
		
		btnViewAssets = new JButton("View Assets");
		btnViewAssets.setForeground(new Color(25, 25, 112));
		btnViewAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewAssets.setBackground(new Color(70, 130, 180));
		btnViewAssets.setBounds(352, 0, 140, 50);
		menuBar.add(btnViewAssets);
		
		btnManageAccounts = new JButton("Manage Accounts");
		btnManageAccounts.setForeground(new Color(0, 100, 0));
		btnManageAccounts.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnManageAccounts.setBackground(new Color(60, 179, 113));
		btnManageAccounts.setBounds(492, 0, 140, 50);
		menuBar.add(btnManageAccounts);
		
		btnViewLogs = new JButton("View Logs");
		btnViewLogs.setForeground(new Color(160, 82, 45));
		btnViewLogs.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewLogs.setBackground(new Color(238, 232, 170));
		btnViewLogs.setBounds(632, 0, 140, 50);
		menuBar.add(btnViewLogs);
		
		

		// CARDS PANEL
		cardPanel = new JPanel();
		cardPanel.setBounds(10, 109, 772, 454);
		cardPanel.setBorder(UIManager.getBorder("ProgressBar.border"));
		cardPanel.setBackground(Color.LIGHT_GRAY);
		cardPanel.setLayout(new CardLayout());
		add(cardPanel);
		
		greetingCard = new JPanel();
		cardPanel.add(greetingCard, this.GREETING_SCREEN);
		
		accountSettingsCard = new AccountSettingsScreenBehavior().getView();
		cardPanel.add(accountSettingsCard, this.ACCOUNT_SETTINGS_SCREEN);
		
		viewAssetCard = new ViewAssetScreenBehaviour(behaviour).getView();
		cardPanel.add(viewAssetCard, this.VIEW_ASSET_SCREEN);
		
		addAssetCard = new AddAssetScreenBehavior().getView();
		cardPanel.add(addAssetCard, this.ADD_ASSET_SCREEN);
		
		editAssetCard = new EditAssetScreenBehavior().getView();
		cardPanel.add(editAssetCard, this.EDIT_ASSET_SCREEN);
		
		adminCard = new AdminScreenBehavior().getView();
		cardPanel.add(adminCard, this.ADMIN_SCREEN);	
			
		viewLogsCard = new LogsScreenBehavior(behaviour).getView();
		cardPanel.add(viewLogsCard, this.VIEW_LOG_SCREEN);	
	}
	
	public void setAccountSettingsButtonListener(ActionListener listener){
		btnAccountSettings.addActionListener(listener);
	}
	
	public void setLogOutButtonListener(ActionListener listener){
		btnLogOut.addActionListener(listener);
	}
	
	public void setViewAssetsButtonListener(ActionListener listener){
		btnViewAssets.addActionListener(listener);
	}
	
	public void setManageAccountsButtonListener(ActionListener listener){
		btnManageAccounts.addActionListener(listener);
	}
	
	public void setViewLogsButtonListener(ActionListener listener){
		btnViewLogs.addActionListener(listener);
	}

	public void setViewAssetsButtonVisibility(boolean bool){
		btnViewAssets.setVisible(bool);
	}

	public void setManageAccountsButtonVisibility(boolean bool){
		btnManageAccounts.setVisible(bool);
	}
	
	public void setViewLogsButtonVisibility(boolean bool){
		btnViewLogs.setVisible(bool);
	}
	
	public void resetVisibility(){
		btnViewAssets.setVisible(true);
		btnManageAccounts.setVisible(true);
		btnViewLogs.setVisible(true);
	}
	
	public static UserAccount getCurrentUser(){
		return currentUser;
	}
	public static void setCurrentUser(UserAccount userAccount){
		currentUser = userAccount;
	}
	public void changeCurrentUserLabel(){
		this.lblCurrentUser.setText(currentUser.getUsername());
	}
	
	public void refresh(){
		changeCurrentUserLabel();
		accountSettingsCard.setCurrentUser();
	}
	
	public void gotoGreetingScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.GREETING_SCREEN);
	}
	public void gotoViewAssetScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.VIEW_ASSET_SCREEN);
	}
	public void gotoAdminScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		this.adminCard.resetScreen();
		cl.show(cardPanel, this.ADMIN_SCREEN);
	}
	public void gotoAccountScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.ACCOUNT_SETTINGS_SCREEN);
	}
	public void gotoLogScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.VIEW_LOG_SCREEN);
	}
	public void gotoAddAssetScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.ADD_ASSET_SCREEN);
	}
	public void gotoEditAssetScreen() {
		CardLayout cl = (CardLayout) cardPanel.getLayout();
		cl.show(cardPanel, this.EDIT_ASSET_SCREEN);		
	}

	public void loadEntry(Asset a) {
		editAssetCard.loadEntry(a);
	}
}
