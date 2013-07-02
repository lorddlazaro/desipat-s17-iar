import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginScreen extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private ArrayList<User> userList;
	private JLabel errorLabel;
	private JButton LoginButton;

	public LoginScreen() {
		setBackground(new Color(188, 143, 143));
		initGUI();
	}
	
	private void initGUI() { 
		setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(178, 23, 180, 25);
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 17));
		passwordField.setBounds(178, 60, 180, 25);
		add(passwordField);
		
		LoginButton = new JButton("Log in");
		LoginButton.setBackground(new Color(192, 192, 192));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean hasUsername = !usernameField.getText().isEmpty();
				boolean hasPassword = !String.copyValueOf(passwordField.getPassword()).isEmpty();
				
				if(hasUsername)
					if(hasPassword){
						// Case 1: both fields are filled
						// Checks userList if username and password supplied is valid
						usernameField.setBackground(Color.WHITE);
						passwordField.setBackground(Color.WHITE);
						
						boolean foundMatch = false;
						
						refreshUserList();
						for(User user: userList)
							if(user.getUsername().equals(usernameField.getText()) && user.getPassword().equals(String.copyValueOf(passwordField.getPassword())))
							// Match found, showing AssetScreen
							{
								foundMatch = true;
								logIn(user.getUsername(), user.getUserID());
								break;
							}
												
						// Notify User of wrong Username/Password
						if(foundMatch){
							usernameField.setText("");
							passwordField.setText("");		
							errorLabel.setText("");	
						}
							
						else
							errorLabel.setText("Invalid username or password.");	
					}
					else{
						// Case 2: empty password field
						usernameField.setBackground(Color.WHITE);
						passwordField.setBackground(Color.PINK);
						errorLabel.setText("Please enter password.");
					}
				else
					if(hasPassword){
						// Case 3: empty username field
						passwordField.setBackground(Color.WHITE);
						usernameField.setBackground(Color.PINK);
						errorLabel.setText("Please enter username.");
					}
					else{
						// Case 4: both fields are empty
						usernameField.setBackground(Color.PINK);
						passwordField.setBackground(Color.PINK);
						errorLabel.setText("Please enter username and password.");
					}
			}
		});
		LoginButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		LoginButton.setBounds(116, 123, 170, 35);
		add(LoginButton);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		usernameLabel.setBounds(37, 28, 90, 14);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordLabel.setBounds(37, 65, 80, 14);
		add(passwordLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		errorLabel.setBounds(12, 97, 380, 14);
		add(errorLabel);
	}
	
	private void refreshUserList(){
		userList = new ArrayList<User>();
		
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select * from UserAccount where isactive = 1;");
		try{
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
					rs.next();
				}
			}
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void logIn(String username, int userID){
		ActionLogger.loggedIn(userID);
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		mainScreen.changeCard((JPanel)mainScreen.getContentPane(), "panelMain");
		mainScreen.changeWindowSize(800, 600);
		mainScreen.lblUsername.setText(username);
		mainScreen.currentUserID = userID;
		int clearance=0;
		
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "SELECT actionDate, actionTime FROM actionlog WHERE userid = '"+userID+"' order by actionDate, actionTime DESC;");
		try{
			if(rs.isBeforeFirst()){
				rs.first();
				mainScreen.lblLastLogin.setText("Last Login: "+rs.getString(1)+" "+rs.getString(2));
			}
			else
				mainScreen.lblLastLogin.setText("");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		rs = DBcon.executeQuery(con, "SELECT clearanceid FROM useraccount where userid = '"+userID+"';");
		try{
			if(rs.isBeforeFirst()){
				rs.first();
				clearance = rs.getInt(1);
			}
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(clearance == 1)
			mainScreen.btnViewAssets.setEnabled(false);
		else if(clearance == 2 || clearance == 3)
			mainScreen.btnManageAccounts.setEnabled(false);
		else if(clearance == 4){
			mainScreen.btnViewAssets.setEnabled(false);
			mainScreen.btnManageAccounts.setEnabled(false);
		}

		mainScreen.panelCards.remove(mainScreen.panelAccountSettings);
		mainScreen.panelAccountSettings = new UserScreen(userID);
		mainScreen.panelCards.add(mainScreen.panelAccountSettings, "panelAccountSettings");
	}
}
