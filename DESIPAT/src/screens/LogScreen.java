package screens;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dataObjects.ActionLogTable;
import dataObjects.AssetChangeLogTable;

import tablePanels.ActionLogTablePanel;
import tablePanels.AssetChangeLogTablePanel;

public class LogScreen extends JPanel {
	private ActionLogTablePanel actionLogTablePanel;
	private AssetChangeLogTablePanel assetChangeLogTablePanel;

	public LogScreen(){
		initialize();
	}
	
	public void initialize() {
		setBackground(new Color(255, 250, 205));
		setLayout(null);
		
		actionLogTablePanel = new ActionLogTablePanel("Action Log");
		actionLogTablePanel.setBounds(12, 12, 748, 200);
		add(actionLogTablePanel);
		
		assetChangeLogTablePanel = new AssetChangeLogTablePanel("Asset Change Log");
		assetChangeLogTablePanel.setBounds(12, 235, 748, 200);
		add(assetChangeLogTablePanel);
	}
	
	public void refresh(){
		actionLogTablePanel.refresh();
		assetChangeLogTablePanel.refresh();
	}
}
