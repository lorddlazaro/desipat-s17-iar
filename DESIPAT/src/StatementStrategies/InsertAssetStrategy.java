package StatementStrategies;

import DataClasses.Asset;



public class InsertAssetStrategy extends InsertStrategy {
	private String statement;
	
	private String assetName;
	private String ownerID = "";
	private String custodianID = "";
	private String typeID = "";
	private String maintID = "";
	private String classID = "";
	private String storageID = "";
	private String dateAcquired;
	
	/*private String ownerFirstName;
	private String ownerMiddleInitial;
	private String ownerLastName;

	private String custodianFirstName;
	private String custodianMiddleInitial;
	private String custodianLastName;*/
	
	private int status;
	private int valueIntegrity;
	private int valueConfidentiality;
	private float valueFinancial;
	private int valueAvailability;
	
	public InsertAssetStrategy(Asset asset)
	{
		assetName=asset.getName();
		ownerID=asset.getOwnerID() + "";
		custodianID=asset.getCustodianID()+"";
		typeID=asset.getType()+"";
		maintID=asset.getMaintenanceSchedule()+"";
		classID=asset.getClassification()+"";
		storageID=asset.getStorageID()+"";
		dateAcquired=asset.getDateAcquired();
		
		/*ownerFirstName=asset.getOwnerFirstName();
		ownerMiddleInitial=asset.getOwnerMiddleInitial();
		ownerLastName=asset.getOwnerLastName();
		
		custodianFirstName=asset.getCustodianFirstName();
		custodianMiddleInitial=asset.getCustodianMiddleInitial();
		custodianLastName=asset.getCustodianLastName();*/
	
		status=asset.getStatus();
		valueIntegrity= asset.getValueIntegrity();
		valueConfidentiality=asset.getValueConfidentiality();
		valueFinancial=asset.getValueFinancial();
		valueAvailability=asset.getValueAvailability();
		
	}
	public String getStatement() {
		statement = "INSERT INTO Asset(name,ownerID,custodianID,typeID,dateAcquired,status" +
				",maintID,financialValue,confidentialValue,integrityValue,availabilityValue,classID,storageID)" +
				" values ('" +assetName+ "','"+ ownerID +"','"+ custodianID +"','"+
				typeID +"','"+ dateAcquired +"','"+ status +"','"+maintID +"','"+
				valueFinancial +"','"+ valueConfidentiality +"','"+ valueIntegrity +"','"+
				valueAvailability +"','"+ classID +"','"+ storageID + "');";
		return statement;
		
	}

}
