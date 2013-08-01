package statements.lookUp;

import statementStrategies.SelectLookUpStrategy;

public class LookUpMaintenance extends SelectLookUpStrategy {
	public LookUpMaintenance (String maint) {
		super("MaintenanceLookUp", "maintSched = " + maint);
	}
}
