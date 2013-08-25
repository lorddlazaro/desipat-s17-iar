package assetLogger;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dataObjects.Asset;
import dataObjects.AssetChangeLog;
import dataObjects.AssetChangeLogTable;


public abstract class AssetLogger {
	
	protected AssetChangeLog log;
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	
	public AssetLogger(int actionID, Asset newAsset ) {
		log = new AssetChangeLog();
		log.setActionID(actionID);
		log.setActionDate(new Date(Calendar.getInstance().getTime().getTime()));
		log.setActionTime(new Time(Calendar.getInstance().getTime().getTime()));
		
	}
	
	public void logAction(){
		AssetChangeLogTable.getInstance().addEntry(log);
		
	}
}