package screenBehaviourStrategy;

import dataObjects.Asset;
import dataObjects.TableEntry;

public interface AssetScreenBehaviorStrategy {
	public void saveAsset(Asset a);
	public void setNewItemPanel(int itemType);
	public void saveItem();
	public void cancel();
	public void fillBoxes();

	
}
