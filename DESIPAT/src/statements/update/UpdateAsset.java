package statements.update;

import java.util.ArrayList;

import dataObjects.Asset;
import statements.InsertStrategy;
import statements.UpdateStrategy;

public class UpdateAsset extends UpdateStrategy {
	static ArrayList<String>columns;
	public UpdateAsset(Asset a) {
		super("Asset", columns, a.getValues(), "name = "+a.getName());
		columns=new ArrayList<String>();
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
