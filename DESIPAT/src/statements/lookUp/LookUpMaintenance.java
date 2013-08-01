package statements.lookUp;

import statements.SelectLookUpStrategy;

public class LookUpMaintenance extends SelectLookUpStrategy {
	public LookUpMaintenance (String maint) {
		super("MaintenanceLookUp", "maintSched = " + maint);
	}
}
