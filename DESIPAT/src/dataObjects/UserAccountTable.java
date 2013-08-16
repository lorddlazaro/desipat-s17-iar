package dataObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import phase1.DBConnection;
import phase1.User;

import screens.TableObserver;
import statements.DeleteUser;

import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllUsers;
import statements.updateTable.UpdateAsset;
import statements.updateTable.UpdateUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.getMax.GetMaxIDPerson;
import statements.getMax.GetMaxIDUserAccount;
import statements.insertNew.NewAsset;
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
	
	private void fillData(){
		Query statement = new SelectAllUsers();
		statement.executeStatement();
		userList = statement.getResultList();
	}
	
	public void addEntry(UserAccount userAccount){
		userList.add(userAccount);
		NonQuery statement = new NewUser(userAccount);
		statement.executeStatement();
		
		Query getID = new GetMaxIDUserAccount();
		getID.executeStatement();
		
		userAccount.setID((Integer)getID.getResultList().get(0));
		
		this.notifyObservers();
	}
	
	public void editEntry(UserAccount userAccount) {
		ArrayList<String> values = userAccount.getValues();
		
		values.remove(UserAccount.ID_INDEX);
		System.out.println(values);
		NonQuery statement = new UpdateUser(values, userAccount.getID());
		statement.executeStatement();
		
		this.notifyObservers();
	}
	
	/*
	 * YOU CANT DELETE AN ASSET
	public void deleteEntry(Asset asset){
		assetList.add(asset);
		NonQuery statement = new DeleteAsset(asset);
		statement.executeStatement();	
	}*/
		
	
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