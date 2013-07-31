package phase2;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import javax.swing.BoxLayout;
import javax.swing.Box;
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


public class LoginScreen extends JPanel implements TableObserver {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton LoginButton;

	public LoginScreen() {
		initialize();
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
		//LoginButton.addActionListener(new ActionListener());
		LoginButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		LoginButton.setBounds(300, 270, 180, 40);
		add(LoginButton);	
	}
	
	public void refresh(){
		// CLEAR and WHITE OUT INPUTFIELDS
	}
}
