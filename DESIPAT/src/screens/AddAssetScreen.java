package screens;
import screenBehaviourStrategy.AddTypeScreenBehavior;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

import dataObjects.Asset;
import dataObjects.Classification;
import dataObjects.ClassificationLookUpTable;
import dataObjects.Maintenance;
import dataObjects.MaintenanceLookUpTable;
import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.RetentionPeriod;
import dataObjects.RetentionPeriodLookUpTable;
import dataObjects.Storage;
import dataObjects.StorageTable;
import dataObjects.Type;
import dataObjects.TypeLookUpTable;
import fields.ComboBoxInput;
import fields.DateInput;
import fields.ObjectInput;
import fields.TextInput;
import fields.SliderInput;

import screenBehaviourStrategy.AddPersonScreenBehaviour;
import screenBehaviourStrategy.AddStorageScreenBehavior;
import screenBehaviourStrategy.AssetScreenBehaviorStrategy;

public class AddAssetScreen extends JPanel implements TableObserver {

	//protected JComboBox cbxClassification;
	//protected JComboBox cbxMaintenance;
	/*
	protected JComboBox cbxOwner;
	protected JComboBox cbxCustodian;
	protected JComboBox cbxType;
	protected JComboBox cbxStorage;*/
	
	/*private JTextField textFieldNewItem2;
	private JTextField textFieldNewItem3;
	private JTextField textFieldNewItem1;*/
	private JButton btnNewOwner;
	private JButton btnNewCustodian;
	private JButton btnNewType;
	private JButton btnNewStorage;
	private JPanel panelNewItem;
	
	/*private JLabel lblNewItem2;
	private JLabel lblNewItem1;
	private JLabel lblNewItem3;
	private JButton btnNewItemSave;
	private JButton btnNewItemCancel;*/
	protected JLabel lblAddNewAsset;

	AssetScreenBehaviorStrategy behaviour;
	
	protected TextInput assetName;
	protected ComboBoxInput classification;
	protected DateInput dateAcquired;
	protected ObjectInput owner;
	protected ObjectInput custodian;
	protected ObjectInput type;
	protected ObjectInput storage;
	protected ComboBoxInput period;
	protected ComboBoxInput maintenance;
	protected TextInput financialValue;
	protected SliderInput confidentialityValue;
	protected SliderInput integrityValue;
	protected SliderInput availabilityValue;
	
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public AddAssetScreen(AssetScreenBehaviorStrategy behaviour){
		this.behaviour=behaviour;
		initialize();
	}
	
	public void initialize() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		lblAddNewAsset = new JLabel("Add New Asset");
		lblAddNewAsset.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAddNewAsset.setBounds(10, 11, 168, 29);
		add(lblAddNewAsset);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(42, 51, 168, 14);
		add(lblBasicInformation);
		
		assetName = new TextInput("Name");
		assetName.setBounds(60, 80, 200, 25);
		add(assetName);
		
		classification = new ComboBoxInput("Classification");
		ArrayList items = new ArrayList();
		for(Classification classification : ClassificationLookUpTable.getInstance().getAllEntries())
			items.add(classification);
		classification.insertList(items);
		classification.setBounds(60, 120, 300, 25);
		add(classification);
		
		dateAcquired = new DateInput("DateAquired");
		dateAcquired.setBounds(60, 160, 350, 30);
		add(dateAcquired);
		
		owner = new ObjectInput("Owner");
		ArrayList items4 = new ArrayList();
		for(Person person : PersonTable.getInstance().getAllEntries())
			items4.add(person);
		owner.insertList(items4);
		owner.setBounds(60, 200, 300, 25);
		add(owner);
		
		custodian = new ObjectInput("Custodian");
		custodian.insertList(items4);
		custodian.setBounds(60, 240, 300, 25);
		add(custodian);
		
		type = new ObjectInput("Type");
		ArrayList items3 = new ArrayList();
		for(Type type : TypeLookUpTable.getInstance().getAllEntries())
			items3.add(type);
		type.insertList(items3);
		type.setBounds(60, 280, 300, 25);
		add(type);

		storage = new ObjectInput("Storage");
		ArrayList items5 = new ArrayList();
		for(Storage storage : StorageTable.getInstance().getAllEntries())
			items5.add(storage);
		storage.insertList(items5);
		storage.setBounds(60, 320, 300, 25);
		add(storage);
		
		maintenance = new ComboBoxInput("Maintenance");
		ArrayList items2 = new ArrayList();
		for(Maintenance maintenance : MaintenanceLookUpTable.getInstance().getAllEntries())
			items2.add(maintenance);
		maintenance.insertList(items2);
		maintenance.setBounds(60, 360, 300, 25);
		add(maintenance);
		
		period = new ComboBoxInput("Retention Period");
		ArrayList items7 = new ArrayList();
		for(RetentionPeriod retentionPeriod : RetentionPeriodLookUpTable.getInstance().getAllEntries())
			items7.add(retentionPeriod);
		period.insertList(items7);
		period.setBounds(60, 400, 300, 25);
		add(period);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(418, 51, 46, 14);
		add(lblValue);
		
		financialValue = new TextInput("Financial");
		financialValue.setBounds(430, 80, 300, 25);
		add(financialValue);
		
		confidentialityValue = new SliderInput("Confidentiality");
		confidentialityValue.setBounds(430, 120, 350, 40);
		add(confidentialityValue);	
		
		integrityValue = new SliderInput("Integrity");
		integrityValue.setBounds(430, 160, 350, 40);
		add(integrityValue);	
		
		availabilityValue = new SliderInput("Availability");
		availabilityValue.setBounds(430, 200, 350, 40);
		add(availabilityValue);
		
