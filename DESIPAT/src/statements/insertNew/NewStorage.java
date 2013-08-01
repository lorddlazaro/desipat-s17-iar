package statements.insertNew;

import dataClasses.StorageLocation;

public class NewStorage extends InsertStrategy {
	public NewStorage(StorageLocation s) {
		super("Storage", 
				"storageLocation",
				s.getLocation());
	}
}
