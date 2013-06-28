import javax.swing.JPanel;


public class UserScreen extends JPanel {
	private JTextField usernameField;
	private JLabel lblName;
	private JLabel nameLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleInitialTextField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JTextField newPasswordField;
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

	private User currUser;
	private DBConnection dbHandler;
	private Connection conn;
	private JButton backButton;
	private JButton changeNameButton;
	
	/**
	 * Create the panel.
	 */
	public UserScreen() {

		setLayout(null);
		
		userSettingsPanel = new JPanel();
		userSettingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userSettingsPanel.setBounds(10, 11, 368, 140);
		add(userSettingsPanel);
		userSettingsPanel.setLayout(null);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(5, 51, 72, 19);
		userSettingsPanel.add(usernameLabel);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(5, 81, 66, 19);
		userSettingsPanel.add(passwordLabel);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		usernameField = new JTextField();
		usernameField.setBounds(112, 51, 138, 20);
		userSettingsPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(112, 81, 138, 20);
		userSettingsPanel.add(passwordField);
		passwordField.setColumns(10);
		
		lblUserSettings = new JLabel("User Settings");
		lblUserSettings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserSettings.setBounds(5, 11, 172, 19);
		userSettingsPanel.add(lblUserSettings);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBounds(254, 80, 105, 23);
		userSettingsPanel.add(changeDetailsButton);
		
		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newPasswordLabel.setBounds(5, 108, 105, 19);
		userSettingsPanel.add(newPasswordLabel);
		
		newPasswordField = new JTextField();
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(112, 108, 138, 20);
		userSettingsPanel.add(newPasswordField);
		
		saveDetailsButton = new JButton("Save");
		saveDetailsButton.setBounds(254, 107, 105, 23);
		userSettingsPanel.add(saveDetailsButton);
		
		namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		namePanel.setBounds(388, 11, 386, 140);
		add(namePanel);
		namePanel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 63, 14);
		namePanel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		nameLabel = new JLabel("<namehere>");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 39, 366, 14);
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 109, 141, 20);
		namePanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setBounds(168, 109, 48, 20);
		namePanel.add(middleInitialTextField);
		middleInitialTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(222, 109, 141, 20);
		namePanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setBounds(20, 90, 141, 14);
		namePanel.add(firstNameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setBounds(222, 90, 141, 14);
		namePanel.add(lastNameLabel);
		
		middleInitLabel = new JLabel("MI");
		middleInitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		middleInitLabel.setBounds(168, 90, 48, 14);
		namePanel.add(middleInitLabel);
		
		changeNameButton = new JButton("Change Name");
		changeNameButton.setBounds(271, 64, 105, 23);
		namePanel.add(changeNameButton);
		
		assetSummary = new JPanel();
		assetSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		assetSummary.setBounds(10, 162, 764, 354);
		add(assetSummary);
		assetSummary.setLayout(null);
		
		lblSummaryTable = new JLabel("Summary or whatever");
		lblSummaryTable.setBounds(10, 11, 269, 22);
		lblSummaryTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		assetSummary.add(lblSummaryTable);
		
		backButton = new JButton("Back to Main");
		backButton.setBounds(671, 527, 103, 23);
		add(backButton);

	}
	
	public UserScreen(User currUser) {
		this();
		this.currUser = currUser;
		conn = dbHandler.open();
	}
	
	public void InitSettings() {
		usernameField.setText(currUser.getUsername());
		passwordField.setText(currUser.getPassword());
		
		newPasswordField.setVisible(false);
		newPasswordLabel.setVisible(false);
		saveDetailsButton.setVisible(false);
		
		nameLabel.setText(currUser.getPerson().getFirstName() + " " + currUser.getPerson().getMiddleInit() + ". " + currUser.getPerson().getLastName());
		firstNameTextField.setText(currUser.getPerson().getFirstName());
		middleInitialTextField.setText(currUser.getPerson().getMiddleInit() + "");
		lastNameTextField.setText(currUser.getPerson().getLastName());
		
		firstNameLabel.setVisible(false);
		middleInitLabel.setVisible(false);
		lastNameLabel.setVisible(false);

		firstNameTextField.setVisible(false);
		middleInitialTextField.setVisible(false);
		lastNameTextField.setVisible(false);
	}
}