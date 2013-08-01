package fields;

import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JSlider;


class PasswordInput extends InputField{
	JPasswordField myField = new JPasswordField();
	
	public PasswordInput(String name) {
		super(name);
	}
	
	public void addFields() {
		this.add(myField);
	}
	
	// unsure if needed
	public void setListener(ActionListener myListener) {
		myField.addActionListener(myListener);
	}
	
	public void setInput(String toSet) {
		myField.setText(toSet);
	}
	
	public String getInput() {
		return myField.getText();
	}
}
