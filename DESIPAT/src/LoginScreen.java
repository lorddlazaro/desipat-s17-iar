import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginScreen extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private ArrayList<User> userList;
	private JLabel errorLabel;
	private JButton LoginButton;

	public LoginScreen() {
		initGUI();
	}
	
	private void initGUI() { 
		setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(176, 29, 180, 25);
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 17));
		passwordField.setBounds(176, 65, 180, 25);
		add(passwordField);
		
		LoginButton = new JButton("New button");
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean hasUsername = !usernameField.getText().isEmpty();
				boolean hasPassword = !String.copyValueOf(passwordField.getPassword()).isEmpty();
				
				if(hasUsername)
					if(hasPassword){
						// Case 1: both fields are filled
						// Checks userList if username and password supplied is valid
						usernameField.setBackground(Color.WHITE);
						passwordField.setBackground(Color.WHITE);
						
						for(User user: userList)
							if(user.getUsername().equals(usernameField.getText()) && user.getPassword().equals(String.copyValueOf(passwordField.getPassword())))
							// Match found, showing AssetScreen
							{
								System.out.println("Logged in");
								//DBConnection DBcon = new DBConnection();
								//Connection con = DBcon.open();
								//DBcon.executeUpdate(con, "insert into actionlog values('',);");
								//DBcon.close();
							}
												
						// Notify User of wrong Username/Password
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
		LoginButton.setBounds(112, 129, 170, 35);
		add(LoginButton);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		usernameLabel.setBounds(35, 34, 90, 14);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordLabel.setBounds(35, 70, 80, 14);
		add(passwordLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		errorLabel.setBounds(35, 104, 321, 14);
		add(errorLabel);
	}
	
	private void initUserList(){
		userList = new ArrayList<User>();
		
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select * from UserAccount;");
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
}
