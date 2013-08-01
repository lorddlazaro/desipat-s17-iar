package fields;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class InputField extends JPanel {
	protected JLabel fieldName;
	protected JLabel errorLabel;
	
	public InputField(String name) {
		fieldName = new JLabel();
		errorLabel = new JLabel();
		
		fieldName.setText(name);
		
		this.add(fieldName);
		this.addFields();
		this.add(errorLabel);
	}
	
	public abstract void addFields();
	public abstract void setInput(String toSet);
	public abstract String getInput();
}







