package errorChecker;

import java.util.StringTokenizer;

public class FormAssetValidator {

	public String getErrorWithAssetName(String assetName){
		ValidLengthAndCharChecker nameChecker = new ValidLengthAndCharChecker(ValidLengthAndCharChecker.NAME, 50);
		
		String errorMsg = nameChecker.getErrorMsg(assetName);
		
		if(errorMsg.isEmpty())
			return "";
		
		return nameChecker.getErrorMsg(assetName)+" for Asset Name.\n";
	}
	
	public String getErrorWithFinancialVal(Double val){
		if(val != null)
			return "";
		
		return "Financial Value should be a floating point number.";
	}
	
	public String getErrorWithNewPerson(String name){
		if(!name.matches("\\w+[ ]+\\w[.][ ]+\\w+"))
			return "Please type the name in the format: <First Name> <Middle Initial>. <Last Name>. Use letters only for the names.";
		
		StringTokenizer tokenizer = new StringTokenizer(name, " .");
		if(tokenizer.nextToken().length() > 50 || tokenizer.nextToken().length() > 1 || tokenizer.nextToken().length() > 50)
			return "Max of 50 characters for first and last name. One character only for middle initial.";
		
		return "";
	}
	
}
