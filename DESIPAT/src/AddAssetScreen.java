import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;


public class AddAssetScreen extends JPanel {
	private JTextField txtName;
	private JTextField txtFinancial;
	private JTextField txtOwner;
	private JTextField txtCustodian;
	private JSlider sldConfidentiality;
	private JSlider sldIntegrity;
	private JSlider sldAvailability;
	private JComboBox cbxMonth;
	private JComboBox cbxDay;
	private JComboBox cbxYear;
	private JComboBox cbxType;
	private JComboBox cbxStorage;
	private JComboBox cbxClassification;
	private JComboBox cbxMaintenance;
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
		
		cbxType = new JComboBox();
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxType.setBounds(70, 114, 124, 20);
		add(cbxType);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtName.setBounds(70, 86, 124, 20);
		add(txtName);
		txtName.setColumns(10);
		
		sldConfidentiality = new JSlider();
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setValue(0);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(107, 220, 100, 23);
		add(sldConfidentiality);
		
		sldIntegrity = new JSlider();
		sldIntegrity.setValue(0);
		sldIntegrity.setMaximum(5);
		sldIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldIntegrity.setBounds(107, 245, 100, 23);
		add(sldIntegrity);
		
		sldAvailability = new JSlider();
		sldAvailability.setValue(0);
		sldAvailability.setMaximum(5);
		sldAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldAvailability.setBounds(107, 270, 100, 23);
		add(sldAvailability);
		
		txtFinancial = new JTextField();
		txtFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFinancial.setBounds(92, 198, 115, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);
		
		txtOwner = new JTextField();
		txtOwner.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtOwner.setBounds(82, 323, 112, 20);
		add(txtOwner);
		txtOwner.setColumns(10);
		
		txtCustodian = new JTextField();
		txtCustodian.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtCustodian.setColumns(10);
		txtCustodian.setBounds(82, 351, 112, 20);
		add(txtCustodian);
		
		cbxStorage = new JComboBox();
		cbxStorage.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxStorage.setBounds(124, 373, 69, 20);
		add(cbxStorage);
		
		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential", ""}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxClassification.setBounds(107, 426, 87, 20);
		add(cbxClassification);
		
		cbxMaintenance = new JComboBox();
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMaintenance.setBounds(138, 401, 52, 20);
		add(cbxMaintenance);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired:");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDateAcquired.setBounds(26, 154, 88, 14);
		add(lblDateAcquired);
		
		cbxMonth = new JComboBox();
		cbxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		cbxMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMonth.setBounds(104, 145, 69, 20);
		add(cbxMonth);
		
		cbxDay = new JComboBox();
		//int[] days=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
		//ArrayList<int>days=new ArrayList<int>();
		cbxDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxDay.setBounds(176, 145, 46, 20);
		add(cbxDay);
		
		cbxYear = new JComboBox();
		cbxYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxYear.setBounds(232, 145, 46, 20);
		add(cbxYear);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMonth.setBounds(107, 164, 46, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDay.setBounds(175, 164, 32, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblYear.setBounds(232, 164, 46, 14);
		add(lblYear);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAsset();
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnAdd.setBounds(25, 454, 89, 23);
		add(btnAdd);

		
	}
	public Asset addAsset()
	{
		Asset newAsset = new Asset();
		OwnershipHistory newOwner =new OwnershipHistory();
		StorageHistory newStorage= new StorageHistory();
		CustodyHistory newCustodian= new CustodyHistory();
		
		newAsset.setName(txtName.getText());
		
		//newAsset.setType(lookUpType(cbxType.getSelectedItem().toString()));
		newAsset.setDateAcquired(getDate(lookUpMonth(cbxMonth.getSelectedItem().toString()),Integer.parseInt(cbxDay.getSelectedItem().toString()),Integer.parseInt(cbxYear.getSelectedItem().toString())));
		newAsset.setValueFinancial(Float.parseFloat(txtFinancial.getText()));
		newAsset.setValueConfidentiality(sldConfidentiality.getValue());
		newAsset.setValueIntegrity(sldIntegrity.getValue());
		newAsset.setValueAvailability(sldAvailability.getValue());
		//newAsset.setOwnershipHistory(newOwner);
		//newAsset.setCustodyHistory(newCustodian);
		//newAsset.setStorageHistory(newStorage);
		newAsset.setClassification(lookUpClassification(cbxClassification.getSelectedItem().toString()));
		
		return newAsset;
	}
	/*public int lookUpType(String typeName) //if user can add types, this is impossible
	{
		int type;
		switch(typeName)
		{
		default:
			type=0;
		}
		return type;
	}*/
	public int lookUpClassification(String className)
	{
		switch(className)
		{
		case "Public":
			return 0;
	
		case "Internal":
			return 1;
			
		case "Sensitive":
			return 2;
			
		case "Confidential":
			return 3;
		default:
			return -1;
		}
	}
	public int lookUpMonth(String month)
	{
		switch(month)
		{
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		}
		return 0;
	}
	public Date getDate(int month, int day, int year)
	{
		Date date=new Date(year-1900, month-1, day);
		return date;
	}
	
}
