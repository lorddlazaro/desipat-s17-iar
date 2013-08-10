package statements.insertNew;

import dataObjects.Storage;
import statements.InsertStrategy;

public class NewStorage extends InsertStrategy {
	public NewStorage(Storage s) {
		super("Storage", 
				"storageLocation",
				"'"+s.getStorageLocation()+"'");
	}
}
