package screens;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.regex.*;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import databaseTableObjects.User;


public class AccountSettingsScreen extends Screen {
	private JTextField usernameField;
	private JLabel lblName;
	private JLabel nameLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleInitialTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JPasswordField newPasswordField;
	private JButton changeDetailsButton;
	private JButton saveDetailsButton;
	private JLabel newPasswordLabel;
	private JPanel userSettingsPanel;
	private JLabel usernameLabel;
	private JLabel lblUserSettings;
	private JPanel namePanel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel middleInitLabel;
	private JPanel assetSummary;
	private JLabel lblSummaryTable;
	private JTextPane lblNetWorthList;
	private JTextPane lblNewestAssetList;
	private JTextPane lblMostValuableAssetList;
	
	private User currUser;
	private int currUserID;
	//private DBConnection dbHandler;
	private Connection conn;
	private JButton changeNameButton;
	
	/**
	 * Create the panel.
	 */
	public AccountSettingsScreen(){
		initialize();
	}
	
	public void initialize() {
		setBackground(new Color(128, 128, 128));

		setLayout(null);
		this.setBounds(0, 0, 772, 454);
		
		userSettingsPanel = new JPanel();
		userSettingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userSettingsPanel.setBounds(10, 11, 368, 140);
		userSettingsPanel.setLayout(null);
		add(userSettingsPanel);
		
		lblUserSettings = new JLabel("User Settings");
		lblUserSettings.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUserSettings.setBounds(5, 11, 172, 19);
		userSettingsPanel.add(lblUserSettings);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(5, 51, 72, 19);
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		userSettingsPanel.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setBounds(112, 51, 138, 20);
		usernameField.setColumns(10);
		userSettingsPanel.add(usernameField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(5, 81, 66, 19);
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		userSettingsPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 81, 138, 20);
		passwordField.setColumns(10);
		userSettingsPanel.add(passwordField);
		
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBackground(new Color(220, 220, 220));
		//changeDetailsButton.addMouseListener(new MouseAdapter();
		changeDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeDetailsButton.setBounds(254, 80, 105, 23);
		userSettingsPanel.add(changeDetailsButton);
		
		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		newPasswordLabel.setBounds(5, 108, 105, 19);
		userSettingsPanel.add(newPasswordLabel);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(112, 108, 138, 20);
		userSettingsPanel.add(newPasswordField);
		
		saveDetailsButton = new JButton("Save");
		saveDetailsButton.setBackground(new Color(220, 220, 220));
		//saveDetailsButton.addMouseListener(new MouseAdapter());
		saveDetailsButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		saveDetailsButton.setBounds(254, 107, 105, 23);
		userSettingsPanel.add(saveDetailsButton);
		
		
		
		namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		namePanel.setBounds(388, 11, 374, 140);
		namePanel.setLayout(null);
		add(namePanel);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 63, 14);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		namePanel.add(lblName);
		
		nameLabel = new JLabel("<namehere>");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 39, 366, 14);
		nameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		namePanel.add(nameLabel);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setBounds(20, 90, 141, 14);
		namePanel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 109, 141, 20);
		firstNameTextField.setColumns(10);
		namePanel.add(firstNameTextField);
		
		middleInitLabel = new JLabel("MI");
		middleInitLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		middleInitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		middleInitLabel.setBounds(168, 90, 48, 14);
		namePanel.add(middleInitLabel);
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setBounds(168, 109, 48, 20);
		middleInitialTextField.setColumns(10);
		namePanel.add(middleInitialTextField);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setBounds(222, 90, 141, 14);
		namePanel.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(222, 109, 141, 20);
		lastNameTextField.setColumns(10);
		namePanel.add(lastNameTextField);
		
		changeNameButton = new JButton("Update Name");
		changeNameButton.setBackground(new Color(220, 220, 220));
		//changeNameButton.addMouseListener(new MouseAdapter() );
		changeNameButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		changeNameButton.setBounds(258, 64, 105, 23);
		namePanel.add(changeNameButton);
		
		
		
		assetSummary = new JPanel();
		assetSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		assetSummary.setBounds(10, 162, 752, 281);
		assetSummary.setLayout(null);
		add(assetSummary);
		
		lblSummaryTable = new JLabel("Summary");
		lblSummaryTable.setBounds(10, 11, 269, 22);
		lblSummaryTable.setFont(new Font("Calibri", Font.PLAIN, 18));
		assetSummary.add(lblSummaryTable);
		
		JLabel lblNetWorth = new JLabel("Net worth");
		lblNetWorth.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNetWorth.setBounds(10, 44, 76, 14);
		assetSummary.add(lblNetWorth);
		
		lblNetWorthList = new JTextPane();
		lblNetWorthList.setBackground(UIManager.getColor("Button.background"));
		lblNetWorthList.setEditable(false);
		lblNetWorthList.setBounds(10, 59, 139, 22);
		assetSummary.add(lblNetWorthList);
		
		JLabel lblNewestAssets = new JLabel("Newest Assets");
		lblNewestAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewestAssets.setBounds(10, 113, 99, 14);
		assetSummary.add(lblNewestAssets);
		
		lblNewestAssetList = new JTextPane();
		lblNewestAssetList.setBackground(UIManager.getColor("Button.background"));
		lblNewestAssetList.setEditable(false);
		lblNewestAssetList.setBounds(10, 127, 172, 55);
		assetSummary.add(lblNewestAssetList);
		
		JLabel lblMostValuableAssets = new JLabel("Most Valuable Assets");
		lblMostValuableAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMostValuableAssets.setBounds(10, 184, 139, 14);
		assetSummary.add(lblMostValuableAssets);
		
		lblMostValuableAssetList = new JTextPane();
		lblMostValuableAssetList.setBackground(UIManager.getColor("Button.background"));
		lblMostValuableAssetList.setEditable(false);
		lblMostValuableAssetList.setBounds(10, 209, 172, 55);
		assetSummary.add(lblMostValuableAssetList);
	}
	
	public void refresh(){}
}