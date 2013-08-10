package statements.insertNew;

import dataObjects.Asset;
import statements.InsertStrategy;

public class NewAsset extends InsertStrategy {
	public NewAsset(Asset a) {
		
		super("Asset",
				"name, ownerID, custodianID, typeID, maintID, classID, storageID, periodID, dateAcquired, financialValue," +
				" confidentialValue, integrityValue, availabilityValue",
				"'" + a.getName() + "', " + a.getOwnerID() + ", "+a.getCustodianID()+", " + a.getTypeID() + ", " + a.getMaintID() + ", " + 
				a.getClassID() + ", " + a.getStorageID() + ", " + a.getPeriodID() + ", " + a.getDateAcquired() + ", " + 
				a.getFinancialValue() + ", " + a.getConfidentialValue() + ", " + a.getIntegrityValue() + ", " + 
				a.getAvailabilityValue());
		System.out.println(a.getTypeID());
	}
}
