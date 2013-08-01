package fields;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TextInput extends InputField {
	JTextField myField = new JTextField();
	
	public TextInput(String name) {
		super(name);
	}
	public TextInput(String name,int x, int y, int width, int height) {
		super(name);
		myField.setBounds(x, y, width, height);
	}
	
	public void addFields() {
		this.add(myField);
	}
	
	public void setListener(ActionListener fieldListener) {
		myField.addActionListener(fieldListener);
	}
	
	public void setInput(String toSet) {
		myField.setText(toSet);
	}
	
	public String getInput() {
		return myField.getText();
	}
}
