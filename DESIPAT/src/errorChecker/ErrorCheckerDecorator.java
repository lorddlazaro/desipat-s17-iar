package errorChecker;

import fields.AbstractInputField;

public abstract class ErrorCheckerDecorator extends ErrorChecker {
	protected ErrorChecker checker;
	public ErrorCheckerDecorator(ErrorChecker checker, AbstractInputField field) {
		super(field);
		this.checker=checker;
		checker.setField(field);
		// TODO Auto-generated constructor stub
	}
	
	public String getErrorMessage()
	{
		return checker.getErrorMessage();
	}
}
