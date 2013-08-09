package screenBehaviourStrategy;

import screens.AddAssetScreen;
import screens.EditAssetScreen;
import dataObjects.TableEntry;

public class EditAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	
	private EditAssetScreen editAssetScreen;
	public EditAssetScreenBehavior(int ID)
	{
		//table = table.getInstance();
		editAssetScreen = new EditAssetScreen(this,ID);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	@Override
	public void saveAsset() {
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

}
