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
import statements.selectAll.SelectAllClassification;
import statements.selectAll.SelectAllType;
import statements.updateTable.UpdateAsset;

public class ClassificationLookUpTable{
	public final static String ID_COLUMN_NAME = "classID";
	public final static String CLASSIFICATION_COLUMN_NAME = "classification";

	private ArrayList<Type> classificationLookUpList;	
	private ArrayList<String> columnNames;
	
	// Singleton's getInstance
	private static ClassificationLookUpTable instance;
		
	public static ClassificationLookUpTable getInstance(){
		if(instance == null){
			instance = new ClassificationLookUpTable();
		}
		return instance;
	}
	
	protected  ClassificationLookUpTable(){
		columnNames = new ArrayList<String>();
		columnNames.add(ID_COLUMN_NAME);
		columnNames.add(CLASSIFICATION_COLUMN_NAME);
	
		classificationLookUpList = new ArrayList<Type>();
		fillData();
	}
	
	private void fillData(){
		Query statement = new SelectAllClassification();
		statement.executeStatement();
		classificationLookUpList = statement.getResultList();
	}
	
	public ArrayList<Type> getAllEntries() {
		return classificationLookUpList;
	}

	public Type getEntry(int ID) {
		for(Type Type:classificationLookUpList)
			if(Type.getID() == ID)
				return Type;
		return null;
	}
}
