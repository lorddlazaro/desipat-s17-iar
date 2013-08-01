package statements;

public class SelectFromPerson extends SelectFromIDStrategy {
	public SelectFromPerson(int personID) {
		super("Person", "assetID = " + personID);
	}
}	
