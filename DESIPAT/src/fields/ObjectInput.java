package fields;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


class ObjectField extends AbstractInputField {
	JComboBox<String> myField = new JComboBox<String>();
	JButton myButton = new JButton();
	JFrame newFrame = new JFrame();
	
	public ObjectField(String name) {
		super(name);
	}
	
	public void addFields() {
		this.add(myField);
		this.add(myButton);
	}

	public void setInput(String toSet) {
		myField.setSelectedItem(toSet);
	}

	public String getInput() {
		return myField.getSelectedItem().toString();
	}
}