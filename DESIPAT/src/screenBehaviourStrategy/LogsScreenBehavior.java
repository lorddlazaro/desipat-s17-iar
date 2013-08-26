package screenBehaviourStrategy;


import dataObjects.ActionLogTable;
import dataObjects.AssetChangeLogTable;
import dataObjects.AssetTable;
import screens.LogScreen;
import screens.TableObserver;
import tablePanels.ActionLogTablePanel;


public class LogsScreenBehavior implements LogsScreenBehaviorStrategy, TableObserver{

	private LogScreen log;
	private MainScreenBehaviourStrategy main;
	
	public LogsScreenBehavior(MainScreenBehaviourStrategy main){
		log = new LogScreen(this);
		this.main = main;
		ActionLogTable.getInstance().registerObserver(this);
		AssetChangeLogTable.getInstance().registerObserver(this);
		refresh();
	}
	
	public LogScreen getView(){
		return log;
	}
	
	@Override
	public void refresh() {
		log.setActionLogTableModel(ActionLogTable.getInstance().createTableModel());
		log.setAssetChangeLogTableModel(AssetChangeLogTable.getInstance().createAssetChangeLogTableModel());
	}
}