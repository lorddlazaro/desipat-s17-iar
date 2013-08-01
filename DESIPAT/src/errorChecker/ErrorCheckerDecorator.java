package errorChecker;

import inputFields.InputField;

public abstract class ErrorCheckerDecorator extends ErrorChecker {
	protected ErrorChecker checker;
	public ErrorCheckerDecorator(ErrorChecker checker, InputField field) {
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
