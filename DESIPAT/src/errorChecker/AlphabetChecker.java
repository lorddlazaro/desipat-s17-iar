package errorChecker;

import fields.AbstractInputField;

import java.awt.event.ActionEvent;

public class AlphabetChecker extends ValidCharsCheckerDecorator {
	
	public AlphabetChecker(ValidCharsChecker decoratee){
		super(decoratee);
	}
	
	public String getValidChars(){
		return super.getValidChars()+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	}
	
}
