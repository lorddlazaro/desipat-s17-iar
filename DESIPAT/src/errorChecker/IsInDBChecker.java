package errorChecker;

import fields.AbstractInputField;

public class IsInDBChecker extends ValidCharsCheckerDecorator {
	
	public IsInDBChecker(ValidCharsChecker checker, AbstractInputField field) {
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
