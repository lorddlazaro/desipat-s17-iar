import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.Connection;


public class UserScreen extends JPanel {
	private JTextField usernameField;
	private JLabel lblName;
	private JLabel label;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleInitialTextField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JTextField newPasswordField;
	private JButton changeDetailsButton;
	private JButton saveDetailsButton;
	private JLabel newPasswordLabel;
	
	private User currUser;
	private DBConnection dbHandler;
	private Connection conn;
	private JButton backButton;
	
	/**
	 * Create the panel.
	 */
	public UserScreen() {

		setLayout(null);
		
		JPanel userSettingsPanel = new JPanel();
		userSettingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userSettingsPanel.setBounds(10, 11, 368, 140);
		add(userSettingsPanel);
		userSettingsPanel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
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
		
		JLabel lblUserSettinhd = new JLabel("User Settings");
		lblUserSettinhd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserSettinhd.setBounds(5, 11, 172, 19);
		userSettingsPanel.add(lblUserSettinhd);
		
		changeDetailsButton = new JButton("Change Details");
		changeDetailsButton.setBounds(253, 81, 105, 23);
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
		saveDetailsButton.setBounds(253, 108, 105, 23);
		userSettingsPanel.add(saveDetailsButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(388, 11, 386, 140);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 63, 14);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label = new JLabel("<namehere>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 39, 366, 14);
		panel_1.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 109, 141, 20);
		panel_1.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setBounds(168, 109, 48, 20);
		panel_1.add(middleInitialTextField);
		middleInitialTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(222, 109, 141, 20);
		panel_1.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 90, 141, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(222, 90, 141, 14);
		panel_1.add(lblLastName);
		
		JLabel lblMi = new JLabel("MI");
		lblMi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMi.setBounds(168, 90, 48, 14);
		panel_1.add(lblMi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 162, 764, 354);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSummaryTable = new JLabel("Summary or whatever");
		lblSummaryTable.setBounds(10, 11, 269, 22);
		lblSummaryTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblSummaryTable);
		
		backButton = new JButton("Back to Main");
		backButton.setBounds(671, 527, 103, 23);
		add(backButton);

	}
	public UserScreen(User currUser) {
		this();
		this.currUser = currUser;
	}
	
	public void InitSettings() {
		usernameField.setText(currUser.getUsername());
		passwordField.setText(currUser.getPassword());
		
		newPasswordField.setVisible(false);
		newPasswordLabel.setVisible(false);
		saveDetailsButton.setVisible(false);
	}
	
}