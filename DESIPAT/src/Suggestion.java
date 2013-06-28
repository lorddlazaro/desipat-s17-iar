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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 95, 764, 459);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View Asset", null, panel, null);
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
		list.setBounds(10, 76, 199, 344);
		panel.add(list);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Include decomissioned assets");
		tglbtnNewToggleButton.setBounds(10, 42, 199, 23);
		panel.add(tglbtnNewToggleButton);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"sort by name"}));
		comboBox_2.setBounds(10, 11, 199, 20);
		panel.add(comboBox_2);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(219, 211, 530, 209);
		panel.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("OwnerHistory", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("CustodianHistory", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("LocationHistory", null, panel_6, null);
		
		JLabel lblNewLabel_1 = new JLabel("Asset Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(219, 11, 530, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Owner");
		lblNewLabel_4.setBounds(236, 61, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblCustodian = new JLabel("Custodian");
		lblCustodian.setBounds(236, 98, 81, 14);
		panel.add(lblCustodian);
		
		JLabel lblDateAcquired = new JLabel("Date Originally Acquired");
		lblDateAcquired.setBounds(236, 136, 119, 14);
		panel.add(lblDateAcquired);
		
		JLabel lblDateDecomissioned = new JLabel("Date Decomissioned");
		lblDateDecomissioned.setBounds(236, 172, 119, 14);
		panel.add(lblDateDecomissioned);
		
		JLabel lblConfidentialValue = new JLabel("Confidential Value");
		lblConfidentialValue.setBounds(419, 98, 130, 14);
		panel.add(lblConfidentialValue);
		
		JLabel lblIntegrity = new JLabel("Integrity Value");
		lblIntegrity.setBounds(419, 136, 130, 14);
		panel.add(lblIntegrity);
		
		JLabel lblAvailabilityValue = new JLabel("Availability Value");
		lblAvailabilityValue.setBounds(419, 172, 130, 14);
		panel.add(lblAvailabilityValue);
		
		JButton btnNewButton_7 = new JButton("Update Asset");
		btnNewButton_7.setBounds(550, 194, 199, 30);
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel_5 = new JLabel("Financial Value");
		lblNewLabel_5.setBounds(419, 61, 130, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblMaintenance = new JLabel("Maintenance");
		lblMaintenance.setBounds(585, 136, 130, 14);
		panel.add(lblMaintenance);
		
		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setBounds(585, 98, 130, 14);
		panel.add(lblClassification);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(585, 61, 130, 14);
		panel.add(lblType);
		
		AddAssetScreen addAssetScreen = new AddAssetScreen();
		tabbedPane.addTab("New tab", null, addAssetScreen, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Manage Accounts", null, panel_1, null);
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
		tabbedPane.addTab("Action Log", null, panel_2, null);
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
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(685, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setBounds(10, 15, 46, 14);
		contentPane.add(lblHello);
		
		JLabel lblUserPerson = new JLabel("User Person");
		lblUserPerson.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserPerson.setBounds(45, 14, 94, 14);
		contentPane.add(lblUserPerson);
		
		JButton btnNewButton = new JButton("Account Settings");
		btnNewButton.setBounds(554, 11, 121, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 43, 764, 50);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("View Assets");
		btnNewButton_1.setBounds(20, 11, 125, 28);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Accounts");
		btnNewButton_2.setBounds(420, 11, 125, 28);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Asset");
		btnNewButton_3.setBounds(220, 11, 125, 28);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Action Log");
		btnNewButton_4.setBounds(620, 11, 125, 28);
		panel_3.add(btnNewButton_4);
		
		JLabel lblLastLogin = new JLabel("Last Login: 12/12/1212 12:12 PM");
		lblLastLogin.setBounds(376, 15, 168, 14);
		contentPane.add(lblLastLogin);
	}
}
