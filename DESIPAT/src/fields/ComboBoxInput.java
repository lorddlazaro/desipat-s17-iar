package fields;

import javax.swing.JComboBox;

class ComboBoxInput extends AbstractInputField{
	JComboBox<String> myField = new JComboBox<String>();
	
	public ComboBoxInput(String name) {
		super(name);
	}
	
	public void addFields() {
		this.add(myField);
	}
	
	public void setInput(String toSet) {
		myField.setSelectedItem(toSet);
	}
	
	public String getInput() {
		return myField.getSelectedItem().toString();
	}
}