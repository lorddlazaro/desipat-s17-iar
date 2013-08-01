package errorChecker;

import inputFields.InputField;

public class PasswordChecker extends ErrorCheckerDecorator {
	
	public PasswordChecker(InputField field) {
		super(field);
		checker=new AlphanumericChecker(field);
		// TODO Auto-generated constructor stub
	}
	public String getErrorMessage()
	{
		if(passwordMatchesDB()==false)
			return "Wrong password";
		else return checker.getErrorMessage();
	}
	public boolean passwordMatchesDB()
	{
		String input=field.getInput();
		/*if(select statement turns up nothing matching input)
		 * 
		 */
		return false;
	}
}
