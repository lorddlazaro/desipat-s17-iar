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

public class TypeLookUpTable{
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
	
	public ArrayList<Type> getAllEntries() {
		return TypeLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type type:TypeLookUpList)
			if(type.getID() == ID)
				return type;
		return null;
	}
}
