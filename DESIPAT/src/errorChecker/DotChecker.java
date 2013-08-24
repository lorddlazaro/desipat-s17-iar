package errorChecker;

public class DotChecker extends ValidCharsCheckerDecorator{

	public DotChecker(ValidCharsChecker decoratee){
		super(decoratee);
	}
	
	public String getValidChars(){
		return super.getValidChars()+".";
	}
}
