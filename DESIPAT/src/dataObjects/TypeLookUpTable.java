package dataObjects;

import java.util.ArrayList;

import screens.TableObserver;
import statements.DeleteUser;
import dbHandler.NonQuery;
import dbHandler.Query;
import statements.insertNew.NewAsset;
import statements.insertNew.NewType;

import statements.insertNew.NewUser;
import statements.selectAll.SelectAllAssets;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class TypeLookUpTable extends TableSubject{
	public final static String ID_COLUMN_NAME = "typeID";
	public final static String TYPE_COLUMN_NAME = "type";

	private ArrayList<Type> TypeLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static TypeLookUpTable instance;
		
	public static TypeLookUpTable getInstance(){
		if(instance == null){
			instance = new TypeLookUpTable();
		}
		return instance;
	}
	
	protected  TypeLookUpTable(){
		observerList = new ArrayList<TableObserver>();

		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(TYPE_COLUMN_NAME);
	
		TypeLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllType();
		statement.executeStatement();
		TypeLookUpList = statement.getResultList();
	}
	
	public void addEntry(Type Type){
		TypeLookUpList.add(Type);
		NonQuery statement = new NewType(Type);
		statement.executeStatement();
		
		this.notifyObservers();
	}
	
	public void editEntry(Type type) {
		ArrayList<String> values = type.getValues();
		values.remove(this.ID_COLUMN_NAME);
		
		NonQuery statement = new UpdateAsset(values, type.getID());
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
	
	public ArrayList<Type> getAllEntries() {
		return TypeLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:TypeLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
