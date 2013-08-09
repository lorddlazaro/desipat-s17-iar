package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewPerson;
import statements.insertNew.NewUser;

public class PersonTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "personID";
	public final static String FIRSTNAME_COLUMN_NAME = "firstName";
	public final static String MIDDLEINITIAL_COLUMN_NAME = "middleInitial";
	public final static String LASTNAME_COLUMN_NAME = "lastName";

	private ArrayList<Person> personList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static PersonTable instance;
		
	public static PersonTable getInstance(){
		if(instance == null){
			instance = new PersonTable();
		}
		return instance;
	}
	
	protected PersonTable(){
		observerList = new ArrayList<TableObserver>();
		
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(FIRSTNAME_COLUMN_NAME);
		columnNames.add(MIDDLEINITIAL_COLUMN_NAME);
		columnNames.add(LASTNAME_COLUMN_NAME);
		
		personList = new ArrayList<Person>();
		fillData();
	}
	
	private void fillData(){
		// TODO
	}
	
	public void addEntry(TableEntry tableEntry){
		Person person = (Person)tableEntry;
		NonQuery statement = new NewPerson(person);
		statement.executeStatement();
	}
	
	public void editEntry(TableEntry tableEntry){
		//TODO
	}	
	
	public void deleteEntry(TableEntry tableEntry){
		//TODO
		/*Person person = (Person)tableEntry;
		NonQuery statement = new DeletePerson(person.getID());
		statement.executeStatement();*/
	}
	
	public ArrayList<Person> getAllEntries() {
		return personList;
	}

	public Person getEntry(int ID) {
		for(Person person:personList)
			if(person.getID() == ID)
				return person;
		return null;
	}
}
