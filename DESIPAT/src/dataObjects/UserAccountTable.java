package dataObjects;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import screens.TableObserver;

import statements.selectAll.SelectAllUsers;

import statements.updateTable.UpdateUser;
import dbHandler.NonQuery;
import dbHandler.Query;

import statements.getMax.GetMaxIDUserAccount;
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
		values.add("1");
		
		System.out.println(values);
		NonQuery statement = new UpdateUser(values, userAccount.getID());
		statement.executeStatement();
		
		this.notifyObservers();
	}
	
	public void deleteEntry(UserAccount userAccount){
		userList.remove(userAccount);
		ArrayList<String> values = userAccount.getValues();
		values.remove(UserAccount.ID_INDEX);
		values.add("0");
		
		System.out.println(values);
		NonQuery statement = new UpdateUser(values, userAccount.getID());
		statement.executeStatement();
		
		fillData();
		this.notifyObservers();
	}
	
	public boolean checkForUser(Person p) {
		if (PersonTable.getInstance().getEntry(p.getFirstName(), p.getMiddleInitial() + "", p.getLastName()) == null)
			return false;
		
		for (UserAccount user:userList)
			//if(user.getPersonID() == p.getID())
			if (user.getPersonID() == PersonTable.getInstance().getEntry(p.getFirstName(), p.getMiddleInitial()+"", p.getLastName()).getID())
				return true;
		return false;
	}
	
	public boolean checkIfUsernameNotTaken(String s) {
		for (UserAccount user:userList)
			if (user.getUsername().equals(s))
				return false;

		return true;
	}
	
	public ArrayList<UserAccount> getAllEntries(boolean isActive) {
		if(isActive){
			ArrayList<UserAccount> active = new ArrayList<UserAccount>();
			for(UserAccount account: userList){
				if(account.isActive())
					active.add(account);
			}
			return active;
		}
		
		return userList;
	}

	public UserAccount getEntry(int ID) {
		for(UserAccount user:userList)
			if(user.getID() == ID)
				return user;
		return null;
	}
	
	public DefaultTableModel createTableModel(){
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"UserID", "Username", "Password", "Clearance", "First Name", "Middle Initial", "Last Name"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
			ArrayList<UserAccount> list = getAllEntries(true);
			
			for (int i = 0; i < list.size(); i++)
				model.addRow(new Object[] {list.get(i).getID(), list.get(i).getUsername(), list.get(i).getPassword(), list.get(i).getClearance().getClearanceLevel(), list.get(i).getPersonFirstName(), list.get(i).getPersonMiddleName(), list.get(i).getPersonLastName()});
			
		return model;
	}
	
}