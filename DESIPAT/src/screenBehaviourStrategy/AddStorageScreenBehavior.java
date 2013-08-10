package screenBehaviourStrategy;

import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.Storage;
import dataObjects.StorageTable;
import screens.AddPersonScreen;
import screens.AddStoragePanel;


public class AddStorageScreenBehavior implements
		AddStorageScreenBehaviorStrategy {

	private AddStoragePanel addStoragePanel;
	public  AddStorageScreenBehavior()
	{
		//table = table.getInstance();
		addStoragePanel = new AddStoragePanel(this);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	
	
	
	public AddStoragePanel getView(){
		return addStoragePanel;
	}
	
	public void cancel()
	{
		addStoragePanel.setVisible(false);
	}




	@Override
	public void saveStorage(Storage s) {
		// TODO Auto-generated method stub
		StorageTable.getInstance().addEntry(s);
	}

}
