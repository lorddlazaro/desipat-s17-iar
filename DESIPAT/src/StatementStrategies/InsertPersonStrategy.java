package StatementStrategies;

import DataClasses.Person;
import DataClasses.User;

public class InsertPersonStrategy extends InsertStrategy {
	private String statement="";
	private String firstName;
	private char middleInitial;
	private String lastName;
	
	public InsertPersonStrategy(Person person)
	{
		firstName=person.getFirstName();
		middleInitial=person.getMiddleInit();
		lastName=person.getLastName();
	}
	public String getStatement() {
		statement= "INSERT INTO Person(firstname,middleinitial,lastname) values ('"+firstName+"','"+middleInitial+"','"+lastName+"');";
		return statement;
	}

}
