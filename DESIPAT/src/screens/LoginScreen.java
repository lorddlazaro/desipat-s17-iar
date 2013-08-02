package screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import screenBehaviourStrategy.LoginScreenBehaviour;
import screenBehaviourStrategy.LoginScreenBehaviourStrategy;


public class LoginScreen extends Screen implements TableObserver {
	
	LoginScreenBehaviour behavior;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton LoginButton;

	public LoginScreen(LoginScreenBehaviour behavior) {
		this.behavior = behavior;
		initialize();
	}
	public String getUsernameInput(){
		return usernameField.getText();
	}
	
	public String getPasswordInput(){
		return String.valueOf(passwordField.getPassword());
	}
	public void initialize() { 
		setBackground(new Color(188, 143, 143));
		setLayout(null);
		
		// REPLACE WITH INPUTFIELD
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		usernameLabel.setBounds(250, 180, 90, 14);
		add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(350, 180, 180, 25);
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
		add(Box.createVerticalGlue());
		add(usernameField);
		usernameField.setColumns(10);
		
		// REPLACE WITH INPUTFIELD
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordLabel.setBounds(250, 220, 80, 14);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 17));
		passwordField.setBounds(350, 220, 180, 25);
		add(passwordField);
		
		
		LoginButton = new JButton("Log in");
		LoginButton.setBackground(new Color(192, 192, 192));
		LoginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				behavior.login();	
			}
		});		
		LoginButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		LoginButton.setBounds(300, 270, 180, 40);
		add(LoginButton);	
	}
	
	public void refresh(){
		passwordField.setText("");
		usernameField.setText("");
	}
}
