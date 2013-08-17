package phase2;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screenBehaviourStrategy.LoginScreenBehaviour;
import screenBehaviourStrategy.MainScreenBehaviour;
import screens.LoginScreen;
import screens.MainScreen;

public class MainFrame extends JFrame {
	
	public final String LOGIN_SCREEN = "loginScreen";
	public final String MAIN_SCREEN = "mainScreen";

	private JPanel contentPane;
	private LoginScreen loginScreen;
	private MainScreen mainScreen;
	
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
		
		loginScreen = new LoginScreenBehaviour(this).getView(); 
		contentPane.add(loginScreen, LOGIN_SCREEN);
		
		mainScreen = new MainScreenBehaviour(this).getView();
		contentPane.add(mainScreen, MAIN_SCREEN);
	}

	public void swapToLoginScreenCard(){
		loginScreen.refresh();
		
		CardLayout cl = (CardLayout) getContentPane().getLayout();
		cl.show((JPanel)getContentPane(), LOGIN_SCREEN);
	}
	public void swapToMainScreenCard(){
		mainScreen.refresh();
		
		CardLayout cl = (CardLayout) getContentPane().getLayout();
		cl.show((JPanel)getContentPane(), MAIN_SCREEN);
	}
}
