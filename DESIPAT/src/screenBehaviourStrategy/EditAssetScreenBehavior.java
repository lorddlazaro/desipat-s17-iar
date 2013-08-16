package screenBehaviourStrategy;

import java.util.ArrayList;

import screens.AddAssetScreen;
import screens.EditAssetScreen;
import dataObjects.Asset;
import dataObjects.AssetTable;
import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.Storage;
import dataObjects.StorageTable;
import dataObjects.TableEntry;
import dataObjects.Type;
import dataObjects.TypeLookUpTable;

public class EditAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	
	private EditAssetScreen editAssetScreen;
	public EditAssetScreenBehavior(int ID)
	{
		//table = table.getInstance();
		editAssetScreen = new EditAssetScreen(this,ID);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	@Override
	public void saveAsset(Asset a) {
		AssetTable.getInstance().editEntry(a);

		// TODO Auto-generated method stub

	}



	@Override
	public void setNewItemPanel(int itemType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}
	public EditAssetScreen getView(){
		return editAssetScreen;
	}
	@Override
	public void fillBoxes() {
		// TODO Auto-generated method stub
		
		/*
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
		}
		editAssetScreen.setCbxCustodianContents(personNameList);
		editAssetScreen.setCbxOwnerContents(personNameList);
		editAssetScreen.setCbxTypeContents(typeNameList);
		editAssetScreen.setCbxStorageContents(storageNameList);
	
	*/
	}
	//public void fillFields()

}
