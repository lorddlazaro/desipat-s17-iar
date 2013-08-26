package screens;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import dataObjects.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.SystemColor;

import fields.ComboBoxInput;
import fields.DateInput;
import fields.ObjectInput;
import fields.TextInput;
import fields.SliderInput;

import screenBehaviourStrategy.AssetScreenBehaviorStrategy;

public class FormAssetScreen extends JPanel {

	AssetScreenBehaviorStrategy behavior;

	protected JLabel formTitle;
	
	protected TextInput assetName;
	protected ComboBoxInput classification;
	protected DateInput dateAcquired;
	protected ObjectInput owner;
	protected ObjectInput custodian;
	protected ComboBoxInput type;
	protected ObjectInput storage;
	protected ComboBoxInput period;
	protected ComboBoxInput maintenance;
	protected TextInput financialValue;
	protected SliderInput confidentialityValue;
	protected SliderInput integrityValue;
	protected SliderInput availabilityValue;
	
	protected JButton formButton;
	
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public FormAssetScreen(AssetScreenBehaviorStrategy behavior, String title, String buttonText){
		this.behavior = behavior;
		initialize();
		
		formTitle.setText(title);
		formButton.setText(buttonText);
	}
	
	public void initialize() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		formTitle = new JLabel();
		formTitle.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		formTitle.setBounds(10, 11, 168, 29);
		add(formTitle);
		
		assetName = new TextInput("Name");
		assetName.setBounds(60, 80, 200, 30);
		add(assetName);
		
		classification = new ComboBoxInput("Classification");
		classification.setBounds(60, 120, 300, 30);
		add(classification);
		
		dateAcquired = new DateInput("DateAquired");
		dateAcquired.setBounds(60, 160, 350, 30);
		add(dateAcquired);
		
		owner = new ObjectInput("Owner", "Please input name of new owner:",SystemColor.activeCaption);
		owner.setBounds(60, 200, 350, 35);
		add(owner);
		
		custodian = new ObjectInput("Custodian", "Please input name of new custodian:",SystemColor.activeCaption);
		custodian.setBounds(60, 240, 350, 35);
		add(custodian);
		
		type = new ComboBoxInput("Type");
		type.setBounds(60, 280, 350, 35);
		add(type);

		storage = new ObjectInput("Storage", "Please input new storage location:",SystemColor.activeCaption);
		storage.setBounds(60, 320, 350, 35);
		add(storage);
		
		maintenance = new ComboBoxInput("Maintenance");
		maintenance.setBounds(60, 360, 300, 30);
		add(maintenance);
		
		period = new ComboBoxInput("Retention Period");
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

		formButton = new JButton();
		formButton.setBackground(SystemColor.activeCaption);
		formButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		formButton.setBounds(583, 406, 179, 37);
		add(formButton);
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

	public void addStorageNewButtonActionListener(ActionListener al){
		storage.addNewButtonActionListener(al);
	}
	
	public void addFormButtonActionListener(ActionListener al){
		formButton.addActionListener(al);
	}
	
	public String getAssetName(){
		return assetName.getInput();
	}
	public int getOwnerID(){
		return ((Person)owner.getSelectedItem()).getID();
	}
	public int getCustodianID(){
		return ((Person)custodian.getSelectedItem()).getID();
	}
	public int getTypeID(){
		return ((Type)type.getSelectedItem()).getID();
	}
	public int getMaintenanceID(){
		return ((Maintenance)maintenance.getSelectedItem()).getID();
	}
	public int getClassificationID(){
		return ((Classification)classification.getSelectedItem()).getID();
	}
	public int getStorageID(){
		return ((Storage)storage.getSelectedItem()).getID();
	}
	public int getPeriodID(){
		return ((RetentionPeriod)period.getSelectedItem()).getID();
	}
	public String getDateAcquired(){
		return dateAcquired.getInput();
	}
	public Double getFinancialValue(){
		try{
			return Double.parseDouble(financialValue.getInput());
		}catch(Exception e){return null;}
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
	
	public void fillClassificationComboBox(ArrayList arr){
		classification.insertList(arr);
	}
	public void fillOwnerComboBox(ArrayList arr){
		owner.insertList(arr);
	}
	public void fillCustodianComboBox(ArrayList arr){
		custodian.insertList(arr);
	}
	public void fillTypeComboBox(ArrayList arr){
		type.insertList(arr);
	}
	public void fillStorageComboBox(ArrayList arr){
		storage.insertList(arr);
	}
	public void fillPeriodComboBox(ArrayList arr){
		period.insertList(arr);
	}
	public void fillMaintenanceComboBox(ArrayList arr){
		maintenance.insertList(arr);
	}
	
	public void loadEntry(Asset a)
	{
		if(a != null){
			setAssetName(a.getName());
			setOwner(a.getOwner().toString());
			setCustodian(a.getCustodian().toString());
			setType(a.getType().getType());
			setMaintenance(a.getMaintenance().getMaintenance());
			setClassification(a.getClassification().getClassification());
			setStorage(a.getStorage().getStorageLocation());
			setPeriod(a.getRetentionPeriod().getPeriodName());
			setDateAcquired(a.getDateAcquired());
			setFinancialValue(Double.toString(a.getFinancialValue()));
			setConfidentialityValue(Integer.toString(a.getConfidentialValue()));
			setIntegrityValue(Integer.toString(a.getIntegrityValue()));
			setAvailabilityValue(Integer.toString(a.getAvailabilityValue()));
		}
	}
	
	public void setAssetName(String toSet){
		assetName.setInput(toSet);
	}
	public void setOwner(String toSet){
		owner.setInput(toSet);
	}
	public void setCustodian(String toSet){
		custodian.setInput(toSet);
	}
	public void setType(String toSet){
		type.setInput(toSet);
	}
	public void setMaintenance(String toSet){
		maintenance.setInput(toSet);
	}
	public void setClassification(String toSet){
		classification.setInput(toSet);
	}
	public void setStorage(String toSet){
		storage.setInput(toSet);
	}
	public void setPeriod(String toSet){
		period.setInput(toSet);
	}
	public void setDateAcquired(String toSet){
		dateAcquired.setInput(toSet);
	}
	public void setFinancialValue(String toSet){
		financialValue.setInput(toSet);
	}
	public void setConfidentialityValue(String toSet){
		confidentialityValue.setInput(toSet);
	}
	public void setIntegrityValue(String toSet){
		integrityValue.setInput(toSet);
	}
	public void setAvailabilityValue(String toSet){
		availabilityValue.setInput(toSet);
	}

	public void displayErrorMsg(String msg){
		JOptionPane.showMessageDialog(null, msg, "Error!", JOptionPane.ERROR_MESSAGE);
	}

}