package statementStrategies;

import dbHandler.Query;

// done
public abstract class SelectLookUpStrategy extends Query {
	public SelectLookUpStrategy (String tableName, String condition)	{
		query = "SELECT ID FROM " + tableName + " WHERE " + condition + ";";
	}
}

// add subclasses
class LookUpMaintenance extends SelectLookUpStrategy {
	public LookUpMaintenance (String maint) {
		super("MaintenanceLookUp", "maintSched = " + maint);
	}
}

class LookUpType extends SelectLookUpStrategy {
	public LookUpType (String type) {
		super("TypeLookUp", "type = " + type);
	}
}

class LookUpClassification extends SelectLookUpStrategy {
	public LookUpClassification (String classification) {
		super("ClassificationLookUp", "classification = " + classification);
	}
}

class LookUpClearance extends SelectLookUpStrategy {
	public LookUpClearance (String clearance) {
		super("ClearanceLookUp", "clearanceLevel = " + clearance);
	}
}