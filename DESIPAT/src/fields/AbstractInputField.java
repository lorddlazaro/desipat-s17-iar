package fields;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class AbstractInputField extends JPanel {
	protected JLabel fieldLabel;
	protected JLabel errorMessage;
	
	public AbstractInputField(String name) {
		fieldLabel = new JLabel();
		fieldLabel.setText(name);
		fieldLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		errorMessage = new JLabel();
		errorMessage.setFont(new Font("Calibri", Font.PLAIN, 12));
		errorMessage.setForeground(new Color(165,42,42));
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		this.setOpaque(false);
		this.add(fieldLabel);
		this.addFields();
		this.add(errorMessage);
	}

	public void setErrorMessage(String message){
		errorMessage.setText(message);
	}
	public String getErrorMessage(){
		return errorMessage.getText();
	}
	public void clearErrorMessage(){
		errorMessage.setText("");
	}
	public void clearField(){
		clearInput();
		errorMessage.setText("");
	}
	
	protected abstract void addFields();
	protected abstract void clearInput();
	public abstract void setInput(String toSet);
	public abstract String getInput();
	
}







