package errorChecker;

public class ValidLengthAndCharChecker{

	private String validChars;
	private int validLength;
	
	public static final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBER = "1234567890";
	public static final String ALPHABET = LOWER_ALPHABET+UPPER_ALPHABET;
	public static final String ALPHANUMERIC = ALPHABET+NUMBER;
	public static final String FLOATING_POINT = NUMBER+".";
	public static final String NAME = ALPHABET+" ";
	
	private final String ERROR_INVALID_CHARS = "Only the following chars are allowed:\n";
	private final String ERROR_INVALID_LENGTH = "Invalid Length"; 
	
	
	public ValidLengthAndCharChecker(String validChars, int validLength){
		this.validChars = validChars;
		this.validLength = validLength;
	}
	
	private boolean areCharsValid(String toCheck){
		for(int i=0;i<toCheck.length();i++)
			if(validChars.indexOf(toCheck.charAt(i)) < 0)
				return false;
		return true;
	}

	
	private boolean isLengthValid(String toCheck){
		if(toCheck.length() == 0 || toCheck.length() > validLength)
			return false;
		return true;
	}
	
	public String getErrorMsg(String toCheck) {
		String errorMsg = "";
		
		if(!isLengthValid(toCheck))
			errorMsg += ERROR_INVALID_LENGTH;
		
		if(!areCharsValid(toCheck)){
			if(!errorMsg.equals(""))
				errorMsg+="\n";
			errorMsg += ERROR_INVALID_CHARS + validChars;
		}
		return errorMsg;
	}

}
