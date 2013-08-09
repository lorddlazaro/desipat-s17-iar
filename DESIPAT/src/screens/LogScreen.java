package screens;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
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
	
		JLabel lblNewLabel = new JLabel("Action Log");
		lblNewLabel.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 752, 38);
		add(lblNewLabel);
		
		actionLogTablePanel = new ActionLogTablePanel();
		actionLogTablePanel.initialize();
		actionLogTablePanel.fillTable(ActionLogTable.getInstance());
		
		add(actionLogTablePanel);
		
		assetChangeLogTablePanel = new AssetChangeLogTablePanel();
		assetChangeLogTablePanel.initialize();
		assetChangeLogTablePanel.fillTable(AssetChangeLogTable.getInstance());
		
		add(assetChangeLogTablePanel);
			
		JLabel lblAssetChangeLog = new JLabel("Asset Change Log");
		lblAssetChangeLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssetChangeLog.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAssetChangeLog.setBounds(12, 235, 752, 38);
		add(lblAssetChangeLog);
	}
	
	public void refresh(){
		//TODO
	}
}
