package statements.lookUp;

import statements.SelectLookUpStrategy;

public class LookUpClassification extends SelectLookUpStrategy {
	public LookUpClassification (String classification) {
		super("ClassificationLookUp", "classification = " + classification);
	}
}
