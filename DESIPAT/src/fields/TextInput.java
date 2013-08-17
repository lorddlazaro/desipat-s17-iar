package fields;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TextInput extends AbstractInputField {
	JTextField textField;
	
	public TextInput(String name) {
		super(name);
		
		fieldLabel.setFont(new Font("Calibri", Font.PLAIN, 18));

		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setColumns(10);
	}
	
	public void setListener(ActionListener fieldListener) {
		textField.addActionListener(fieldListener);
	}
	
	protected void addFields() {
		textField = new JTextField();
		this.add(textField);
	}
	protected void clearInput(){
		textField.setText("");
	}
	public void setInput(String toSet) {
		textField.setText(toSet);
	}
	public String getInput() {
		return textField.getText();
	}
}
