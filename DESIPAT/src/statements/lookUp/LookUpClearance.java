package statements.lookUp;

import statements.SelectLookUpStrategy;

public class LookUpClearance extends SelectLookUpStrategy {
	public LookUpClearance (String clearance) {
		super("ClearanceLookUp", "clearanceLevel = " + clearance);
	}
}