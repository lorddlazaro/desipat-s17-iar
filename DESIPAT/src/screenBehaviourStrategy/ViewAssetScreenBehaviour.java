package screenBehaviourStrategy;

import dataObjects.AssetTable;
import screens.MainScreen;
import screens.ViewAssetScreen;

public class ViewAssetScreenBehaviour implements ViewAssetScreenBehaviourStrategy {
	
	private ViewAssetScreen view;
	private MainScreenBehaviourStrategy main;

	public ViewAssetScreenBehaviour(MainScreenBehaviourStrategy main){
		 view = new ViewAssetScreen(this);
		 this.main = main;
	}
	public ViewAssetScreen getView(){ 
		return view;
	}
	public void selectAsset() {
	}
	public void addAsset() {
		main.gotoAddAssetScreen();
	}
	public void updateAsset() {
		main.gotoEditAssetScreen();
	}
}
