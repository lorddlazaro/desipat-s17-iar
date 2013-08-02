package phase2;


import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import screenBehaviourStrategy.LoginScreenBehaviour;
import screenBehaviourStrategy.MainScreenBehaviour;
import screens.LoginScreen;
import screens.MainScreen;


public class MainFrame extends JFrame {
	
	private final String LOGIN_SCREEN = "loginScreen";
	private final String MAIN_SCREEN = "mainScreen";

	private JPanel contentPane;
	private JPanel loginScreen;
	private JPanel mainScreen;
	
	
	public MainFrame() {
		setResizable(false);
		setTitle("Asset Management Registry");
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(new CardLayout());
		
		setContentPane(contentPane);
		
		//Todo:
		// pass through loginScreenbehaviour's constructor its respective new model()
		loginScreen = new LoginScreenBehaviour(this).getView(); 
		contentPane.add(loginScreen, LOGIN_SCREEN);
		
		
		//Todo:
		// pass through mainScreen's constructor its respective new model()
		mainScreen = new MainScreenBehaviour(this).getView();
		contentPane.add(mainScreen, MAIN_SCREEN);
	}

	public void swapToLoginScreenCard(){
		CardLayout cl = (CardLayout) getContentPane().getLayout();
		cl.show((JPanel)getContentPane(), LOGIN_SCREEN);
	}
	public void swapToMainScreenCard(){
		CardLayout cl = (CardLayout) getContentPane().getLayout();
		cl.show((JPanel)getContentPane(), MAIN_SCREEN);
	}
}
