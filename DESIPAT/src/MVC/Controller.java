package MVC;

public class Controller implements ControllerInterface{
	
	ModelInterface model;
	AssetView view;
	
	
	public Controller(ModelInterface model){
		this.model = model;
		view =  new AssetView(this,model);
		view.createUI();
		
	}

	public void retrieveAsset(int identifier) {

	}
	
}
