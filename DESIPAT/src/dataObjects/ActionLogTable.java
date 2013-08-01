package dataObjects;

import java.util.ArrayList;

import statements.DeleteUser;
import dbHandler.NonQuery;
import statements.insertNew.NewActionLog;
import statements.insertNew.NewUser;

public class ActionLogTable extends TableSubject{
	public final static String ACTIONID_COLUMN_NAME = "actionID";
	public final static String USERID_COLUMN_NAME = "userID";
	public final static String DATE_COLUMN_NAME = "actionDate";
	public final static String TIME_COLUMN_NAME = "actionTime";
	public final static String HEADERID_COLUMN_NAME = "actionHeaderID";
	public final static String ACTIONDESC_COLUMN_NAME = "actionDesc";
	
	private ArrayList<ActionLog> actionList;	
	private ArrayList<String> columnNames;
	
	public ActionLogTable(){
		actionList = new ArrayList<ActionLog>();
		columnNames = new ArrayList<String>();
		columnNames.add(ACTIONID_COLUMN_NAME);
		columnNames.add(USERID_COLUMN_NAME);
		columnNames.add(DATE_COLUMN_NAME);
		columnNames.add(HEADERID_COLUMN_NAME);
		columnNames.add(ACTIONDESC_COLUMN_NAME);
	}
	public void addEntry(TableEntry tableEntry){
		ActionLog actionLog = (ActionLog)tableEntry;
		entryList.add(tableEntry);
		NonQuery statement = new NewActionLog(actionLog);
		statement.executeStatement();
	}
	//TODO: edit entry
	public void editEntry(TableEntry tableEntry){}	
	public void deleteEntry(TableEntry tableEntry){
		/*UserAccount user = (UserAccount)tableEntry;
		NonQuery statement = new DeleteUser(user.getID());
		statement.executeStatement();*/
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
}

