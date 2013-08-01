package screenBehaviourStrategy;

import phase1.Asset;
import statements.SelectLookUpStrategy;
import statements.lookUp.LookUpMaintenance;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	@Override
	public void saveAsset(Asset a) {
		// TODO Auto-generated method stub
		/*are these lookups even necessary?*/
		SelectLookUpStrategy lookUp;
		lookUp=new LookUpMaintenance(a.getMaintenanceSchedule());
		lookUp=new lookUpType();
		lookUp=new LookUpClassification();
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

}
