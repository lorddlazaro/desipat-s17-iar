package StatementStrategies;

public class SelectAssetStrategy implements SelectStrategy {
	private String statement;
	private String condition;//use decorators to change the WHERE and ORDER BY clauses
	private int assetID;
	public SelectAssetStrategy(int assetID)
	{
		this.assetID=assetID;
	}
	@Override
	public String getStatement() {
		statement="select identifier, name, Concat(P.firstName, ' ',P.middleInitial,'. ', P.lastName) as owner, Concat(C.firstName, ' ',C.middleInitial,'. ', C.lastName) as custodian, type,dateAcquired,status, M.maintSched,  financialValue, confidentialValue,integrityValue,availabilityValue, L.classification, S.storageLocation from asset A inner join person P on P.personID=A.ownerID inner join person C on C.personID=A.custodianID inner join typelookup T on T.typeID=A.typeID inner join maintenancelookup M on M.maintID=A.maintID inner join classificationlookup L on L.classID=A.classID inner join storage S on S.storageID=A.storageID where identifier="+assetID;
		return statement;
		/*
		 * Short statement (for setting up table?)
		 * "select identifier,name from asset;";
		 */
	}

}
