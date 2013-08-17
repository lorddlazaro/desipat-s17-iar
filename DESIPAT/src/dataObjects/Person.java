package dataObjects;

import java.util.ArrayList;

public class Person extends TableEntry{
	public final static int FIRSTNAME_INDEX = 1;
	public final static int MIDDLEINITIAL_INDEX = 2;
	public final static int LASTNAME_INDEX = 3;
	
	private String firstName;
	private char middleInitial;
	private String lastName;
	
	public Person(int ID, String firstName, char middleInitial, String lastName){
		 setID(ID);
		 setFirstName(firstName);
		 setMiddleInitial(middleInitial);
		 setLastName(lastName);
	 }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInit) {
		this.middleInitial = middleInit;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<String> getValues() {
		if(values == null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getFirstName());
			values.add(String.valueOf(getMiddleInitial()));
			values.add(getLastName());//values.add(getFirstName());
		}
		if (values.size() != 4) {
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getFirstName());
			values.add(String.valueOf(getMiddleInitial()));
			values.add(getLastName());//values.add(getFirstName());
		}
		return values;
	}
	public String getName()
	{
		return firstName+" "+middleInitial+" "+lastName;
	}
}
