package screenBehaviourStrategy;

import dataObjects.TableEntry;

public interface AssetScreenBehaviorStrategy {
	public void saveAsset(TableEntry asset);
	public void setNewItemPanel(int itemType);
	public void saveItem();
	public void cancel();
	void saveAsset();
	
}
