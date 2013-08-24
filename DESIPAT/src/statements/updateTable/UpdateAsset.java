package statements.updateTable;

import java.util.ArrayList;

import statements.UpdateStrategy;

public class UpdateAsset extends UpdateStrategy{

	public UpdateAsset(ArrayList<String> values, int toUpdate) {
		super("Asset", values, "identifier = " + toUpdate);
	}

	public void populateColumns() {
		columns.add("name");
		columns.add("ownerID");
		columns.add("custodianID");
		columns.add("typeID");
		columns.add("maintID");
		columns.add("classID");
		columns.add("storageID");
		columns.add("periodID");
		columns.add("dateAcquired");
		columns.add("financialValue");
		columns.add("confidentialValue");
		columns.add("integrityValue");
		columns.add("availabilityValue");
	}
}
