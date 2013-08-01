package statements.insertNew;

import dataClasses.Asset;

// not done yet
public class NewAsset extends InsertStrategy {
	public NewAsset(Asset a) {
		super("Asset",
				"name, ownerID, custodianID, typeID, maintID, classID, storageID, periodID, dateAcquired, financialValue," +
				" confidentialValue, integrityValue, availabilityValue",
				"'" + a.getName() + "', " + a.getOwnerID() + ", " + a.getTypeID() + ", " + a.getMaintID() + ", " + 
				a.getClass() + ", " + a.getStorageID() + ", " + a.getPeriodID() + ", " + a.getDateAcquired() + ", " + 
				a.getFinancialValue() + ", " + a.getConfidentialValue() + ", " + a.getIntegrityValue() + ", " + 
				a.getAvailabilityValue());
	}
}
