package statementStrategies;

public class SelectFromUser extends SelectFromIDStrategy {
	public SelectFromUser(int userID) {
		super("UserAccount", "userID =" + userID);
	}
}
