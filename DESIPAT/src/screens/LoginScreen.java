package screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import fields.TextInput;
import fields.PasswordInput;
import screenBehaviourStrategy.LoginScreenBehaviour;

public class LoginScreen extends Screen implements TableObserver {

	private LoginScreenBehaviour behavior;
	private TextInput usernameField;
	private PasswordInput passwordField;
	private JButton LoginButton;

	public LoginScreen(LoginScreenBehaviour behavior) {
		this.behavior = behavior;
		initialize();
	}
	
	public void initialize() {
		setBackground(new Color(188, 143, 143));
		setLayout(null);
		
		add(Box.createVerticalGlue());
		
		usernameField = new TextInput("Username");
		usernameField.setBounds(250, 180, 350, 25);
		add(usernameField);
		
		passwordField = new PasswordInput("Password");
		passwordField.setBounds(250, 220, 350, 25);
		add(passwordField);
		
		LoginButton = new JButton("Log in");
		LoginButton.setBackground(new Color(192, 192, 192));
		LoginButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		LoginButton.setBounds(300, 270, 180, 40);
		add(LoginButton);	
	}
	
	public void setLoginButtonListener(ActionListener listener){
		LoginButton.addActionListener(listener);
	}
	
	public String getUsernameInput(){
		return usernameField.getInput();
	}
	public String getPasswordInput(){
		return passwordField.getInput();
	}
	public void setUsernameFieldErrorMessage(String message){
		usernameField.setErrorMessage(message);
	}
	public void setPasswordFieldErrorMessage(String message){
		passwordField.setErrorMessage(message);
	}
	public void clearErrorMessages(){
		usernameField.clearErrorMessage();
		passwordField.clearErrorMessage();
	}
	
	public void refresh(){
		usernameField.clearField();
		passwordField.clearField();
		clearErrorMessages();
	}
}
