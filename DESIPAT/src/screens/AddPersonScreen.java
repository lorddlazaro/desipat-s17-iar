package screens;

import dataObjects.Person;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataObjects.PersonTable;


import screenBehaviourStrategy.AddPersonScreenBehaviour;
import screenBehaviourStrategy.AddPersonScreenBehaviourStrategy;

public class AddPersonScreen extends JPanel{
	
	AddPersonScreenBehaviourStrategy behaviour;
	
	JLabel firstNameLbl;
	JLabel middleInitialLbl;
	JLabel lastNameLbl;
	
	JTextField firstNameTxtFld;
	JTextField middleInitialTxtFld;
	JTextField lastNameTxtFld;
	
	JButton saveBtn;
	JButton cancelBtn;
	
	public AddPersonScreen(AddPersonScreenBehaviour behaviour){
		this.behaviour = behaviour;
		initComponents();
	}
	
	public void initComponents(){
		
		this.setLayout(new GridLayout(0,2));
		
		firstNameLbl = new JLabel("First Name: ");
		add(firstNameLbl);
		firstNameTxtFld = new JTextField();
		add(firstNameTxtFld);
		
		middleInitialLbl = new JLabel("Middle Initial: ");
		add(middleInitialLbl);
		middleInitialTxtFld = new JTextField();
		add(middleInitialTxtFld);
		
		lastNameLbl = new JLabel("Last Name:");
		add(lastNameLbl);
		lastNameTxtFld = new JTextField();
		add(lastNameTxtFld);
		
		cancelBtn = new JButton("Cancel");
		add(cancelBtn);
		saveBtn = new JButton("Save");
		add(saveBtn);
		
		this.setName("Add Person");
		//this.setSize(200,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(447, 248, 315, 137);
		this.setVisible(true);
	}
	
	public JTextField getFirstNameTF() {
		return firstNameTxtFld;
	}
	
	public JTextField getMiddleInitialTF() {
		return middleInitialTxtFld;
	}
	
	public JTextField getLastNameTF() {
		return lastNameTxtFld;
	}
	
	public void addCancelButtonActionListener(ActionListener al){
		cancelBtn.addActionListener(al);
	}
	
	public void addSaveButtonActionListener(ActionListener al){
		saveBtn.addActionListener(al);
	}
	

}
