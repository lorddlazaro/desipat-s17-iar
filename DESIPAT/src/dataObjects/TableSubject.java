package dataObjects;
import java.util.ArrayList;

import screens.TableObserver;

public abstract class TableSubject {
	protected ArrayList<TableObserver> observerList;
	protected ArrayList<String> columnNames;
	
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
	
	public ArrayList<String> getColumnNames(){
		return columnNames;
	}
	/*
	public abstract void addEntry(TableEntry tableEntry);
	public abstract void editEntry(TableEntry tableEntry);
	public abstract void deleteEntry(TableEntry tableEntry);
	public abstract ArrayList<TableEntry> getAllEntries();
	public abstract TableEntry getEntry(int ID);
	
	
	public ArrayList<TableEntry> getAllEntries(){
		return entryList;
	}
	public TableEntry getEntry(int ID){ 
		for(TableEntry tableEntry:entryList)
			if(tableEntry.getID() == ID)
				return tableEntry;
		return null;
	} 
	 */
}
