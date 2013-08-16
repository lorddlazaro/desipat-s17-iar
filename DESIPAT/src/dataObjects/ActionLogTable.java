package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.getMax.GetMaxIDActionLog;
import statements.getMax.GetMaxIDAssetChangeLog;
import statements.insertNew.NewActionLog;
import statements.insertNew.NewAsset;
import statements.insertNew.NewUser;
import statements.selectAll.SelectAllActionLogs;
import statements.selectAll.SelectAllAssets;
import statements.updateTable.UpdateAsset;

public class ActionLogTable extends TableSubject{
	public final static String ACTIONID_COLUMN_NAME = "actionID";
	public final static String USERID_COLUMN_NAME = "userID";
	public final static String DATE_COLUMN_NAME = "actionDate";
	public final static String TIME_COLUMN_NAME = "actionTime";
	public final static String HEADERID_COLUMN_NAME = "actionHeaderID";
	public final static String ACTIONDESC_COLUMN_NAME = "actionDesc";
	
	private ArrayList<ActionLog> actionLogList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static ActionLogTable instance;
	
	public static ActionLogTable getInstance(){
		if(instance == null){
			instance = new ActionLogTable();
		}
		return instance;
	}
	
	protected ActionLogTable(){
		observerList = new ArrayList<TableObserver>();
		
		columnNames = new ArrayList<String>();
		columnNames.add(ACTIONID_COLUMN_NAME);
		columnNames.add(USERID_COLUMN_NAME);
		columnNames.add(DATE_COLUMN_NAME);
		columnNames.add(TIME_COLUMN_NAME);
		columnNames.add(HEADERID_COLUMN_NAME);
		columnNames.add(ACTIONDESC_COLUMN_NAME);
		
		actionLogList = new ArrayList<ActionLog>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllActionLogs();
		statement.executeStatement();
		actionLogList = statement.getResultList();
	}
	
	public void addEntry(ActionLog actionLog){
		actionLogList.add(actionLog);
		NonQuery statement = new NewActionLog(actionLog);
		statement.executeStatement();
		
		Query getID = new GetMaxIDActionLog();
		getID.executeStatement();
		
		actionLog.setID((Integer)getID.getResultList().get(0));
		
		this.notifyObservers();
	}
	
	/* CANT EDIT ACTIONLOG
	public void editEntry(ActionLog actionLog){
		ArrayList<String> values = actionLog.getValues();
		values.remove(this.ACTIONID_COLUMN_NAME);
		
		NonQuery statement = new UpdateActionLog(values, actionLog.getID());
		statement.executeStatement();
	}	*/
	
	/* CANT DELETE ACTIONLOG
	public void deleteEntry(ActionLog actionLog){
		// TODO
		/*UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();
	}
	*/

	public ArrayList<ActionLog> getAllEntries() {
		return actionLogList;
	}
	
	public ActionLog getEntry(int ID) {
		for(ActionLog actionLog:actionLogList)
			if(actionLog.getID() == ID)
				return actionLog;
		return null;
	}
}