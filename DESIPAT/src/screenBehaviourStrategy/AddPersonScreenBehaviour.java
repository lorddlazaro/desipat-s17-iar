package screenBehaviourStrategy;

import screens.FormAssetScreen;
import screens.AddPersonScreen;
import dataObjects.Person;
import dataObjects.PersonTable;


public class AddPersonScreenBehaviour implements AddPersonScreenBehaviourStrategy{
	private AddPersonScreen addPersonScreen;
	public  AddPersonScreenBehaviour()
	{
		//table = table.getInstance();
		addPersonScreen = new AddPersonScreen(this);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
	}
	
	
	
	public AddPersonScreen getView(){
		return addPersonScreen;
	}
	@Override
	public void cancel() {
		addPersonScreen.setVisible(false);
		// TODO Auto-generated method stub
		
	}

	public void savePerson(Person p) {
		PersonTable.getInstance().addEntry(p);
		((FormAssetScreen)addPersonScreen.getParent()).refresh();
		// TODO Auto-generated method stub
		
	}


}
