package errorChecker;

import fields.AbstractInputField;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public abstract class ValidCharsChecker{

	public abstract String getValidChars();
	
	public boolean isInputValid(String input){
		if(input.trim().matches("["+getValidChars()+"]+"))
			return true;
		return false;
	}
	
}
