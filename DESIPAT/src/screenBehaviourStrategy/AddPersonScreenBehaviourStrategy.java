package screenBehaviourStrategy;

import databaseTableObjects.Person;


public interface AddPersonScreenBehaviourStrategy {
	public void cancel();
	public void savePerson(Person p);
}
