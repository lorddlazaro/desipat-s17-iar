package statements.lookUp;

import statementStrategies.SelectLookUpStrategy;

public class LookUpType extends SelectLookUpStrategy {
	public LookUpType (String type) {
		super("TypeLookUp", "type = " + type);
	}
}
