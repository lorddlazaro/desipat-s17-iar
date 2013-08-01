package databaseTableObjects;
import java.util.ArrayList;

public abstract class TableSubject {
	private ArrayList<TableObserver> observerList;
	private ArrayList<TableEntry> entryList;
	
	public void registerObserver(TableObserver observer){
		observerList.add(observer);
	}
	public void unregisterObserver(TableObserver observer){
		observerList.add(observer);
	}
	public void notifyObservers(){
		for(TableObserver observer: observerList)
			observer.refresh();
	}	
	
	public abstract void addEntry(TableEntry tableEntry);
	public abstract void deleteEntry(TableEntry tableEntry);
	public abstract ArrayList<TableEntry> getAllEntries();
	public abstract TableEntry getEntry(int key);
}
