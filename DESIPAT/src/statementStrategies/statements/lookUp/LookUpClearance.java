package statements.lookUp;

import statementStrategies.SelectLookUpStrategy;

public class LookUpClearance extends SelectLookUpStrategy {
	public LookUpClearance (String clearance) {
		super("ClearanceLookUp", "clearanceLevel = " + clearance);
	}
}