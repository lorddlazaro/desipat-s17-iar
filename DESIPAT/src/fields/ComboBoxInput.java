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
		comboBoxField.removeAllItems();
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
		for(int i = 0; i < comboBoxField.getItemCount(); i++)
			if(comboBoxField.getItemAt(i).toString().equals(toSet)){
				comboBoxField.setSelectedIndex(i);
				break;
			}
	}
	public String getInput() {
		if(comboBoxField.getSelectedItem()!=null)
			return comboBoxField.getSelectedItem().toString().trim();
		return null;
	}
	
	public Object getSelectedItem(){
		return comboBoxField.getSelectedItem();
	}
}