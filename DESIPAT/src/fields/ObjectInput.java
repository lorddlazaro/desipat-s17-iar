package fields;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import screenBehaviourStrategy.AddPersonScreenBehaviour;


public class ObjectInput extends ComboBoxInput {

	protected JButton newButton;
	protected String newItemMessage;
	protected String textInput;
	
	public ObjectInput(String name, String newItemMessage) {
		super(name);
		this.newItemMessage = newItemMessage; 

		newButton.setFont(new Font("Calibri", Font.PLAIN, 13));
	}
	
	public ObjectInput(String name, String newItemMessage, Color buttonColor) {
		this(name, newItemMessage);
		newButton.setBackground(buttonColor);
	}

	
	protected void addFields() {
		comboBoxField = new JComboBox<String>();
		this.add(comboBoxField);
		newButton = new JButton("new");
		newButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				textInput = JOptionPane.showInputDialog (newItemMessage); 
			}
			public String toString(){
				return "base";
			}
		}) ;
		newButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				textInput = JOptionPane.showInputDialog (newItemMessage+"Tomatoe"); 
			}
			public String toString(){
				return "second";
			}
		}) ;
		System.out.println(newButton.getActionListeners()[0]);
		this.add(newButton);
	}
	
	public String getNewItemInput(){
		return textInput;
	}
}