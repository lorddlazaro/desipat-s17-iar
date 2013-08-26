	package screens;


import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import screenBehaviourStrategy.LogsScreenBehaviorStrategy;
import tablePanels.ActionLogTablePanel;
import tablePanels.AssetChangeLogTablePanel;

public class LogScreen extends Screen implements TableObserver {
	
	LogsScreenBehaviorStrategy  behavior;
	private ActionLogTablePanel actionLogTablePanel;
	private AssetChangeLogTablePanel assetChangeLogTablePanel;

	public LogScreen(LogsScreenBehaviorStrategy  behavior){
		this.behavior = behavior;
		initialize();
	}
	
	public void initialize() {
		setBackground(new Color(255, 250, 205));
		setLayout(null);
		
		actionLogTablePanel = new ActionLogTablePanel(behavior);
		actionLogTablePanel.setBounds(12, 12, 748, 200);
		add(actionLogTablePanel);
		
		assetChangeLogTablePanel = new AssetChangeLogTablePanel(behavior);
		assetChangeLogTablePanel.setBounds(12, 235, 748, 200);
		add(assetChangeLogTablePanel);
	}
	
	public void setActionLogTableModel(DefaultTableModel model){
		actionLogTablePanel.fillTable(model);
	}
	
	public void setAssetChangeLogTableModel(DefaultTableModel model){
		assetChangeLogTablePanel.fillTable(model);
	}
	
	public void refresh(){
		actionLogTablePanel.updateUI();
		assetChangeLogTablePanel.updateUI();
	}
}