		btnNewOwner = new JButton("New");
		btnNewOwner.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(0);
				panelNewItem = new AddPersonScreenBehaviour().getView(); 
				panelNewItem.setName("Add Owner");
				//panelNewItem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			
			}
		}) ;
		btnNewOwner.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewOwner.setBounds(367, 247, 70, 20);
		add(btnNewOwner);
		
		btnNewCustodian = new JButton("New");
		btnNewCustodian.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(1);
			panelNewItem = new AddPersonScreenBehaviour().getView(); 
			panelNewItem.setName("Add Custodian");
			panelNewItem.setBounds(447, 248, 315, 137);
			add(panelNewItem);
			
			
			}
		});
		btnNewCustodian.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewCustodian.setBounds(367, 287, 70, 20);
		add(btnNewCustodian);
		
		btnNewType = new JButton("New");
		btnNewType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(2);
				panelNewItem = new AddTypeScreenBehavior().getView(); 
				//panelNewItem.setName("Add Type");
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			}
		});
		btnNewType.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewType.setBounds(367, 326, 70, 20);
		add(btnNewType);
		
		btnNewStorage = new JButton("New");
		btnNewStorage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(3);
				panelNewItem = new AddStorageScreenBehavior().getView(); 
				//panelNewItem.setName("Add Storage");
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			}
		});
		btnNewStorage.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewStorage.setBounds(367, 366, 70, 20);
		add(btnNewStorage);
		
		JButton btnAdd = new JButton("Add Asset");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Asset a =null;
		
				System.out.println("ZSKFJGASHGAJSHGKJAH");
				try {
					/*java.sql.Date sqlDate=new java.sql.Date(dateFormat.parse(dateAcquired).getTime());
					System.out.println(sqlDate.getTime());*/
					a =new Asset(assetName.getInput(), owner.getSelectedItem().getID(),custodian.getSelectedItem().getID(),type.getSelectedItem().getID(),maintenance.getSelectedItem().getID(),classification.getSelectedItem().getID(),storage.getSelectedItem().getID(),period.getSelectedItem().getID() , dateAcquired.getInput(), Double.parseDouble(financialValue.getInput()),Integer.parseInt(confidentialityValue.getInput()),Integer.parseInt(integrityValue.getInput()),Integer.parseInt(availabilityValue.getInput()));
					//System.out.println("Asset maint: "+a.getMaintID());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Invalid number format!");
			
				//int periodID, Date dateAcquired,){
				
			}
				behaviour.saveAsset(a);
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.setBounds(583, 406, 179, 37);
		add(btnAdd);
		
		/*panelNewItem = new JPanel();
		panelNewItem.setVisible(false);
		panelNewItem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelNewItem.setBounds(447, 248, 315, 137);
		add(panelNewItem);
		panelNewItem.setLayout(null);*/
		
		/*textFieldNewItem1 = new JTextField();
		textFieldNewItem1.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem1.setBounds(126, 8, 179, 20);
		panelNewItem.add(textFieldNewItem1);
		textFieldNewItem1.setColumns(10);
		
		textFieldNewItem2 = new JTextField();
		textFieldNewItem2.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem2.setBounds(126, 39, 179, 20);
		panelNewItem.add(textFieldNewItem2);
		textFieldNewItem2.setColumns(10);
		
		textFieldNewItem3 = new JTextField();
		textFieldNewItem3.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem3.setBounds(126, 70, 179, 20);
		panelNewItem.add(textFieldNewItem3);
		textFieldNewItem3.setColumns(10);*/
		
		/*btnNewItemCancel = new JButton("Cancel");
		btnNewItemCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				behaviour.cancel();
			}
		});
		btnNewItemCancel.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewItemCancel.setBounds(126, 106, 85, 20);
		panelNewItem.add(btnNewItemCancel);
		
		btnNewItemSave = new JButton("Save");
		btnNewItemSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				
				behaviour.saveItem();
			}
		});
		btnNewItemSave.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewItemSave.setBounds(222, 106, 70, 20);
		panelNewItem.add(btnNewItemSave);*/
		
		/*lblNewItem1 = new JLabel("Storage Location");
		lblNewItem1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem1.setBounds(10, 8, 106, 14);
		panelNewItem.add(lblNewItem1);
		
		lblNewItem2 = new JLabel("<label>");
		lblNewItem2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem2.setBounds(10, 39, 93, 14);
		panelNewItem.add(lblNewItem2);
		
		lblNewItem3 = new JLabel("<label>");
		lblNewItem3.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem3.setBounds(10, 70, 93, 14);
		panelNewItem.add(lblNewItem3);*/
		//refresh();
	}
	
	public void refresh(){
		behaviour.fillBoxes();
	}
/*
	private JComboBox getCbxType() {
		return cbxType;
	}

	public void setCbxTypeContents(ArrayList<String>typeList) {
		String[] types=typeList.toArray(new String[typeList.size()]);
		cbxType.setModel(new DefaultComboBoxModel(types));
	}

	private JComboBox getCbxStorage() {
		return cbxStorage;
	}

	public void setCbxStorageContents(ArrayList<String>storageList) {
		String[] storages=storageList.toArray(new String[storageList.size()]);
		cbxStorage.setModel(new DefaultComboBoxModel(storages));
	}

	private JComboBox getCbxOwner() {
		return cbxOwner;
	}

	public void setCbxOwnerContents(ArrayList<String>personList) {
		String[] persons=personList.toArray(new String[personList.size()]);
		cbxOwner.setModel(new DefaultComboBoxModel(persons));
	}

	private JComboBox getCbxCustodian() {
		return cbxCustodian;
	}

	public void setCbxCustodianContents(ArrayList<String>personList) {
		String[] persons=personList.toArray(new String[personList.size()]);
		cbxCustodian.setModel(new DefaultComboBoxModel(persons));
	}*/
}