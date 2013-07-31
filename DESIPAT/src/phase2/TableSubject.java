package phase2;
import java.util.ArrayList;

public abstract class TableSubject {
	private ArrayList<TableObserver> observerList;
	
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
}
