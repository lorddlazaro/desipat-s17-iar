package statements;

public class DeleteUser extends DeleteStrategy {
	public DeleteUser(int userID) {
		super("UserAccount", "userID = " + userID);
	}
}
