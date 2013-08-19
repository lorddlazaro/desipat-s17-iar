package dataObjects;

import java.util.ArrayList;

public class Classification extends TableEntry{
	public final static int CLASSIFICATION_INDEX = 1;
	
	private String classification;
	
	public Classification(int ID, String classification){
		setID(ID);
		setClassification(classification);
	}
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getClassification());
		}
		return values;
	}
	public String toString(){
		return this.getClassification();
	}
}
