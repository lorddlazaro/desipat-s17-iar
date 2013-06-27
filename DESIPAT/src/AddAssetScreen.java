import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;


public class AddAssetScreen extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddAssetScreen() {
		setLayout(null);
		
		JLabel lblAddNewAsset = new JLabel("Add New Asset");
		lblAddNewAsset.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblAddNewAsset.setBounds(26, 24, 168, 29);
		add(lblAddNewAsset);
		
		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblOwner.setBounds(26, 329, 46, 14);
		add(lblOwner);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblName.setBounds(26, 89, 46, 14);
		add(lblName);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblType.setBounds(26, 114, 46, 14);
		add(lblType);
		
		JLabel lblMaintenanceSchedule = new JLabel("Maintenance Schedule:");
		lblMaintenanceSchedule.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaintenanceSchedule.setBounds(26, 404, 115, 14);
		add(lblMaintenanceSchedule);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(26, 179, 46, 14);
		add(lblValue);
		
		JLabel lblConfidentiality = new JLabel("Confidentiality:");
		lblConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblConfidentiality.setBounds(26, 229, 88, 14);
		add(lblConfidentiality);
		
		JLabel lblIntegrity = new JLabel("Integrity:");
		lblIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIntegrity.setBounds(26, 254, 88, 14);
		add(lblIntegrity);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAvailability.setBounds(26, 279, 88, 14);
		add(lblAvailability);
		
		JLabel lblFinancial = new JLabel("Financial:");
		lblFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFinancial.setBounds(26, 204, 88, 14);
		add(lblFinancial);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBasicInformation.setBounds(26, 64, 124, 14);
		add(lblBasicInformation);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblStatus.setBounds(26, 304, 88, 14);
		add(lblStatus);
		
		JLabel lblCustodian = new JLabel("Custodian:");
		lblCustodian.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCustodian.setBounds(26, 354, 88, 14);
		add(lblCustodian);
		
		JLabel lblStorageLocation = new JLabel("Storage Location:");
		lblStorageLocation.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblStorageLocation.setBounds(26, 379, 88, 14);
		add(lblStorageLocation);
		
		JLabel lblClassification = new JLabel("Classification:");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblClassification.setBounds(26, 429, 88, 14);
		add(lblClassification);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox.setBounds(70, 114, 124, 20);
		add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField.setBounds(70, 86, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Calibri", Font.PLAIN, 12));
		slider.setBounds(107, 220, 100, 23);
		add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		slider_1.setBounds(107, 245, 100, 23);
		add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		slider_2.setBounds(107, 270, 100, 23);
		add(slider_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_1.setBounds(79, 198, 115, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_2.setBounds(82, 323, 112, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(82, 351, 112, 20);
		add(textField_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_1.setBounds(124, 373, 69, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_2.setBounds(107, 426, 87, 20);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_3.setBounds(138, 401, 52, 20);
		add(comboBox_3);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired:");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDateAcquired.setBounds(26, 154, 88, 14);
		add(lblDateAcquired);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_4.setBounds(104, 145, 46, 20);
		add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_5.setBounds(161, 145, 46, 20);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox_6.setBounds(219, 145, 46, 20);
		add(comboBox_6);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMonth.setBounds(107, 164, 46, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDay.setBounds(161, 164, 32, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblYear.setBounds(219, 164, 46, 14);
		add(lblYear);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnAdd.setBounds(25, 454, 89, 23);
		add(btnAdd);

	}
}
