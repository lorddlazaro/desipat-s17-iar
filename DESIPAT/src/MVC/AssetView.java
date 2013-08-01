package MVC;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class AssetView implements ActionListener, AssetObserver{

	ModelInterface model;
	ControllerInterface controller;
	
	//UIComponents
	JPanel mainPanel;
	JScrollPane assetListScrollPane;
	JTable assetListTable;
	
	JPanel assetDetailsPanel;
	ArrayList<JLabel> propertyNameLbl;
	ArrayList<JLabel> propertyValueLbl;
	
	JScrollPane logListScrollPane;
	JTable logListTable;
	
	JButton addBtn;
	JButton updateBtn;
	
	
	public AssetView(ControllerInterface controller, ModelInterface model){
		this.model = model;
		this.controller = controller;
		model.registerAssetObserver((AssetObserver)this);	
	}
	
	
	public void createUI(){
		//Create swing components
		mainPanel = new JPanel(new BoxLayout(mainPanel,BoxLayout.LINE_AXIS));
		
		assetListScrollPane = new JScrollPane();
		mainPanel.add(assetListScrollPane);
		
		assetListTable = new JTable();
		assetListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		assetListScrollPane.setViewportView(assetListTable);
	
		
	}
	
	
	
	public void updateAssetList() {
		//Observer update
		
	}


	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == assetListTable){
			
		}
	}

}
