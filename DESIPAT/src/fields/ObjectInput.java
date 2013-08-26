package fields;

import java.awt.event.ActionListener;

public class ObjectInput extends ComboBoxInput {

	public ObjectInput(String name){
		super(name);
		
		comboBoxField.setEditable(true);
	}
		
	public void addNewButtonActionListener(ActionListener al){
		ActionListener[] list = comboBoxField.getActionListeners();
	
		for(int i = 0; i < list.length; i++)
			comboBoxField.removeActionListener(list[i]);
		
		comboBoxField.addActionListener(al);
		
		for(int i = list.length - 1; i >= 0; i--)
			comboBoxField.addActionListener(list[i]);
	}
}