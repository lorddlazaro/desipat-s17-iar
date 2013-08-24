package screens;

import dataObjects.Person;
import dataObjects.Storage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataObjects.PersonTable;



import screenBehaviourStrategy.AddStorageScreenBehavior;
import screenBehaviourStrategy.AddStorageScreenBehaviorStrategy;

public class AddStoragePanel extends JPanel{
	
	AddStorageScreenBehaviorStrategy behaviour;
	
	JLabel locationLbl;

	
	JTextField txtStorageLocation;
	
	JButton saveBtn;
	JButton cancelBtn;
	
	public AddStoragePanel(AddStorageScreenBehavior behaviour){
		this.behaviour = behaviour;
		initComponents();
	}
	
	public void initComponents(){
		
		this.setLayout(new GridLayout(0,2));
		
		locationLbl = new JLabel("Storage location: ");
		add(locationLbl);
		txtStorageLocation = new JTextField();
		add(txtStorageLocation);
		
		cancelBtn = new JButton("Cancel");
		add(cancelBtn);
		
		saveBtn = new JButton("Save");
		add(saveBtn);
		
		this.setName("Add Storage Location");
		//this.setSize(200,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(447, 248, 315, 137);
		this.setVisible(true);
	}
	
	public JTextField getStorageLocationTF() {
		return txtStorageLocation;
	}
	
	public void addCancelButtonActionListener(ActionListener al){
		cancelBtn.addActionListener(al);
	}
	
	public void addSaveButtonActionListener(ActionListener al){
		saveBtn.addActionListener(al);
	}
	

}
