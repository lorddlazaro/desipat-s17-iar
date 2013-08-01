package statements.lookUp;

import statementStrategies.SelectLookUpStrategy;

public class LookUpClassification extends SelectLookUpStrategy {
	public LookUpClassification (String classification) {
		super("ClassificationLookUp", "classification = " + classification);
	}
}
