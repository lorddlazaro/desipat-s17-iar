package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import databaseTableObjects.Person;


import screenBehaviourStrategy.AddPersonScreenBehaviour;
import screenBehaviourStrategy.AddPersonScreenBehaviourStrategy;

public class AddPersonScreen extends JFrame{
	
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
		
		this.getContentPane().setLayout(new GridLayout(0,2));
		
		firstNameLbl = new JLabel("First Name: ");
		add(firstNameLbl);
		firstNameTxtFld = new JTextField();
		add(firstNameTxtFld);
		
		middleInitialLbl = new JLabel("Middle Initial: ");
		add(middleInitialLbl);
		middleInitialTxtFld = new JTextField();
		middleInitialTxtFld.
		add(middleInitialTxtFld);
		
		lastNameLbl = new JLabel("Last Name:");
		add(lastNameLbl);
		lastNameTxtFld = new JTextField();
		add(lastNameTxtFld);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				behaviour.cancel();
			}});
		add(cancelBtn);
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//NEED VALIDATION either on person constructor or here
				Person p = new Person(-1,firstNameTxtFld.getText(),middleInitialTxtFld.getText().charAt(0),lastNameTxtFld.getText());
				behaviour.savePerson(p);
				
			}});
		add(saveBtn);
		
		this.setTitle("Add Person");
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

}