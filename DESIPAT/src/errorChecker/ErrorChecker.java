package errorChecker;

import fields.AbstractInputField;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class ErrorChecker /*implements ActionListener*/{
	//private String errorMessage="";
	protected AbstractInputField field;
	public ErrorChecker(AbstractInputField field)
	{
		this.field=field;
	}
	/*
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		checkIfValid(arg0);
	}*/
	public String getErrorMessage(/*ActionEvent arg0*/){
		return "";
	}
	public void setField(AbstractInputField field)
	{
		this.field=field;
	}
	
}
