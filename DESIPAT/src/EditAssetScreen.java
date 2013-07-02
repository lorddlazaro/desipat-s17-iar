import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import java.awt.SystemColor;


public class EditAssetScreen extends JPanel {

	private int assetID;
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
	private JCheckBox chckbxStatus;
	private ArrayList<String>dayList;

	/*private ArrayList<String>personList;    //these lists to be populated from AssetScreen
	private ArrayList<String>storageList;*/
	private JTextField txtRetention;

	/**
	 * Create the panel.
	 */
	public EditAssetScreen(/*Asset a, ArrayList<String>personList,ArrayList<String>storageList*/) {
		setLayout(null);
		//asset=a;
		//this.personList=personList;
		//this.storageList=storageList;
		JLabel lblAddNewAsset = new JLabel("Edit Asset");
		lblAddNewAsset.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAddNewAsset.setBounds(26, 24, 168, 29);
		add(lblAddNewAsset);

		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOwner.setBounds(26, 326, 46, 14);
		add(lblOwner);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblName.setBounds(26, 87, 46, 14);
		add(lblName);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblType.setBounds(26, 264, 46, 14);
		add(lblType);

		JLabel lblMaintenanceSchedule = new JLabel("Maintenance Schedule");
		lblMaintenanceSchedule.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMaintenanceSchedule.setBounds(26, 235, 143, 14);
		add(lblMaintenanceSchedule);

		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(410, 65, 46, 14);
		add(lblValue);

		JLabel lblConfidentiality = new JLabel("Confidentiality:");
		lblConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblConfidentiality.setBounds(410, 155, 88, 14);
		add(lblConfidentiality);

		JLabel lblIntegrity = new JLabel("Integrity:");
		lblIntegrity.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblIntegrity.setBounds(410, 200, 88, 14);
		add(lblIntegrity);

		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAvailability.setBounds(410, 253, 88, 14);
		add(lblAvailability);

		JLabel lblFinancial = new JLabel("Financial:");
		lblFinancial.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFinancial.setBounds(410, 114, 88, 14);
		add(lblFinancial);

		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(26, 64, 148, 14);
		add(lblBasicInformation);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStatus.setBounds(26, 113, 88, 14);
		add(lblStatus);

		JLabel lblCustodian = new JLabel("Custodian");
		lblCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCustodian.setBounds(26, 354, 88, 14);
		add(lblCustodian);

		JLabel lblStorageLocation = new JLabel("Storage Location");
		lblStorageLocation.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStorageLocation.setBounds(26, 296, 115, 14);
		add(lblStorageLocation);

		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblClassification.setBounds(26, 139, 88, 14);
		add(lblClassification);

		cbxType = new JComboBox();
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"Document", "Equipment", "Product"}));
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxType.setBounds(77, 261, 124, 20);
		add(cbxType);

		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtName.setBounds(70, 84, 124, 20);
		add(txtName);
		txtName.setColumns(10);

		sldConfidentiality = new JSlider();
		sldConfidentiality.setPaintTicks(true);
		sldConfidentiality.setMinimum(1);
		sldConfidentiality.setValue(0);
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(510, 150, 100, 37);
		add(sldConfidentiality);

		sldIntegrity = new JSlider();
		sldIntegrity.setPaintTicks(true);
		sldIntegrity.setMinimum(1);
		sldIntegrity.setMaximum(5);
		sldIntegrity.setValue(0);
		sldIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldIntegrity.setBounds(510, 200, 100, 29);
		add(sldIntegrity);

		sldAvailability = new JSlider();
		sldAvailability.setMinimum(1);
		sldAvailability.setMajorTickSpacing(1);
		sldAvailability.setPaintTicks(true);
		sldAvailability.setPaintLabels(true);
		sldAvailability.setValue(0);
		sldAvailability.setMaximum(5);
		sldAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldAvailability.setBounds(510, 253, 100, 50);
		add(sldAvailability);

		txtFinancial = new JTextField();
		txtFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFinancial.setBounds(486, 112, 115, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);

		cbxStorage = new JComboBox();
		cbxStorage.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxStorage.setBounds(156, 293, 124, 20);
		add(cbxStorage);

		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential"}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxClassification.setBounds(114, 139, 87, 20);
		add(cbxClassification);

		cbxMaintenance = new JComboBox();
		cbxMaintenance.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly", "Yearly"}));
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxMaintenance.setBounds(165, 232, 69, 20);
		add(cbxMaintenance);

		JLabel lblDateAcquired = new JLabel("Date Acquired");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDateAcquired.setBounds(26, 169, 88, 14);
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
		cbxMonth.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxMonth.setBounds(124, 171, 100, 20);
		add(cbxMonth);

		cbxDay = new JComboBox();
		dayList=new ArrayList<String>();
		for(int day=1;day<=28;day++)
		{
			dayList.add(day+"");
		}
		days=dayList.toArray(new String[dayList.size()]);
		cbxDay.setModel(new DefaultComboBoxModel(days));
		cbxDay.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxDay.setBounds(234, 169, 46, 20);
		add(cbxDay);

		cbxYear = new JComboBox();
		ArrayList<String>yearList=new ArrayList<String>();
		for(int year=1900;year<=2050;year++)
		{
			yearList.add(year+"");
		}
		String[] years=yearList.toArray(new String[yearList.size()]);
		cbxYear.setModel(new DefaultComboBoxModel(years));
		cbxYear.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxYear.setBounds(292, 169, 59, 20);
		add(cbxYear);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMonth.setBounds(127, 190, 46, 14);
		add(lblMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDay.setBounds(234, 188, 32, 14);
		add(lblDay);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblYear.setBounds(292, 188, 46, 14);
		add(lblYear);

		JButton btnEdit = new JButton("SAVE CHANGES");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validInput())
					editAsset();
				refreshViewAsset();
			}
		});
		btnEdit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEdit.setBounds(460, 326, 150, 53);
		add(btnEdit);

		cbxOwner = new JComboBox();
		cbxOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxOwner.setBounds(98, 322, 182, 20);
		add(cbxOwner);

		cbxCustodian = new JComboBox();
		cbxCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxCustodian.setBounds(98, 350, 182, 20);
		add(cbxCustodian);

		JLabel lblRetentionPeriod = new JLabel("Retention Period");
		lblRetentionPeriod.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblRetentionPeriod.setBounds(26, 207, 100, 16);
		add(lblRetentionPeriod);

		txtRetention = new JTextField();
		txtRetention.setBounds(138, 209, 114, 20);
		add(txtRetention);
		txtRetention.setColumns(10);

		chckbxStatus = new JCheckBox("Asset is Active");
		chckbxStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxStatus.setBackground(SystemColor.inactiveCaption);
		chckbxStatus.setBounds(97, 107, 126, 23);
		add(chckbxStatus);




	}
	public void setAssetID(int assetID)
	{
		this.assetID=assetID;
	}
	public int getAssetID()
	{
		return assetID;
	}
	public void loadCurrentAssetInfo()
	{
		DBConnection db = new DBConnection();

		db.open();
		ResultSet rs = db.executeQuery(db.c,"select identifier, name, Concat(P.firstName, ' ',P.middleInitial,' ', P.lastName) as owner, Concat(C.firstName, ' ',C.middleInitial,' ', C.lastName) as custodian, type,dateAcquired,status, M.maintSched,  financialValue, confidentialValue,integrityValue,availabilityValue, L.classification, S.storageLocation from asset A inner join person P on P.personID=A.ownerID inner join person C on C.personID=A.custodianID inner join typelookup T on T.typeID=A.typeID inner join maintenancelookup M on M.maintID=A.maintID inner join classificationlookup L on L.classID=A.classID inner join storage S on S.storageID=A.storageID where identifier="+assetID);

		System.out.println("loaded current asset");
		try {
			while(rs.next()){
				System.out.println(rs.getInt("identifier"));
				System.out.println(rs.getString("identifier"));

				txtName.setText(rs.getString("name"));
				cbxOwner.setSelectedItem((Object)rs.getString("owner"));
				cbxCustodian.setSelectedItem((Object)rs.getString("custodian"));
				cbxType.setSelectedItem((Object)rs.getString("type"));
				cbxClassification.setSelectedItem((Object)rs.getString("classification"));
				cbxMaintenance.setSelectedItem((Object)rs.getString("maintSched"));
				cbxStorage.setSelectedItem((Object)rs.getString("storageLocation"));

				int month = Integer.valueOf(rs.getString("dateAcquired").split("-")[1]);
				switch(month){
					case 1: cbxMonth.setSelectedItem((Object)"January");break;
					case 2: cbxMonth.setSelectedItem((Object)"February");break;
					case 3: cbxMonth.setSelectedItem((Object)"March");break;
					case 4: cbxMonth.setSelectedItem((Object)"April");break;
					case 5: cbxMonth.setSelectedItem((Object)"May");break;
					case 6: cbxMonth.setSelectedItem((Object)"June");break;
					case 7: cbxMonth.setSelectedItem((Object)"July");break;
					case 8: cbxMonth.setSelectedItem((Object)"August");break;
					case 9: cbxMonth.setSelectedItem((Object)"September");break;
					case 10: cbxMonth.setSelectedItem((Object)"October");break;
					case 11: cbxMonth.setSelectedItem((Object)"November");break;
					case 12: cbxMonth.setSelectedItem((Object)"December");break;
				}

				cbxYear.setSelectedItem((Object)rs.getString("dateAcquired").split("-")[0]);
				cbxDay.setSelectedItem((Object)rs.getString("dateAcquired").split("-")[2]);

				switch(rs.getString("status"))
				{
				case "1":
					chckbxStatus.setSelected(true);
					break;
				case "0":
					chckbxStatus.setSelected(false);
					break;
				}
				txtFinancial.setText(rs.getString("financialValue"));
				sldConfidentiality.setValue(Integer.parseInt(rs.getString("confidentialValue")));
				sldIntegrity.setValue(Integer.parseInt(rs.getString("integrityValue")));
				sldAvailability.setValue(Integer.parseInt(rs.getString("availabilityValue")));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();

	}
	public void editAsset()
	{

		/*OwnershipHistory newOwner =new OwnershipHistory();
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
		asset.setOwnerID(lookUpPersonID(cbxOwner.getSelectedItem().toString()));
		asset.setCustodianID(lookUpPersonID(cbxCustodian.getSelectedItem().toString()));
		asset.setStorageID(lookUpStorageID(cbxStorage.getSelectedItem().toString()));
		asset.setClassification(lookUpClassification(cbxClassification.getSelectedItem().toString()));

		return asset;*/

			String ownerID = "";
			String custodianID = "";
			String typeID = "";
			String maintID = "";
			String classID = "";
			String storageID = "";
			String dateAcquired = cbxYear.getSelectedItem() + "-" + (cbxMonth.getSelectedIndex()+1) + "-" + cbxDay.getSelectedItem();


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
			String query = "UPDATE Asset SET name='"+txtName.getText()+"', ownerID='"+ownerID+"',custodianID='"+ custodianID +"',typeID='"+
			typeID +"',dateAcquired='"+ dateAcquired +"',status='" +status+
					"',maintID='"+maintID +"',financialValue='"+
							txtFinancial.getText() +"',confidentialValue='"+ sldConfidentiality.getValue() +"',integrityValue='"+ sldIntegrity.getValue() +"',availabilityValue='"+sldAvailability.getValue() +"',classID='"+ classID+"',storageID='" +storageID+"' WHERE identifier='"+assetID+"';";
			// TEMPORARY PRINTLINE THING
			System.out.println(query);
			DBcon.executeUpdate(con, query);
			DBcon.close();


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
		Date date=new Date(year-1900, month, day);
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

	public void fillComboBoxPerson(){
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
	public void fillComboBoxStorage(){
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

