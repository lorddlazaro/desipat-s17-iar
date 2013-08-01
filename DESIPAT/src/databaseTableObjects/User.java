package databaseTableObjects;



public class User extends TableEntry{
	private int userID;	
	private String username;
	private String password;
	private int clearance;
	private Person person;
	
	public User(int userID, String username, String password, int clearance){
		 this.userID = userID;
		 this.username = username;
		 this.password = password;
		 this.clearance = clearance;
	 }

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClearance() {
		return clearance;
	}
	public void setClearance(int clearance) {
		this.clearance = clearance;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
