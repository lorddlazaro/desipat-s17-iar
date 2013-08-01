package Screens;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import phase2.Screen;

public class MainScreen extends Screen{

	private final String ACCOUNT_SETTINGS_SCREEN = "accountsetting";
	private final String VIEW_ASSET_SCREEN = "viewasset";
	private final String ADD_ASSET_SCREEN = "addasset";
	private final String EDIT_ASSET_SCREEN = "editasset";
	private final String ADMIN_SCREEN = "adminuser";
	private final String VIEW_LOG_SCREEN = "viewlog";
	private final String GREETING_SCREEN = "greeting";
	
	private JLabel lblGreeting;
	private JLabel lblUsername;
	private JLabel lblLastLogin;
	private JButton btnAccountSettings;
	private JButton btnLogOut;
	
	private JPanel menuBar;
	
	private JPanel cardPanel;
	
	private JPanel accountSettingsCard;
	private JPanel viewAssetCard;
	private JPanel addAssetCard;
	private JPanel editAssetCard;
	private JPanel adminCard;
	private JPanel viewLogsCard;
	private JPanel greetingCard;
	
	private JButton btnViewAssets;
	private JButton btnManageAccounts;
	private JButton btnViewLogs;
	
	public MainScreen() {
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
		
		lblUsername = new JLabel("user");
		lblUsername.setBounds(54, 16, 191, 14);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 18));
		add(lblUsername);
		
		lblLastLogin = new JLabel("Last Login:");
		lblLastLogin.setBounds(330, 16, 198, 14);
		lblLastLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastLogin.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(lblLastLogin);
		
		btnAccountSettings = new JButton("Account Settings");
		//btnAccountSettings.addActionListener(new ActionListener() {
		btnAccountSettings.setBounds(538, 12, 143, 23);
		btnAccountSettings.setBackground(new Color(128, 128, 128));
		btnAccountSettings.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(btnAccountSettings);
		
		btnLogOut = new JButton("Log Out");
		//btnLogOut.addActionListener(new ActionListener() {
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
		
		cardPanel = new JPanel();
		cardPanel.setBounds(10, 109, 772, 454);
		cardPanel.setBorder(UIManager.getBorder("ProgressBar.border"));
		cardPanel.setBackground(Color.LIGHT_GRAY);
		cardPanel.setLayout(new CardLayout());
		add(cardPanel);
		
		
		
		// BUTTON BAR
		JLabel lblTitle = new JLabel("Asset Management Registry");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(102, 0, 0));
		lblTitle.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblTitle.setBounds(12, -6, 339, 50);
		menuBar.add(lblTitle);
		
		btnViewAssets = new JButton("View Assets");
		btnViewAssets.setForeground(new Color(25, 25, 112));
		//btnViewAssets.addActionListener(new ActionListener();
		btnViewAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewAssets.setBackground(new Color(70, 130, 180));
		btnViewAssets.setBounds(352, 0, 140, 50);
		menuBar.add(btnViewAssets);
		
		btnManageAccounts = new JButton("Manage Accounts");
		btnManageAccounts.setForeground(new Color(0, 100, 0));
		//btnManageAccounts.addActionListener(new ActionListener();
		btnManageAccounts.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnManageAccounts.setBackground(new Color(60, 179, 113));
		btnManageAccounts.setBounds(492, 0, 140, 50);
		menuBar.add(btnManageAccounts);
		
		btnViewLogs = new JButton("View Logs");
		btnViewLogs.setForeground(new Color(160, 82, 45));
		//btnViewLogs.addActionListener(new ActionListener() ;
		btnViewLogs.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewLogs.setBackground(new Color(238, 232, 170));
		btnViewLogs.setBounds(632, 0, 140, 50);
		menuBar.add(btnViewLogs);
		
		
		
		// CARDS PANEL
		// TODO: this panel?
		greetingCard = new JPanel();
		cardPanel.add(greetingCard, this.GREETING_SCREEN);
		
		accountSettingsCard = new AccountSettingsScreen();
		cardPanel.add(accountSettingsCard, this.ACCOUNT_SETTINGS_SCREEN);
		
		viewAssetCard = new ViewAssetScreen();
		cardPanel.add(viewAssetCard, this.VIEW_ASSET_SCREEN);
		
		addAssetCard = new AddAssetScreen();
		cardPanel.add(addAssetCard, this.ADD_ASSET_SCREEN);
		
		editAssetCard = new EditAssetScreen();
		cardPanel.add(editAssetCard, this.EDIT_ASSET_SCREEN);
		
		adminCard = new AdminScreen();
		cardPanel.add(adminCard, this.ADMIN_SCREEN);	

		viewLogsCard = new LogScreen();
		cardPanel.add(viewLogsCard, this.VIEW_LOG_SCREEN);	
	}
	
	public void refresh(){}
}
