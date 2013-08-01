package errorChecker;

import inputFields.InputField;

import java.awt.event.ActionEvent;

public class AlphanumericChecker extends ErrorCheckerDecorator {
	
	public AlphanumericChecker(ErrorChecker checker, InputField field) {
		super(checker, field);
		
	}
	public String getErrorMessage(){
		if(fieldIsBlank())
			return "Field must not be blank";
		else return "";
	}
	public boolean fieldIsBlank()
	{
		if(field.getInput()=="")
			return true;
		else return false;
	}
}
