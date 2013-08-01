package errorChecker;

import inputFields.InputField;

public class IsInDBChecker extends ErrorCheckerDecorator {
	
	public IsInDBChecker(ErrorChecker checker, InputField field) {
		super(checker, field);
		// TODO Auto-generated constructor stub
	}
	public String getErrorMessage()
	{
		if(inputMatchesDB()==false)
			return "Wrong password";
		else return checker.getErrorMessage();
	}
	public boolean inputMatchesDB()
	{
		String input=field.getInput();
		/*if(select statement turns up nothing matching input)
		 * 
		 */
		return false;
	}
}
