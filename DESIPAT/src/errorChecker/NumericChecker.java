package errorChecker;

import fields.AbstractInputField;

public class NumericChecker extends ValidCharsCheckerDecorator {
	
	public NumericChecker(ValidCharsChecker checker) {
		super(checker);
	}
	
	public String getValidChars(){
		return super.getValidChars() + "0123456789";
	}
}
