package screenBehaviourStrategy;

import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy {
	
	//Todo: add respective model here
	//Private Model model;
	private ViewAssetScreen view;
	
	
	//Todo: pass model through the constructor;
	public ViewAssetScreenBehaviour(){
		//this.model = model;
		view = new ViewAssetScreen(this);
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
