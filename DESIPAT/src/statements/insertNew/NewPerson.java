package statements.insertNew;

import dataClasses.Person;

public class NewPerson extends InsertStrategy{
	public NewPerson(Person p) {
		super("Person", 
				"firstname, middleinitial, lastname",
				"'" + p.getFirstName() + "', '" + p.getMiddleInit() + "', '" + p.getLastName() + "'");
	}
}
