package errorChecker;

import fields.AbstractInputField;

public class NameChecker extends ErrorCheckerDecorator {
	
	public NameChecker(ErrorChecker checker, AbstractInputField field) {
		
		super(checker, field);
		
		// TODO Auto-generated constructor stub
	}
	public String getErrorMessage(){
		if(containsOnlyLetters()==false)
			return "Names can only contain letters.";
		else return checker.getErrorMessage();
	}
	public boolean containsOnlyLetters()
	{	
		boolean contFlag=true;
		String input=field.getInput();
		for (int i = 0; i < input.length() && contFlag; i++) {
			if (!((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) == ' ')))
				contFlag = false;
		}
		
		if(contFlag==true)
			return true;
		else
			return false;
	}
}
