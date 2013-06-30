import java.sql.Connection;;

public class ActionLogger {
/*
Actions

Type 			Description
Log In			Logged in
Log Out			Logged out

Edit Account	Changed username
				Changed password
				Corrected name
				Changed clearance level
Delete Account	Deleted account <username>
Create Account	Created account <username>

Added Asset		Added Asset <assetname> to registry
Updated Asset	Updated <assetname>'s <field> to <newvalue>
				
 */
	private class Header{
	static final int LogIn = 1;
	static final int LogOut = 2;
	
	static final int EditAccount = 3;
	static final int DeleteAccount = 4;
	static final int CreateAccount = 5;
	
	static final int AddAsset = 6;
	static final int UpdateAsset = 7;
	}
	
	private static void insertToDatabase(String queryPart){
		DBConnection DBcon = new DBConnection();
		Connection con = DBcon.open();
		String query = "insert into actionlog(actionDate,actionTime,userid,actionHeaderID,actionDesc) values (Date(Now()),Time(Now()),";
		query += queryPart + ");";
// TEMPORARY PRINTLINE THING
		System.out.println(query);
		DBcon.executeUpdate(con, query);
		DBcon.close();
	}
	
	// 'userid','actionHeader','actionDesc'
	public static void loggedIn(int userID){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.LogIn + "', 'Logged in'";
		insertToDatabase(queryPart);
	}
	public static void loggedOut(int userID){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.LogOut + "', 'Logged out'";
		insertToDatabase(queryPart);
	}
	public static void editedAccountUsername(int userID){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.EditAccount + "', 'Changed username'";
		insertToDatabase(queryPart);
	}
	public static void editedAccountPassword(int userID){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.EditAccount + "', 'Changed password'";
		insertToDatabase(queryPart);
	}
	public static void editedAccountName(int userID){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.EditAccount + "', 'Corrected name'";
		insertToDatabase(queryPart);
	}
	public static void editedAccountClearance(int userID){		
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.EditAccount + "', 'Changed clearance level'";
		insertToDatabase(queryPart);
	}
	public static void deletedAccount(int userID, String username){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.DeleteAccount + "', 'Deleted account " + username + "'";
		insertToDatabase(queryPart);
	}
	public static void createdAccount(int userID, String username){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.CreateAccount + "', 'Created account " + username + "'";
		insertToDatabase(queryPart);
	}
	public static void addedAsset(int userID, String assetname){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.AddAsset + "', 'Added asset " + assetname + " to registry'";
		insertToDatabase(queryPart);
	}
	public static void updatedAssetField(int userID, String assetname, String field,String newvalue){
		String queryPart = "'" + userID + "', ";
		queryPart += "'" + Header.UpdateAsset + "', 'Updated " + assetname + "'s " + field + " to " + newvalue + "'";
		insertToDatabase(queryPart);
	}
}
