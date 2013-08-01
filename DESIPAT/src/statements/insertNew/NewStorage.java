package statements.insertNew;

import databaseTableObjects.StorageLocation;
import statements.InsertStrategy;

public class NewStorage extends InsertStrategy {
	public NewStorage(StorageLocation s) {
		super("Storage", 
				"storageLocation",
				s.getLocation());
	}
}
