import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	JLabel lblUsername;
	JPanel panelCards;
	int currentUserID;
	JLabel lblLastLogin;
	UserScreen panelAccountSettings;
	EditAssetScreen panelEditAsset;
	assetScreen panelViewAsset;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.changeWindowSize(400, 200);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setResizable(false);
		setTitle("Asset Management Registry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		
		LoginScreen panelLogin = new LoginScreen();
		contentPane.add(panelLogin, "panelLogin");
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(192, 192, 192));
		contentPane.add(panelMain, "panelMain");
		panelMain.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(null);
		panelMenu.setBounds(10, 47, 772, 50);
		panelMain.add(panelMenu);
		panelMenu.setBackground(new Color(188, 143, 143));
		panelMenu.setLayout(null);
		
		JButton btnViewAssets = new JButton("View Assets");
		btnViewAssets.setForeground(new Color(25, 25, 112));
		btnViewAssets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCard(panelCards, "panelViewAssets");
			}
		});
		btnViewAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewAssets.setBackground(new Color(70, 130, 180));
		btnViewAssets.setBounds(352, 0, 140, 50);
		panelMenu.add(btnViewAssets);
		
		JButton btnManageAccounts = new JButton("Manage Accounts");
		btnManageAccounts.setForeground(new Color(128, 0, 128));
		btnManageAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCard(panelCards, "panelManageAccounts");
			}
		});
		btnManageAccounts.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnManageAccounts.setBackground(new Color(221, 160, 221));
		btnManageAccounts.setBounds(492, 0, 140, 50);
		panelMenu.add(btnManageAccounts);
		
		JButton btnNewButton_4 = new JButton("View Logs");
		btnNewButton_4.setForeground(new Color(160, 82, 45));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeCard(panelCards, "panelViewLogs");
			}
		});
		btnNewButton_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_4.setBackground(new Color(238, 232, 170));
		btnNewButton_4.setBounds(632, 0, 140, 50);
		panelMenu.add(btnNewButton_4);
		
		JLabel lblViewLogs = new JLabel("Asset Management Registry");
		lblViewLogs.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewLogs.setForeground(new Color(102, 0, 0));
		lblViewLogs.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblViewLogs.setBounds(12, -6, 339, 50);
		panelMenu.add(lblViewLogs);
		
		panelCards = new JPanel();
		panelCards.setBorder(UIManager.getBorder("ProgressBar.border"));
		panelCards.setBounds(10, 109, 772, 454);
		panelMain.add(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		
		panelViewAsset = new assetScreen();
		panelCards.add(panelViewAsset, "panelViewAssets");
		
		AddAssetScreen panelAddAsset = new AddAssetScreen();
		panelCards.add(panelAddAsset, "panelAddAsset");
		
		panelEditAsset = new EditAssetScreen();
		panelCards.add(panelEditAsset, "panelEditAsset");
		
		AdminUserScreen panelManageAccounts = new AdminUserScreen();
		panelCards.add(panelManageAccounts, "panelManageAccounts");
		
		LogScreen panelViewLogs = new LogScreen();
		panelCards.add(panelViewLogs, "panelViewLogs");
		
		panelAccountSettings = new UserScreen();
		panelCards.add(panelAccountSettings, "panelAccountSettings");
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCard(panelCards, "panelAccountSettings");
			}
		});
		btnAccountSettings.setBounds(538, 12, 143, 23);
		panelMain.add(btnAccountSettings);
		btnAccountSettings.setBackground(new Color(128, 128, 128));
		btnAccountSettings.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(139, 0, 0));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		btnLogOut.setBounds(693, 12, 89, 23);
		panelMain.add(btnLogOut);
		btnLogOut.setBackground(new Color(255, 127, 80));
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setBounds(12, 16, 46, 14);
		panelMain.add(lblHello);
		lblHello.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		lblUsername = new JLabel("user");
		lblUsername.setBounds(54, 16, 191, 14);
		panelMain.add(lblUsername);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 18));
		
		lblLastLogin = new JLabel("Last Login: 04/13/2009 10:25 AM");
		lblLastLogin.setBounds(330, 16, 198, 14);
		panelMain.add(lblLastLogin);
		lblLastLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastLogin.setFont(new Font("Calibri", Font.PLAIN, 14));
	}
	
	public void changeCard(JPanel cards, String cardName){
		CardLayout cl = (CardLayout)cards.getLayout();
		cl.show(cards, cardName);
	}
	
	private void logOut(){
		ActionLogger.loggedOut(currentUserID);
		this.changeCard((JPanel)this.getContentPane(), "panelLogin");
		this.changeWindowSize(400, 200);
	}
	
	public void changeWindowSize(int length, int height){
		this.setBounds(0, 0, length, height);
		this.setLocationRelativeTo(null);
	}
}
