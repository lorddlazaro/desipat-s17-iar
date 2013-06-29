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

public class Suggestion extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suggestion frame = new Suggestion();
					frame.setLocationRelativeTo(null);
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
	public Suggestion() {
		setTitle("Asset Management Registry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(255, 127, 80));
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnLogOut.setBounds(685, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblHello.setBounds(10, 15, 46, 14);
		contentPane.add(lblHello);
		
		JLabel lblUsername = new JLabel("< Username >");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUsername.setBounds(51, 15, 191, 14);
		contentPane.add(lblUsername);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.setBackground(new Color(128, 128, 128));
		btnAccountSettings.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAccountSettings.setBounds(532, 11, 143, 23);
		contentPane.add(btnAccountSettings);
		
		JLabel lblLastLogin = new JLabel("Last Login: 12/12/1212 12:12 PM");
		lblLastLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastLogin.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblLastLogin.setBounds(324, 15, 198, 14);
		contentPane.add(lblLastLogin);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(188, 143, 143));
		panelMenu.setBounds(10, 43, 764, 50);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnViewAssets = new JButton("View Assets");
		btnViewAssets.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewAssets.setBackground(new Color(70, 130, 180));
		btnViewAssets.setBounds(299, 0, 155, 50);
		panelMenu.add(btnViewAssets);
		
		JButton btnManageAccounts = new JButton("Manage Accounts");
		btnManageAccounts.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnManageAccounts.setBackground(new Color(221, 160, 221));
		btnManageAccounts.setBounds(454, 0, 155, 50);
		panelMenu.add(btnManageAccounts);
		
		JButton btnNewButton_4 = new JButton("View Logs");
		btnNewButton_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_4.setBackground(new Color(238, 232, 170));
		btnNewButton_4.setBounds(609, 0, 155, 50);
		panelMenu.add(btnNewButton_4);
		
		JLabel lblViewLogs = new JLabel("Asset Management Registry");
		lblViewLogs.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblViewLogs.setBounds(12, 12, 256, 26);
		panelMenu.add(lblViewLogs);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 104, 764, 450);
		contentPane.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setName("AddAsset");
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.add(panel, "name_38670646713129");
		panel.setLayout(null);
		
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
		panel.add(list);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Include decomissioned assets");
		tglbtnNewToggleButton.setBounds(10, 42, 199, 23);
		panel.add(tglbtnNewToggleButton);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"sort by name"}));
		comboBox_2.setBounds(10, 11, 199, 20);
		panel.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Asset Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(221, 11, 528, 427);
		panel.add(panel_3);
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
		panel.add(button);
		
		AddAssetScreen addAssetScreen = new AddAssetScreen();
		panel_7.add(addAssetScreen, "name_38676255984210");
		
		JPanel panel_1 = new JPanel();
		panel_7.add(panel_1, "name_38679957106210");
		panel_1.setLayout(null);
		
		JTree tree_1 = new JTree();
		tree_1.setBounds(10, 11, 179, 409);
		panel_1.add(tree_1);
		
		JLabel lblNewLabel = new JLabel("Username: tomatopotatas");
		lblNewLabel.setBounds(199, 84, 139, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Clearance Level:");
		lblNewLabel_2.setBounds(199, 128, 102, 14);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(287, 125, 130, 20);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton_5 = new JButton("Save Changes");
		btnNewButton_5.setBounds(199, 201, 150, 30);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Name: Tomato E. Potato");
		lblNewLabel_3.setBounds(199, 42, 218, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_6 = new JButton("Delete User");
		btnNewButton_6.setBounds(199, 252, 150, 30);
		panel_1.add(btnNewButton_6);
		
		JButton btnSuspendUser = new JButton("Suspend User");
		btnSuspendUser.setBounds(199, 301, 150, 30);
		panel_1.add(btnSuspendUser);
		
		JPanel panel_2 = new JPanel();
		panel_7.add(panel_2, "name_38684112168376");
		panel_2.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 41, 167, 379);
		panel_2.add(tree);
		
		table = new JTable();
		table.setBounds(187, 11, 562, 409);
		panel_2.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 167, 20);
		panel_2.add(comboBox);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, "name_38593788649255");
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, "name_38615183479534");
	}
}
