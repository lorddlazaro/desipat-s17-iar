package databaseTableObjects;
public class Person extends TableEntry{
	
	private int personID;
	private String firstName;
	private char middleInit;
	private String lastName;
	
	public Person(int personID, String firstName, char middleInit, String lastName){
		 this.personID = personID;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.middleInit = middleInit;
	 }
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInit() {
		return middleInit;
	}
	public void setMiddleInit(char middleInit) {
		this.middleInit = middleInit;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
