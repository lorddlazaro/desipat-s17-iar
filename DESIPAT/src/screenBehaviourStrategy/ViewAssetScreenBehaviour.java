package screenBehaviourStrategy;

import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy {
	
	private ViewAssetScreen view;
	

	public ViewAssetScreenBehaviour(){
		//this.model = model;
		// view = new ViewAssetScreen(this);
	}
	public ViewAssetScreen getView(){ 
		return view;
	}
	public void selectAsset() {
	}
	public void addAsset() {
	}
	public void updateAsset() {
	}
}
