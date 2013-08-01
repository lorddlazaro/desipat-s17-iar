package dataClasses;
import java.sql.Date;
import java.sql.Time;
public class ActionLog {
	private int actionID;
	private int userID;
	private Date actionDate;
	private Time actionTime;
	private int actionHeaderID;
	private String actionDescription;
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
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
	public String getActionDescription() {
		return actionDescription;
	}
	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}
}
