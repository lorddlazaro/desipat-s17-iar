package dataObjects;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
public class ActionLog  extends TableEntry{
	public final static int USERID_INDEX = 1;
	public final static int ACTIONDATE_INDEX = 2;
	public final static int ACTIONTIME_INDEX = 3;
	public final static int ACTIONHEADERID_INDEX = 4;
	public final static int ACTIONDESC_INDEX = 5;
	
	private int userID;
	private Date actionDate;
	private Time actionTime;
	private int actionHeaderID;
	private String actionDesc;
	
	public ActionLog() {
		
	}
	
	public ActionLog(int ID, int userID, Date actionDate, Time actionTime, int actionHeaderID, String actionDesc){
		setID(ID);
		setUserID(userID);
		setActionDate(actionDate);
		setActionTime(actionTime);
		setActionHeaderID(actionHeaderID);
		setActionDesc(actionDesc);
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public Time getActionTime() {
		return actionTime;
	}
	public void setActionTime(Time actionTime) {
		this.actionTime = actionTime;
	}
	public int getActionHeaderID() {
		return actionHeaderID;
	}
	public void setActionHeaderID(int actionHeaderID) {
		this.actionHeaderID = actionHeaderID;
	}
	public ActionHeader getActionHeader() {
		return ActionHeaderLookUpTable.getInstance().getEntry(actionHeaderID);
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	public ArrayList<String> getValues() {
		if(values != null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(String.valueOf(getUserID()));
			values.add(getActionDate().toString());
			values.add(getActionTime().toString());
			values.add(String.valueOf(getActionHeaderID()));
			values.add(getActionDesc());
		}
		return values;
	}
}
