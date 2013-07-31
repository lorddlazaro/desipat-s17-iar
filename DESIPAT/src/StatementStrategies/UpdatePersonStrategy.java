package StatementStrategies;

import DataClasses.Person;

public class UpdatePersonStrategy implements UpdateStrategy {
	private String statement;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private int personID;

	public UpdatePersonStrategy(Person person)
	{
		firstName=person.getFirstName();
		middleInitial=person.getMiddleInit()+"";
		lastName=person.getLastName();
		personID=person.getPersonID();
	}
	public String getStatement() {
		statement="UPDATE Person SET firstName = '" + firstName + "', middleInitial = '" + ((middleInitial.length() == 0)? "" : middleInitial.charAt(0)) + "', lastName = '" + lastName + "' WHERE personID = " + personID + ";";
	 return statement;
		
	}

}
