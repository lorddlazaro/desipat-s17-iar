package screenBehaviourStrategy;

import dataObjects.AssetTable;
import dataObjects.TableEntry;
import dataObjects.UserAccountTable;
import phase1.Asset;
import screens.AddAssetScreen;
import screens.LoginScreen;
import screens.TableObserver;
import statements.SelectLookUpStrategy;
import statements.lookUp.LookUpMaintenance;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	AssetTable table;
	private AddAssetScreen addAssetScreen;
	public AddAssetScreenBehavior()
	{
		table = table.getInstance();
		addAssetScreen = new AddAssetScreen(this);
		table.registerObserver((TableObserver) addAssetScreen);
	}
	public void saveAsset(TableEntry a) {
		// TODO Auto-generated method stub
		/*are these lookups even necessary?*/
		//AssetTable.getInstance().addEntry(a);
		table.addEntry(a);
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
	@Override
	public void saveAsset() {
		// TODO Auto-generated method stub
		
	}

	

}
