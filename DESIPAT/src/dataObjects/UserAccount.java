package dataObjects;

import java.util.ArrayList;

public class UserAccount extends TableEntry{
	public final static int USERNAME_INDEX = 1;
	public final static int PASSWORD_INDEX = 2;
	public final static int CLEARANCEID_INDEX = 3;
	public final static int PERSONID_INDEX = 4;
	
	private String username;
	private String password;
	private int clearanceID;
	private int personID;
	private int isActive;
	public UserAccount(int userID, String username, String password, int clearanceID, int personID, int isActive){
		 setID(userID);
		 setUsername(username);
		 setPassword(password);
		 setClearanceID(clearanceID);
		 setPersonID(personID);
		 setIsActive(isActive);
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
	public void setIsActive(int isActive){
		this.isActive = isActive;
	}
	public boolean isActive(){
		if(isActive == 1)
			return true;
		return false;
	}
	
	public int getIsActive(){
		return isActive;
	}
	public Clearance getClearance() {
		return ClearanceLookUpTable.getInstance().getEntry(clearanceID);
	}
	public String getPersonFirstName(){
		return PersonTable.getInstance().getEntry(this.personID).getFirstName();
	}
	public String getPersonMiddleName(){
		return PersonTable.getInstance().getEntry(this.personID).getMiddleInitial() + "";
	}
	public String getPersonLastName(){
		return PersonTable.getInstance().getEntry(this.personID).getLastName();
	}
	
	public String getPersonName() {
		return getPersonFirstName() + " " + getPersonMiddleName() + ". " + getPersonLastName();
	}
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	public ArrayList<String> getValues() {
		if(values == null){
			values = new ArrayList<String>();
			values.add(String.valueOf(ID));
			values.add(username);
			values.add(password);
			values.add(String.valueOf(clearanceID));
			values.add(String.valueOf(personID));
		}
		else if(values.size() != 5){
			values = new ArrayList<String>();
			values.add(String.valueOf(ID));
			values.add(username);
			values.add(password);
			values.add(String.valueOf(clearanceID));
			values.add(String.valueOf(personID));
		}
		return values;
	}
}