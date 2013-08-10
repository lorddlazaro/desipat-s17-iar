package screenBehaviourStrategy;

import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.Type;
import dataObjects.TypeLookUpTable;

import screens.AddPersonScreen;
import screens.AddTypePanel;


public class AddTypeScreenBehavior implements
		AddTypeScreenBehaviorStrategy {

	private AddTypePanel addTypePanel;
	public  AddTypeScreenBehavior()
	{
		//table = table.getInstance();
		addTypePanel = new AddTypePanel(this);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	
	
	
	public AddTypePanel getView(){
		return addTypePanel;
	}
	
	public void cancel()
	{
		addTypePanel.setVisible(false);
	}




	@Override
	public void saveType(Type s) {
		// TODO Auto-generated method stub
		TypeLookUpTable.getInstance().addEntry(s);
	}

}
