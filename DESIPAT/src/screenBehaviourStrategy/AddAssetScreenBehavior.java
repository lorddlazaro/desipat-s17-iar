package screenBehaviourStrategy;

public class AddAssetScreenBehavior implements AssetScreenBehaviorStrategy {

	@Override
	public void saveAsset() {
		// TODO Auto-generated method stub
		
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
