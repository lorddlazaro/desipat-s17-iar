package statements.insertNew;

import databaseTableObjects.Person;
import statements.InsertStrategy;

public class NewPerson extends InsertStrategy{
	public NewPerson(Person p) {
		super("Person", 
				"firstname, middleinitial, lastname",
				"'" + p.getFirstName() + "', '" + p.getMiddleInit() + "', '" + p.getLastName() + "'");
	}
}
