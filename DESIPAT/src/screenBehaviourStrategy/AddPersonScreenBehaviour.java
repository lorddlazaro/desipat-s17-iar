package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		addPersonScreen.addCancelButtonActionListener(new cancelButtonActionListener());
		addPersonScreen.addSaveButtonActionListener(new saveButtonActionListener());
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
	
	class cancelButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cancel();
			
		}
		
	}
	
	class saveButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//NEED VALIDATION either on person constructor or here
			Person p = new Person(-1,addPersonScreen.getFirstNameTF().getText(),addPersonScreen.getMiddleInitialTF().getText().charAt(0),addPersonScreen.getLastNameTF().getText());
			savePerson(p);
			addPersonScreen.getFirstNameTF().setText("");
			addPersonScreen.getFirstNameTF().setText("");
			addPersonScreen.getFirstNameTF().setText("");
		}
		
	}


}
