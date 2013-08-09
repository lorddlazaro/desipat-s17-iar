package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;
import statements.insertNew.NewPerson;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllPersons;
import statements.updateTable.UpdateAsset;
import statements.updateTable.UpdatePerson;

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
		Query statement = new SelectAllPersons();
		statement.executeStatement();
		statement.getResultList();
	}
	
	public void addEntry(Person person){
		personList.add(person);
		NonQuery statement = new NewPerson(person);
		statement.executeStatement();
	}
	
	public void editEntry(Person person) {
		ArrayList<String> values = person.getValues();
		values.remove(this.ID_COLUMN_NAME);
		
		NonQuery statement = new UpdatePerson(values, person.getID());
		statement.executeStatement();
	}
	
	/* CANT DELETE 
	public void deleteEntry(Person person){
		personList.remove(person);
		
		NonQuery statement = new DeletePerson(person.getID());
		statement.executeStatement();
	}*/
	
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
