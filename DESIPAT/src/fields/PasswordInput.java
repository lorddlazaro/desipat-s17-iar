package fields;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;


public class PasswordInput extends AbstractInputField{
	JPasswordField passwordField;
	
	public PasswordInput(String name) {
		super(name);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 16));
		passwordField.setColumns(10);
	}

	public void setListener(ActionListener myListener) {
		passwordField.addActionListener(myListener);
	}
	
	protected void addFields() {
		passwordField = new JPasswordField();
		this.add(passwordField);
	}
	protected void clearInput() {
		passwordField.setText("");
	}
	public void setInput(String toSet) {
		passwordField.setText(toSet);
	}
	public String getInput() {
		return String.copyValueOf(passwordField.getPassword());
	}
}
