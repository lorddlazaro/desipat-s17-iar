package statements.lookUp;

import statements.SelectLookUpStrategy;

public class LookUpType extends SelectLookUpStrategy {
	public LookUpType (String type) {
		super("TypeLookUp", "type = " + type);
	}
}
