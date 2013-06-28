import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;


public class AdminUserScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminUserScreen() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 67, 188, 450);
		add(panel);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 168, 428);
		panel.add(tree);
		
		JLabel lblAdminSettings = new JLabel("Admin Settings");
		lblAdminSettings.setBounds(10, 22, 258, 34);
		add(lblAdminSettings);
		lblAdminSettings.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(208, 67, 494, 450);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserDetails = new JLabel("User Details");
		lblUserDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserDetails.setBounds(10, 11, 172, 19);
		panel_1.add(lblUserDetails);

	}
}
