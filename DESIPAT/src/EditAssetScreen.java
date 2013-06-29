import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;


public class EditAssetScreen extends JPanel {

	private JTextField txtName;
	private JTextField txtFinancial;
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
	private JComboBox cbxOwner;
	private JComboBox cbxCustodian;
	private String[]days;
	private Asset asset;
	private ArrayList<String>dayList;
	
	private ArrayList<String>personList;    //these lists to be populated from AssetScreen
	private ArrayList<String>storageList;

	/**
	 * Create the panel.
	 */
	public EditAssetScreen(Asset a, ArrayList<String>personList,ArrayList<String>storageList) {
		setLayout(null);
		asset=a;
		this.personList=personList;
		this.storageList=storageList;
		JLabel lblAddNewAsset = new JLabel("Edit Asset");
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
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(26, 64, 148, 14);
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
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"Document", "Equipment", "Product"}));
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxType.setBounds(70, 114, 124, 20);
		add(cbxType);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtName.setBounds(70, 86, 124, 20);
		add(txtName);
		txtName.setColumns(10);
		
		sldConfidentiality = new JSlider();
		sldConfidentiality.setValue(0);
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(107, 220, 100, 23);
		add(sldConfidentiality);
		
		sldIntegrity = new JSlider();
		sldIntegrity.setMaximum(5);
		sldIntegrity.setValue(0);
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
		txtFinancial.setBounds(79, 198, 115, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);
		
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
		cbxMaintenance.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly", "Yearly"}));
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMaintenance.setBounds(138, 401, 52, 20);
		add(cbxMaintenance);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired:");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDateAcquired.setBounds(26, 154, 88, 14);
		add(lblDateAcquired);
		
		cbxMonth = new JComboBox();
		cbxMonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED)
				{
					String month=arg0.getItem().toString();
					listDays(month,dayList);
				}
			}
		});
		cbxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		cbxMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMonth.setBounds(104, 145, 46, 20);
		add(cbxMonth);
		
		cbxDay = new JComboBox();
		dayList=new ArrayList<String>();
		for(int day=1;day<=28;day++)
		{
			dayList.add(day+"");
		}
		days=dayList.toArray(new String[dayList.size()]);
		cbxDay.setModel(new DefaultComboBoxModel(days));
		cbxDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxDay.setBounds(161, 145, 46, 20);
		add(cbxDay);
		
		cbxYear = new JComboBox();
		ArrayList<String>yearList=new ArrayList<String>();
		for(int year=1900;year<=2050;year++)
		{
			yearList.add(year+"");
		}
		String[] years=yearList.toArray(new String[yearList.size()]);
		cbxYear.setModel(new DefaultComboBoxModel(years));
		cbxYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxYear.setBounds(219, 145, 46, 20);
		add(cbxYear);
		
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
		
		JButton btnEdit = new JButton("SAVE CHANGES");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editAsset();
			}
		});
		btnEdit.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnEdit.setBounds(26, 454, 115, 23);
		add(btnEdit);
		
		JButton btnRetireAsset = new JButton("RETIRE ASSET");
		btnRetireAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asset.setIsActive(false);
			}
		});
		btnRetireAsset.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRetireAsset.setBounds(156, 454, 127, 23);
		add(btnRetireAsset);
		
		cbxOwner = new JComboBox();
		cbxOwner.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxOwner.setBounds(98, 325, 96, 20);
		add(cbxOwner);
		
		cbxCustodian = new JComboBox();
		cbxCustodian.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCustodian.setBounds(98, 350, 96, 20);
		add(cbxCustodian);

	}
	public Asset editAsset()
	{
	
		OwnershipHistory newOwner =new OwnershipHistory();
		StorageHistory newStorage= new StorageHistory();
		CustodyHistory newCustodian= new CustodyHistory();
		
		asset.setName(txtName.getText());
		
		asset.setType(lookUpType(cbxType.getSelectedItem().toString()));
		asset.setDateAcquired(getDate(lookUpMonth(cbxMonth.getSelectedItem().toString()),Integer.parseInt(cbxDay.getSelectedItem().toString()),Integer.parseInt(cbxYear.getSelectedItem().toString())));
		asset.setValueFinancial(Float.parseFloat(txtFinancial.getText()));
		asset.setValueConfidentiality(sldConfidentiality.getValue());
		asset.setValueIntegrity(sldIntegrity.getValue());
		asset.setValueAvailability(sldAvailability.getValue());
		asset.setMaintenanceSchedule(lookUpSchedule(cbxMaintenance.getSelectedItem().toString()));
		//newAsset.setOwnershipHistory(newOwner);
		//newAsset.setCustodyHistory(newCustodian);
		//newAsset.setStorageHistory(newStorage);
		asset.setClassification(lookUpClassification(cbxClassification.getSelectedItem().toString()));
		
		return asset;
	
	}
	public int lookUpPersonID(String name)
	{
		return 0;
	}
	public int lookUpStorageID(String name)
	{
		return 0;
	}
	public int lookUpType(String typeName)
	{
		
		switch(typeName)
		{
		case "Document":
			return 0;
		case "Equipment":
			return 1;
		case "Product":
			return 2;
		default:
			return -1;
		}
	
	}
	public int lookUpClassification(String className)
	{
		switch(className)
		{
		case "Public":
			return 3;
	
		case "Internal":
			return 2;
			
		case "Sensitive":
			return 0;
			
		case "Confidential":
			return 1;
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
	public int lookUpSchedule(String schedule)
	{
		switch(schedule)
		{
		case "Daily":
			return 0;
		case "Weekly":
			return 1;
		case "Monthly":
			return 2;
		case "Yearly":
			return 3;
		default:
			return -1;
		}
	}
	public void listDays(String month, ArrayList<String>dayList)
	{
	
	switch(month)
	{
		case "April":
		case "June":
		case "September":
		case "November":
			dayList.add("29");
			dayList.add("30");
		case "January":
		case "March":
		case "May":
		case "July":
		case "August":
		case "October":
		case "December":
			dayList.add("31");
			break;
	}
	days=dayList.toArray(new String[dayList.size()]);
	cbxDay.setModel(new DefaultComboBoxModel(days));
	
	}
}
