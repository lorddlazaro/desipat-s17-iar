package screenBehaviourStrategy;

import dataObjects.Person;


public interface AddPersonScreenBehaviourStrategy {
	public void cancel();
	public void savePerson(Person p);
}
