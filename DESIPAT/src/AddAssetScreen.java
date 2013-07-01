import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;


public class AddAssetScreen extends JPanel {
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
	private ArrayList<String>dayList;
	
	private ArrayList<String>personList;    //these lists to be populated from AssetScreen
	private ArrayList<String>storageList;
	
	JCheckBox chckbxStatus;
	private JTextField txtRetentionPeriod;
	/**
	 * Create the panel.
	 */
	public AddAssetScreen(/*ArrayList<String> personList, ArrayList<String>storageList*/) {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		this.personList=personList;
		this.storageList=storageList;
		
		JLabel lblAddNewAsset = new JLabel("Add New Asset");
		lblAddNewAsset.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAddNewAsset.setBounds(10, 11, 168, 29);
		add(lblAddNewAsset);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(42, 51, 168, 14);
		add(lblBasicInformation);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblName.setBounds(62, 79, 46, 14);
		add(lblName);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStatus.setBounds(62, 112, 88, 14);
		add(lblStatus);
		
		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblClassification.setBounds(62, 143, 88, 14);
		add(lblClassification);
		
		JLabel labelRetention = new JLabel("Retention Period");
		labelRetention.setFont(new Font("Calibri", Font.PLAIN, 14));
		labelRetention.setBounds(62, 229, 116, 14);
		add(labelRetention);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDateAcquired.setBounds(62, 182, 88, 14);
		add(lblDateAcquired);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMonth.setBounds(186, 201, 46, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDay.setBounds(254, 201, 32, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblYear.setBounds(311, 201, 46, 14);
		add(lblYear);
		
		JLabel lblMaintenanceSchedule = new JLabel("Maintenance Schedule");
		lblMaintenanceSchedule.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMaintenanceSchedule.setBounds(62, 273, 148, 14);
		add(lblMaintenanceSchedule);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(418, 51, 46, 14);
		add(lblValue);
		
		JLabel lblFinancial = new JLabel("Financial");
		lblFinancial.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFinancial.setBounds(446, 83, 88, 14);
		add(lblFinancial);
		
		JLabel lblConfidentiality = new JLabel("Confidentiality");
		lblConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblConfidentiality.setBounds(445, 116, 99, 14);
		add(lblConfidentiality);
		
		JLabel lblIntegrity = new JLabel("Integrity");
		lblIntegrity.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblIntegrity.setBounds(445, 158, 99, 14);
		add(lblIntegrity);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAvailability.setBounds(445, 206, 99, 14);
		add(lblAvailability);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblType.setBounds(62, 305, 46, 14);
		add(lblType);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOwner.setBounds(62, 369, 46, 14);
		add(lblOwner);
		
		JLabel lblCustodian = new JLabel("Custodian");
		lblCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCustodian.setBounds(62, 401, 88, 14);
		add(lblCustodian);
		
		JLabel lblStorageLocation = new JLabel("Storage Location");
		lblStorageLocation.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStorageLocation.setBounds(62, 337, 100, 14);
		add(lblStorageLocation);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtName.setBounds(201, 77, 156, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtRetentionPeriod = new JTextField();
		txtRetentionPeriod.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtRetentionPeriod.setColumns(10);
		txtRetentionPeriod.setBounds(201, 227, 156, 20);
		add(txtRetentionPeriod);
		
		txtFinancial = new JTextField();
		txtFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFinancial.setBounds(552, 81, 197, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);
		
		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential", ""}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxClassification.setBounds(201, 141, 156, 20);
		add(cbxClassification);
		
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
		cbxMonth.setBounds(183, 182, 70, 20);
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
		cbxDay.setBounds(255, 182, 55, 20);
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
		cbxYear.setBounds(311, 182, 46, 20);
		add(cbxYear);
		
		cbxMaintenance = new JComboBox();
		cbxMaintenance.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly", "Yearly"}));
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMaintenance.setBounds(201, 271, 155, 20);
		add(cbxMaintenance);
		
		sldConfidentiality = new JSlider();
		sldConfidentiality.setBackground(SystemColor.inactiveCaption);
		sldConfidentiality.setPaintTicks(true);
		sldConfidentiality.setMajorTickSpacing(1);
		sldConfidentiality.setMinimum(1);
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setValue(0);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(554, 112, 195, 43);
		add(sldConfidentiality);
		
		sldIntegrity = new JSlider();
		sldIntegrity.setBackground(SystemColor.inactiveCaption);
		sldIntegrity.setPaintTicks(true);
		sldIntegrity.setMajorTickSpacing(1);
		sldIntegrity.setMinimum(1);
		sldIntegrity.setValue(0);
		sldIntegrity.setMaximum(5);
		sldIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldIntegrity.setBounds(554, 158, 195, 37);
		add(sldIntegrity);
		
		sldAvailability = new JSlider();
		sldAvailability.setBackground(SystemColor.inactiveCaption);
		sldAvailability.setPaintLabels(true);
		sldAvailability.setPaintTicks(true);
		sldAvailability.setMajorTickSpacing(1);
		sldAvailability.setMinimum(1);
		sldAvailability.setValue(0);
		sldAvailability.setMaximum(5);
		sldAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldAvailability.setBounds(554, 206, 195, 43);
		add(sldAvailability);
		
		cbxType = new JComboBox();
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"Document", "Equipment", "Product"}));
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxType.setBounds(201, 303, 156, 20);
		add(cbxType);
		
		cbxOwner = new JComboBox();
		cbxOwner.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxOwner.setBounds(201, 367, 156, 20);
		add(cbxOwner);
		
		cbxCustodian = new JComboBox();
		cbxCustodian.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCustodian.setBounds(202, 399, 155, 20);
		add(cbxCustodian);
		
		JButton btnAdd = new JButton("Add Asset");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//addAsset();
				System.out.println("Asset");
				System.out.println(txtName.getText());

				System.out.println(cbxOwner.getSelectedItem());
				System.out.println(cbxCustodian.getSelectedItem());
				System.out.println(cbxType.getSelectedItem());

				System.out.println(cbxYear.getSelectedItem() + "-" + cbxMonth.getSelectedItem() + "-" + cbxDay.getSelectedItem());
				
				System.out.println(chckbxStatus.isSelected());
				System.out.println(cbxMaintenance.getSelectedItem());
				System.out.println(txtFinancial.getText());

				System.out.println(sldConfidentiality.getValue());
				System.out.println(sldIntegrity.getValue());
				System.out.println(sldAvailability.getValue());
				

				System.out.println(cbxClassification.getSelectedItem());
				System.out.println(cbxStorage.getSelectedItem());
				if(validInput())
					saveAsset();
				
				//refresh view asset Screen tables - lordd
				refreshViewAsset();
			}
		});
		
		
		
		cbxStorage = new JComboBox();
		cbxStorage.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxStorage.setBounds(201, 335, 156, 20);
		add(cbxStorage);
		
		chckbxStatus = new JCheckBox("Asset is Active");
		chckbxStatus.setBackground(SystemColor.inactiveCaption);
		chckbxStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxStatus.setBounds(200, 108, 126, 23);
		add(chckbxStatus);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.setBounds(570, 379, 179, 51);
		add(btnAdd);

		fillComboBoxPerson();
		fillComboBoxStorage();
	}
	
	private void saveAsset(){
		String ownerID = "";
		String custodianID = "";
		String typeID = "";
		String maintID = "";
		String classID = "";
		String storageID = "";
		String dateAcquired = cbxYear.getSelectedItem() + "-" + cbxMonth.getSelectedIndex() + "-" + cbxDay.getSelectedItem();
		

		DBConnection DBcon = new DBConnection();
		
		String ownerFirstName =  cbxOwner.getSelectedItem().toString().split(" ")[0];
		String ownerMiddleInitial =  cbxOwner.getSelectedItem().toString().split(" ")[1];
		String ownerLastName =  cbxOwner.getSelectedItem().toString().split(" ")[2];

		String custodianFirstName =  cbxCustodian.getSelectedItem().toString().split(" ")[0];
		String custodianMiddleInitial =  cbxCustodian.getSelectedItem().toString().split(" ")[1];
		String custodianLastName =  cbxCustodian.getSelectedItem().toString().split(" ")[2];
		
		
		Connection con = DBcon.open();
		ResultSet rs;
		try{
			rs = DBcon.executeQuery(con, "select personID from Person where firstName = '"+ownerFirstName+"' AND middleinitial = '"+ownerMiddleInitial+"' AND lastname = '"+ownerLastName+"';");
		
			if(rs.isBeforeFirst()){
				rs.first();
				ownerID = rs.getString(1);
			}
			rs = DBcon.executeQuery(con, "select personID from Person where firstName = '"+custodianFirstName+"' AND middleinitial = '"+custodianMiddleInitial+"' AND lastname = '"+custodianLastName+"';");
			
			if(rs.isBeforeFirst()){
				rs.first();
				custodianID = rs.getString(1);
			}
			rs = DBcon.executeQuery(con, "select typeID from TypeLookUp where type = '"+cbxType.getSelectedItem()+"';");
			
			if(rs.isBeforeFirst()){
				rs.first();
				typeID = rs.getString(1);
			}
			rs = DBcon.executeQuery(con, "select maintID from MaintenanceLookUp where maintSched = '"+cbxMaintenance.getSelectedItem()+"';");
			
			if(rs.isBeforeFirst()){
				rs.first();
				maintID = rs.getString(1);
			}
			rs = DBcon.executeQuery(con, "select classID from ClassificationLookUp where classification = '"+cbxClassification.getSelectedItem()+"';");
			
			if(rs.isBeforeFirst()){
				rs.first();
				classID = rs.getString(1);
			}
			rs = DBcon.executeQuery(con, "select storageID from Storage where storagelocation = '"+cbxStorage.getSelectedItem()+"';");
			
			if(rs.isBeforeFirst()){
				rs.first();
				storageID = rs.getString(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		int status = (chckbxStatus.isSelected()?1:0);
		String query = "INSERT INTO Asset(name,ownerID,custodianID,typeID,dateAcquired,status" +
				",maintID,financialValue,confidentialValue,integrityValue,availabilityValue,classID,storageID)" +
				" values ('" +txtName.getText()+ "','"+ ownerID +"','"+ custodianID +"','"+
				typeID +"','"+ dateAcquired +"','"+ status +"','"+maintID +"','"+
				txtFinancial.getText() +"','"+ sldConfidentiality.getValue() +"','"+ sldIntegrity.getValue() +"','"+
				sldAvailability.getValue() +"','"+ classID +"','"+ storageID + "');";
		// TEMPORARY PRINTLINE THING
		System.out.println(query);
		DBcon.executeUpdate(con, query);
		DBcon.close();
	}
	
	private void fillComboBoxPerson(){
		cbxOwner.removeAllItems();
		cbxCustodian.removeAllItems();
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select * from Person;");
		try{
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					cbxOwner.addItem(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					cbxCustodian.addItem(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					rs.next();
				}
			}
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private void fillComboBoxStorage(){
		cbxStorage.removeAllItems();

		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select * from Storage;");
		try{
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					cbxStorage.addItem(rs.getString(2));
					rs.next();
				}
			}
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Asset addAsset()
	{
		Asset newAsset = new Asset();
		OwnershipHistory newOwner =new OwnershipHistory();
		StorageHistory newStorage= new StorageHistory();
		CustodyHistory newCustodian= new CustodyHistory();
		
		newAsset.setIsActive(true);
		
		
		newAsset.setName(txtName.getText());
		
		newAsset.setType(lookUpType(cbxType.getSelectedItem().toString()));
		newAsset.setDateAcquired(getDate(lookUpMonth(cbxMonth.getSelectedItem().toString()),Integer.parseInt(cbxDay.getSelectedItem().toString()),Integer.parseInt(cbxYear.getSelectedItem().toString())));
		newAsset.setValueFinancial(Float.parseFloat(txtFinancial.getText()));
		newAsset.setValueConfidentiality(sldConfidentiality.getValue());
		newAsset.setValueIntegrity(sldIntegrity.getValue());
		newAsset.setValueAvailability(sldAvailability.getValue());
		
		newAsset.setOwnerID(lookUpPersonID(cbxOwner.getSelectedItem().toString()));
		newAsset.setCustodianID(lookUpPersonID(cbxCustodian.getSelectedItem().toString()));
		newAsset.setStorageID(lookUpStorageID(cbxStorage.getSelectedItem().toString()));
		newAsset.setMaintenanceSchedule(lookUpSchedule(cbxMaintenance.getSelectedItem().toString()));
		newAsset.setClassification(lookUpClassification(cbxClassification.getSelectedItem().toString()));
		
		return newAsset;
	}
	public int lookUpPersonID(String name)
	{
	
		int id=-1;
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select personID from Person where Name="+name+";");
		try{
			id=rs.getInt(1);
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	public int lookUpStorageID(String name)
	{
		int id=-1;
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		ResultSet rs = DBcon.executeQuery(con, "select storageID from Storage where StorageLocation="+name+";");
		try{
			id=rs.getInt(1);
			DBcon.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
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
	
	public int
 lookUpMonth(String month)
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
		Date date=new Date(year-1899, month, day);
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
	
	private boolean validInput(){
		boolean hasName = !txtName.getText().isEmpty();
		boolean hasFinancial = !txtFinancial.getText().isEmpty();
		
		if(hasName)
			if(hasFinancial){
				// Case 1: both fields are filled
				txtName.setBackground(Color.WHITE);
				txtFinancial.setBackground(Color.WHITE);
				
				return true;
			}
			else{
				// Case 2: empty password field
				txtName.setBackground(Color.WHITE);
				txtFinancial.setBackground(Color.PINK);
			}
		else
			if(hasFinancial){
				// Case 3: empty username field
				txtName.setBackground(Color.WHITE);
				txtFinancial.setBackground(Color.PINK);
			}
			else{
				// Case 4: both fields are empty
				txtName.setBackground(Color.PINK);
				txtFinancial.setBackground(Color.PINK);
			}
		return false;
	}
	public void refreshViewAsset(){
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		if(mainScreen!=null){
			System.out.println("ms not null");
			mainScreen.panelViewAsset.updateAssetTable();
		}
	}
}


