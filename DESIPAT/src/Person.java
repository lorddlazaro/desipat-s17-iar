public class Person {
	
	private int personID;
	private String firstName;
	private char middleInit;
	private String lastName;
	
	private int getPersonID() {
		return personID;
	}
	private void setPersonID(int personID) {
		this.personID = personID;
	}
	private String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private char getMiddleInit() {
		return middleInit;
	}
	private void setMiddleInit(char middleInit) {
		this.middleInit = middleInit;
	}
	private String getLastName() {
		return lastName;
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
