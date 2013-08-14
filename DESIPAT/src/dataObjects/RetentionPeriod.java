package dataObjects;

import java.util.ArrayList;

public class RetentionPeriod extends TableEntry{
	public final static int PERIODNAME_INDEX = 1;
	public final static int PERIODVALUE_INDEX = 2;
	
	private String periodName;
	private int periodValue;
	
	public RetentionPeriod(int ID, String periodName, int periodValue){
		setID(ID);
		setPeriodName(periodName);
		setPeriodValue(periodValue);
	}
	
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public int getPeriodValue() {
		return periodValue;
	}
	public void setPeriodValue(int periodValue) {
		this.periodValue = periodValue;
	}
	public ArrayList<String> getValues(){
		if(values!=null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getPeriodName());
			values.add(String.valueOf(getPeriodValue()));
		}
		return values;
	}
}
