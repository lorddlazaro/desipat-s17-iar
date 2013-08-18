package fields;

import java.awt.Font;

import javax.swing.JComboBox;

class ComboBoxInput extends AbstractInputField{
	JComboBox<String> myField;
	
	public ComboBoxInput(String name) {
		super(name);
		
		fieldLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
	}
	
	public void addFields() {
		myField = new JComboBox<String>();
		this.add(myField);
	}
	protected void clearInput() {
		// TODO Auto-generated method stub
		
	}
	
	public void setInput(String toSet) {
		myField.setSelectedItem(toSet);
	}
	
	public String getInput() {
		return myField.getSelectedItem().toString();
	}

	
}