package screenBehaviourStrategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataObjects.Person;
import dataObjects.PersonTable;
import dataObjects.Storage;
import dataObjects.StorageTable;
import screenBehaviourStrategy.AddPersonScreenBehaviour.cancelButtonActionListener;
import screenBehaviourStrategy.AddPersonScreenBehaviour.saveButtonActionListener;
import screens.FormAssetScreen;
import screens.AddPersonScreen;
import screens.AddStoragePanel;


public class AddStorageScreenBehavior implements
		AddStorageScreenBehaviorStrategy {

	private AddStoragePanel addStoragePanel;
	public  AddStorageScreenBehavior()
	{
		//table = table.getInstance();
		addStoragePanel = new AddStoragePanel(this);
		//AssetTable.getInstance().registerObserver((TableObserver) addAssetScreen);
		
		addStoragePanel.addCancelButtonActionListener(new cancelButtonActionListener());
		addStoragePanel.addSaveButtonActionListener(new saveButtonActionListener());
	}
	
	
	
	public AddStoragePanel getView(){
		return addStoragePanel;
	}
	
	public void cancel()
	{
		addStoragePanel.setVisible(false);
	}


	@Override
	public void saveStorage(Storage s) {
		// TODO Auto-generated method stub
		StorageTable.getInstance().addEntry(s);
		((FormAssetScreen)addStoragePanel.getParent()).refresh();
		
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
			Storage s =new Storage(-1,addStoragePanel.getStorageLocationTF().getText());
			saveStorage(s);
			addStoragePanel.getStorageLocationTF().setText("");
		}
		
	}

}
