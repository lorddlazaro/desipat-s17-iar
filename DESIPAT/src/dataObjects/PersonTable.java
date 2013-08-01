package dataObjects;

import java.util.ArrayList;

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
	
	private static PersonTable instance;
	
	public static PersonTable getInstance(){
		if(instance == null){
			instance = new PersonTable();
		}
		return instance;
	}
	
	protected PersonTable(){
		personList = new ArrayList<Person>();
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(FIRSTNAME_COLUMN_NAME);
		columnNames.add(MIDDLEINITIAL_COLUMN_NAME);
		columnNames.add(LASTNAME_COLUMN_NAME);

	}
	public void addEntry(TableEntry tableEntry){
		Person person = (Person)tableEntry;
		entryList.add(tableEntry);
		NonQuery statement = new NewPerson(person);
		statement.executeStatement();
	}
	//TODO: edit entry
	public void editEntry(TableEntry tableEntry){}	
	public void deleteEntry(TableEntry tableEntry){
		/*Person person = (Person)tableEntry;
		NonQuery statement = new DeletePerson(person.getID());
		statement.executeStatement();*/
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

}
