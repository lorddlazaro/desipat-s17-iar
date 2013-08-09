package dataObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import phase1.DBConnection;
import phase1.User;

import screens.TableObserver;
import statements.DeleteUser;

import statements.selectAll.SelectAllUsers;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewUser;

public class UserAccountTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "userID";
	public final static String USERNAME_COLUMN_NAME = "username";
	public final static String PASSWORD_COLUMN_NAME = "password";
	public final static String CLEARANCEID_COLUMN_NAME = "clearanceID";
	public final static String PERSONID_COLUMN_NAME = "personID";
	
	private ArrayList<UserAccount> userList;	
	private ArrayList<String> columnNames;

	// Singleton's getInstance
	private static UserAccountTable instance;
		
	public static UserAccountTable getInstance(){
		if(instance == null){
			instance = new UserAccountTable();
		}
		return instance;
	}
	
	protected UserAccountTable(){
		observerList = new ArrayList<TableObserver>();
		
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(USERNAME_COLUMN_NAME);
		columnNames.add(PASSWORD_COLUMN_NAME);
		columnNames.add(CLEARANCEID_COLUMN_NAME);
		columnNames.add(PERSONID_COLUMN_NAME);
		
		userList = new ArrayList<UserAccount>();
		fillData();
	}
	
	public void fillData(){
		Query statement = new SelectAllUsers();
		statement.executeStatement();
		try{
			ResultSet rs = statement.getResult();
			if(rs.isBeforeFirst()){
				rs.first();
				while(!rs.isAfterLast()){
					UserAccount userAccount = new UserAccount(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
					userList.add(userAccount);
					rs.next();
				}
			}
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addEntry(TableEntry tableEntry){
		UserAccount userAccount = (UserAccount)tableEntry;
		NonQuery statement = new NewUser(userAccount);
		statement.executeStatement();
	}
	
	public void editEntry(TableEntry tableEntry){
		//TODO: edit entry
	}	
	
	public ArrayList<UserAccount> getAllEntries() {
		return userList;
	}

	public UserAccount getEntry(int ID) {
		for(UserAccount user:userList)
			if(user.getID() == ID)
				return user;
		return null;
	}
}
