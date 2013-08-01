package databaseTableObjects;

import java.util.ArrayList;

public class UserAccount extends TableEntry{
	public final static int ID_INDEX = 0;
	public final static int USERNAME_INDEX = 1;
	public final static int PASSWORD_INDEX = 2;
	public final static int CLEARANCEID_INDEX = 3;
	public final static int PERSONID_INDEX = 4;
	
	private String username;
	private String password;
	private int clearanceID;
	private int personID;

	private ArrayList<String> values;
	
	
	public UserAccount(int userID, String username, String password, int clearanceID, int personID){
		 setID(userID);
		 setUsername(username);
		 setPassword(password);
		 setClearanceID(clearanceID);
		 setPersonID(personID);
		 
		 values.add(String.valueOf(ID));
		 values.add(username);
		 values.add(password);
		 values.add(String.valueOf(clearanceID));
		 values.add(String.valueOf(personID));
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
	public int getClearanceID() {
		return clearanceID;
	}
	public void setClearanceID(int clearanceID) {
		this.clearanceID = clearanceID;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	public ArrayList<String> getValues() {
		return values;
	}
}