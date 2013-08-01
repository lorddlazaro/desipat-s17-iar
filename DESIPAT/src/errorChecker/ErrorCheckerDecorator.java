package errorChecker;

import inputFields.InputField;

public abstract class ErrorCheckerDecorator extends ErrorChecker {
	protected ErrorChecker checker;
	public ErrorCheckerDecorator(InputField field) {
		super(field);
		checker.setField(field);
		// TODO Auto-generated constructor stub
	}
	
	public String getErrorMessage()
	{
		return checker.getErrorMessage();
	}
}
