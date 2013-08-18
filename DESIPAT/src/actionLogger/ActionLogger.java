package actionLogger;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dataObjects.ActionLog;
import dataObjects.ActionLogTable;
import dbHandler.NonQueryHandler;

public abstract class ActionLogger {
	
	protected ActionLog log;
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	
	public ActionLogger(int userID) {
		log = new ActionLog();
		log.setUserID(userID);
		log.setActionDate(new Date(Calendar.getInstance().getTime().getTime()));
		log.setActionTime(new Time(Calendar.getInstance().getTime().getTime()));
	}
	
	public void logAction(){
		ActionLogTable.getInstance().addEntry(log);
	}
}