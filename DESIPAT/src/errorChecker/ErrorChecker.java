package errorChecker;

import inputFields.InputField;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class ErrorChecker /*implements ActionListener*/{
	//private String errorMessage="";
	protected InputField field;
	public ErrorChecker(InputField field)
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
	public void setField(InputField field)
	{
		this.field=field;
	}
	
}
