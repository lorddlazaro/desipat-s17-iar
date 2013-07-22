package phase1;
import java.sql.Date;
import java.sql.Time;
public class LogEntry {
	private int actionID;
	private  Date actionDate;
	private Time actionTime;
	private String actionDescription;
	
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
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
	public String getActionDescription() {
		return actionDescription;
	}
	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}
	
}
