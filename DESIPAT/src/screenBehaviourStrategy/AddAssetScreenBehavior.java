package screenBehaviourStrategy;
import java.util.ArrayList;

import dataObjects.PersonTable;
import dataObjects.Person;
import dataObjects.TypeLookUpTable;
import dataObjects.Type;
import dataObjects.StorageTable;
import dataObjects.Storage;
import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.UserAccountTable;
import dataObjects.Asset;
import screens.AddAssetScreen;
import screens.LoginScreen;
import screens.TableObserver;
import statements.SelectLookUpStrategy;
import statements.lookUp.LookUpMaintenance;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {


	private AddAssetScreen addAssetScreen;
	public AddAssetScreenBehavior()
	{
		//table = table.getInstance();
		addAssetScreen = new AddAssetScreen(this);
		fillBoxes();
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	public void saveAsset(Asset a) {
		//System.out.println("Behavior Asset type: "+a.getTypeID());
		AssetTable.getInstance().addEntry(a);
		
		// TODO Auto-generated method stub
		/*are these lookups even necessary?*/
		//AssetTable.getInstance().addEntry(a);
		//table.addEntry(a);
		/*SelectLookUpStrategy lookUp;
		lookUp=new LookUpMaintenance(a.getMaintenanceSchedule());
		lookUp=new lookUpType();
		lookUp=new LookUpClassification();*/
	}
	public void cancel(){
		
	}
	@Override
	public void saveItem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNewItemPanel(int itemType) {
		// TODO Auto-generated method stub
		switch(itemType)
		{
		case 0: //owner
			break;
		case 1: //custodian
			break;
		case 2: //type
			break;
		case 3: //storage
			break;
		}
	}
	
	public void fillBoxes()
	{
		ArrayList<Person>personList=PersonTable.getInstance().getAllEntries();
		ArrayList<Type>typeList=TypeLookUpTable.getInstance().getAllEntries();
		ArrayList<Storage>storageList=StorageTable.getInstance().getAllEntries();
		ArrayList<String>personNameList=new ArrayList<String>();
		ArrayList<String>typeNameList=new ArrayList<String>();
		ArrayList<String>storageNameList=new ArrayList<String>();
		for(Type t : typeList)
		{
			typeNameList.add(t.getType());
		}
		for(Storage s: storageList)
		{
			storageNameList.add(s.getStorageLocation());
		}
		for(Person p: personList)
		{
			personNameList.add(p.getName());
		}/*
		addAssetScreen.setCbxCustodianContents(personNameList);
		addAssetScreen.setCbxOwnerContents(personNameList);
		addAssetScreen.setCbxTypeContents(typeNameList);
		addAssetScreen.setCbxStorageContents(storageNameList);
	*/
	}
	public AddAssetScreen getView(){
		return addAssetScreen;
	}

	

}
