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

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JLabel lblUsername;
	JPanel panelCards;
	int currentUserID;
	JLabel lblLastLogin;
	UserScreen panelAccountSettings;
	
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
		btnViewAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewAssets.setBackground(new Color(70, 130, 180));
		btnViewAssets.setBounds(352, 0, 140, 50);
		panelMenu.add(btnViewAssets);
		
		JButton btnManageAccounts = new JButton("Manage Accounts");
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
		panelCards.setBorder(null);
		panelCards.setBounds(10, 109, 772, 454);
		panelMain.add(panelCards);
		panelCards.setLayout(new CardLayout(0, 0));
		
		AddAssetScreen panelAddAsset = new AddAssetScreen();
		panelCards.add(panelAddAsset, "panelAddAsset");
		
		JPanel viewAssetScreen_PLACEHOLDER = new JPanel();
		panelCards.add(viewAssetScreen_PLACEHOLDER, "panelViewAssets");
		viewAssetScreen_PLACEHOLDER.setName("AddAsset");
		viewAssetScreen_PLACEHOLDER.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		viewAssetScreen_PLACEHOLDER.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"tomatocruncher", "tomatoblender"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 77, 199, 319);
		viewAssetScreen_PLACEHOLDER.add(list);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Include decomissioned assets");
		tglbtnNewToggleButton.setBounds(10, 42, 199, 23);
		viewAssetScreen_PLACEHOLDER.add(tglbtnNewToggleButton);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"sort by name"}));
		comboBox_2.setBounds(10, 11, 199, 20);
		viewAssetScreen_PLACEHOLDER.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Asset Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(222, 13, 528, 427);
		viewAssetScreen_PLACEHOLDER.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Availability Value");
		label.setBounds(195, 232, 130, 14);
		panel_3.add(label);
		
		JLabel label_2 = new JLabel("Date Originally Acquired");
		label_2.setBounds(12, 196, 136, 14);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Integrity Value");
		label_3.setBounds(195, 196, 130, 14);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("Maintenance");
		label_4.setBounds(361, 196, 130, 14);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Classification");
		label_5.setBounds(361, 158, 130, 14);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Confidential Value");
		label_6.setBounds(195, 158, 130, 14);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Custodian");
		label_7.setBounds(12, 158, 81, 14);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("Owner");
		label_8.setBounds(12, 121, 46, 14);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("Financial Value");
		label_9.setBounds(195, 121, 130, 14);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Type");
		label_10.setBounds(361, 121, 130, 14);
		panel_3.add(label_10);
		
		JButton btnNewButton_7 = new JButton("Update Asset");
		btnNewButton_7.setBounds(317, 385, 199, 30);
		panel_3.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("Asset Name");
		lblNewLabel_1.setBounds(0, 37, 530, 36);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Identifier");
		lblNewLabel_4.setBounds(232, 74, 55, 16);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblStatus = new JLabel("status");
		lblStatus.setBounds(12, 231, 55, 16);
		panel_3.add(lblStatus);
		
		JLabel lblStorage = new JLabel("Storage");
		lblStorage.setBounds(361, 231, 55, 16);
		panel_3.add(lblStorage);
		
		JButton button = new JButton("Add Asset");
		button.setBounds(10, 408, 199, 30);
		viewAssetScreen_PLACEHOLDER.add(button);
		
		EditAssetScreen panelEditAsset = new EditAssetScreen((Asset) null, (ArrayList) null, (ArrayList) null);
		panelCards.add(panelEditAsset, "panelEditAsset");
		
		AdminUserScreen panelManageAccounts = new AdminUserScreen();
		panelCards.add(panelManageAccounts, "panelManageAccounts");
		
		JPanel logScreen_PLACEHOLDER = new JPanel();
		panelCards.add(logScreen_PLACEHOLDER, "panelViewLogs");
		logScreen_PLACEHOLDER.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 41, 167, 379);
		logScreen_PLACEHOLDER.add(tree);
		
		table = new JTable();
		table.setBounds(187, 11, 562, 409);
		logScreen_PLACEHOLDER.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 167, 20);
		logScreen_PLACEHOLDER.add(comboBox);
		
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
		lblHello.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		lblUsername = new JLabel("< Username >");
		lblUsername.setBounds(49, 16, 191, 14);
		panelMain.add(lblUsername);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 16));
		
		lblLastLogin = new JLabel("Last Login: 12/12/1212 12:12 PM");
		lblLastLogin.setBounds(330, 16, 198, 14);
		panelMain.add(lblLastLogin);
		lblLastLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastLogin.setFont(new Font("Calibri", Font.PLAIN, 13));
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
