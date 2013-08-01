package statements;

public class SelectFromAsset extends SelectFromIDStrategy {
	public SelectFromAsset(int assetID) {
		super("Asset", "assetID = " + assetID);
	}
}	