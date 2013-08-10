package screenBehaviourStrategy;

import dataObjects.Storage;

public interface AddStorageScreenBehaviorStrategy {
	public void cancel();
	public void saveStorage(Storage s);
}
