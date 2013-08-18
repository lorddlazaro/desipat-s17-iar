package fields;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ComboBoxInput extends AbstractInputField{
	JComboBox<String> comboBoxField;
	
	/*
	 * JLabel lblClassification = new JLabel("Classification");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblClassification.setBounds(62, 143, 88, 14);
		add(lblClassification);
		
		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential", ""}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxClassification.setBounds(201, 141, 156, 20);
		add(cbxClassification);
	 */
	
	public ComboBoxInput(String name) {
		super(name);
		
		comboBoxField.setFont(new Font("Calibri", Font.PLAIN, 12));
	}
	public void insertList(ArrayList<String> items){
		for(String item : items){
			comboBoxField.addItem(item);
		}
	}
	
	protected void addFields() {
		comboBoxField = new JComboBox<String>();
		this.add(comboBoxField);
	}
	protected void clearInput() {
		// TODO Auto-generated method stub
	}
	public void setInput(String toSet) {
		comboBoxField.setSelectedItem(toSet);
	}
	public String getInput() {
		return comboBoxField.getSelectedItem().toString();
	}
}