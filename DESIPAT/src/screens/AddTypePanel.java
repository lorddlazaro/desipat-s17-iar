package screens;

import dataObjects.Person;
import dataObjects.Type;

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
import screenBehaviourStrategy.AddTypeScreenBehavior;
import screenBehaviourStrategy.AddTypeScreenBehaviorStrategy;

public class AddTypePanel extends JPanel{
	
	AddTypeScreenBehaviorStrategy behaviour;
	
	JLabel typeNameLbl;

	
	JTextField typeNameTxtFld;

	
	JButton saveBtn;
	JButton cancelBtn;
	
	public AddTypePanel(AddTypeScreenBehavior behaviour){
		this.behaviour = behaviour;
		initComponents();
	}
	
	public void initComponents(){
		
		this.setLayout(new GridLayout(0,2));
		
		typeNameLbl = new JLabel("New Type: ");
		add(typeNameLbl);
		typeNameTxtFld = new JTextField();
		add(typeNameTxtFld);
		

		
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
				/*Person p = new Person(-1,firstNameTxtFld.getText(),middleInitialTxtFld.getText().charAt(0),lastNameTxtFld.getText());
				behaviour.savePerson(p);*/
				Type t=new Type(-1,typeNameTxtFld.getText());
				behaviour.saveType(t);
				typeNameTxtFld.setText("");
				
			}});
		add(saveBtn);
		
		this.setName("Add Type");
		//this.setSize(200,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(447, 248, 315, 137);
		this.setVisible(true);
	}
	

}
