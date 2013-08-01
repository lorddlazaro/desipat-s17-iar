package statements.insertNew;

import dataObjects.Person;
import statements.InsertStrategy;

public class NewPerson extends InsertStrategy{
	public NewPerson(Person p) {
		super("Person", 
				"firstname, middleinitial, lastname",
				"'" + p.getFirstName() + "', '" + p.getMiddleInitial() + "', '" + p.getLastName() + "'");
	}
}
