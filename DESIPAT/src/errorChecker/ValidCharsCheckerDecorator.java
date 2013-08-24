package errorChecker;

import fields.AbstractInputField;

public abstract class ValidCharsCheckerDecorator extends ValidCharsChecker {
	
	protected ValidCharsChecker decoratee;
	
	protected ValidCharsCheckerDecorator(ValidCharsChecker decoratee){
		this.decoratee = decoratee;
	}
		
	public String getValidChars(){
		return decoratee.getValidChars();
	}
}
