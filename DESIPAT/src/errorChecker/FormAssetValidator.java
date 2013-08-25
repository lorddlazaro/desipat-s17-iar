package errorChecker;

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
	
}
