package screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import screenBehaviourStrategy.AssetScreenBehaviorStrategy;

public class AddAssetScreen extends JPanel implements TableObserver {


	protected JLabel formTitle;

	AssetScreenBehaviorStrategy behavior;
	
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
	
	public AddAssetScreen(AssetScreenBehaviorStrategy behavior){
		this.behavior = behavior;
		initialize();
	}
	
	public void initialize() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		formTitle = new JLabel("Add New Asset");
		formTitle.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		formTitle.setBounds(10, 11, 168, 29);
		add(formTitle);
		
		assetName = new TextInput("Name");
		assetName.setBounds(60, 80, 200, 30);
		add(assetName);
		
		classification = new ComboBoxInput("Classification");
		ArrayList items = new ArrayList();
		for(Classification classification : ClassificationLookUpTable.getInstance().getAllEntries())
			items.add(classification);
		classification.insertList(items);
		classification.setBounds(60, 120, 300, 30);
		add(classification);
		
		dateAcquired = new DateInput("DateAquired");
		dateAcquired.setBounds(60, 160, 350, 30);
		add(dateAcquired);
		
		owner = new ObjectInput("Owner", "Please input name of new owner:",SystemColor.activeCaption);
		ArrayList items4 = new ArrayList();
		for(Person person : PersonTable.getInstance().getAllEntries())
			items4.add(person);
		owner.insertList(items4);
		owner.setBounds(60, 200, 350, 35);
		add(owner);
		
		custodian = new ObjectInput("Custodian", "Please input name of new custodian:",SystemColor.activeCaption);
		custodian.insertList(items4);
		custodian.setBounds(60, 240, 350, 35);
		add(custodian);
		
		type = new ObjectInput("Type", "Please input new type:",SystemColor.activeCaption);
		ArrayList items3 = new ArrayList();
		for(Type type : TypeLookUpTable.getInstance().getAllEntries())
			items3.add(type);
		type.insertList(items3);
		type.setBounds(60, 280, 350, 35);
		add(type);

		storage = new ObjectInput("Storage", "Please input new storage location:",SystemColor.activeCaption);
		ArrayList items5 = new ArrayList();
		for(Storage storage : StorageTable.getInstance().getAllEntries())
			items5.add(storage);
		storage.insertList(items5);
		storage.setBounds(60, 320, 350, 35);
		add(storage);
		
		maintenance = new ComboBoxInput("Maintenance");
		ArrayList items2 = new ArrayList();
		for(Maintenance maintenance : MaintenanceLookUpTable.getInstance().getAllEntries())
			items2.add(maintenance);
		maintenance.insertList(items2);
		maintenance.setBounds(60, 360, 300, 30);
		add(maintenance);
		
		period = new ComboBoxInput("Retention Period");
		ArrayList items7 = new ArrayList();
		for(RetentionPeriod retentionPeriod : RetentionPeriodLookUpTable.getInstance().getAllEntries())
			items7.add(retentionPeriod);
		period.insertList(items7);
		period.setBounds(60, 400, 300, 30);
		add(period);

		
		
		financialValue = new TextInput("Financial");
		financialValue.setBounds(430, 80, 300, 30);
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

		JButton btnAdd = new JButton("Add Asset");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{				
				behavior.saveAsset();
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.setBounds(583, 406, 179, 37);
		add(btnAdd);
	}
	
	public void refresh(){
		assetName.clearField();
		classification.clearField();
		dateAcquired.clearField();
		owner.clearField();
		custodian.clearField();
		type.clearField();
		storage.clearField();
		period.clearField();
		maintenance.clearField();
		financialValue.clearField();
		confidentialityValue.clearField();
		integrityValue.clearField();
		availabilityValue.clearField();
	}
	
	public void addOwnerNewButtonActionListener(ActionListener al){
		owner.addNewButtonActionListener(al);
	}
	public void addCustodianNewButtonActionListener(ActionListener al){
		custodian.addNewButtonActionListener(al);
	}
	public void addTypeNewButtonActionListener(ActionListener al){
		type.addNewButtonActionListener(al);
	}
	public void addStorageNewButtonActionListener(ActionListener al){
		storage.addNewButtonActionListener(al);
	}
	
	public String getAssetName(){
		return assetName.getInput();
	}
	public int getOwnerID(){
		return owner.getSelectedItem().getID();
	}
	public int getCustodianID(){
		return custodian.getSelectedItem().getID();
	}
	public int getTypeID(){
		return type.getSelectedItem().getID();
	}
	public int getMaintenanceID(){
		return maintenance.getSelectedItem().getID();
	}
	public int getClassificationID(){
		return classification.getSelectedItem().getID();
	}
	public int getStorageID(){
		return storage.getSelectedItem().getID();
	}
	public int getPeriodID(){
		return period.getSelectedItem().getID();
	}
	public String getDateAcquired(){
		return dateAcquired.getInput();
	}
	public Double getFinancialValue(){
		return Double.parseDouble(financialValue.getInput());
	}
	public int getConfidentialityValue(){
		return Integer.parseInt(confidentialityValue.getInput());
	}
	public int getIntegrityValue(){
		return Integer.parseInt(integrityValue.getInput());
	}
	public int getAvailabilityValue(){
		return Integer.parseInt(availabilityValue.getInput());
	}
}