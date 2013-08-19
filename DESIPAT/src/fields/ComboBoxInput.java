package fields;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import dataObjects.TableEntry;

public class ComboBoxInput extends AbstractInputField{
	protected JComboBox comboBoxField;
	
	public ComboBoxInput(String name) {
		super(name);
		
		comboBoxField.setFont(new Font("Calibri", Font.PLAIN, 12));
	}
	public void insertList(ArrayList items){
		for(Object item : items){
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
	
	public TableEntry getSelectedItem(){
		return (TableEntry) comboBoxField.getSelectedItem();
	}
}