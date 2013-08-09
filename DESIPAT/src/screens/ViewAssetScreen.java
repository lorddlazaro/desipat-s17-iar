package screens;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import dataObjects.AssetTable;

import screenBehaviourStrategy.ViewAssetScreenBehaviourStrategy;
import tablePanels.ViewAssetTablePanel;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;


public class ViewAssetScreen extends Screen implements TableObserver{

	private Connection conn;
	
	//private Model model;
	ViewAssetScreenBehaviourStrategy behavior;
	ViewAssetTablePanel table;
	
	private JTable assetTable;
	private JLabel lblIdentifier;
	private JLabel lblName;
	private JLabel lblOwner;
	private JLabel lblCustodian;
	private JLabel lblType;
	private JLabel lblDateAcquired;
	private JLabel lblStatus;
	private JLabel lblMaintenance;
	private JLabel lblFinancialValue;
	private JLabel lblConfidentialValue;
	private JLabel lblIntegrityValue;
	private JLabel lblAvailabilityValue;
	private JLabel lblClassification;
	private JLabel lblStorageLocation;
	private JTable changeLogTable;
	
	public ViewAssetScreen(ViewAssetScreenBehaviourStrategy behaviour) {
		this.behavior = behaviour;
		initialize();
	}
	
	public void initialize() {
	
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 205, 382);
		add(scrollPane);
		
		table = new ViewAssetTablePanel();
		table.initialize();
		assetTable = table.getTable();
		scrollPane.setViewportView(assetTable);
		
		JButton btnAddAsset = new JButton("Add Asset");
		btnAddAsset.setBackground(SystemColor.activeCaption);
		btnAddAsset.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnAddAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				behavior.addAsset();
			}
			
		});
		btnAddAsset.setBounds(10, 11, 205, 39);
		add(btnAddAsset);
		
		JPanel assetDetails = new JPanel();
		assetDetails.setBounds(225, 11, 537, 206);
		add(assetDetails);
		
		assetDetails.setLayout(new GridLayout(0,4));
		
		JLabel label = new JLabel("Identifier:");
		label.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label, "2, 2");
		
		lblIdentifier = new JLabel("");
		assetDetails.add(lblIdentifier, "4, 2");
		
		JLabel label_7 = new JLabel("Maintenance Schedule:");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_7, "6, 2");
		
		lblMaintenance = new JLabel("");
		assetDetails.add(lblMaintenance, "8, 2");
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_1, "2, 4");
		
		lblName = new JLabel("");
		assetDetails.add(lblName, "4, 4");
		
		JLabel label_8 = new JLabel("Financial Value:");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_8, "6, 4");
		
		lblFinancialValue = new JLabel("");
		assetDetails.add(lblFinancialValue, "8, 4");
		
		JLabel label_2 = new JLabel("Owner:");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_2, "2, 6");
		
		lblOwner = new JLabel("");
		assetDetails.add(lblOwner, "4, 6");
		
		JLabel label_9 = new JLabel("Confidential Value:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_9, "6, 6");
		
		lblConfidentialValue = new JLabel("");
		assetDetails.add(lblConfidentialValue, "8, 6");
		
		JLabel label_3 = new JLabel("Custodian:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_3, "2, 8");
		
		lblCustodian = new JLabel("");
		assetDetails.add(lblCustodian, "4, 8");
		
		JLabel label_10 = new JLabel("Integrity Value:");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_10, "6, 8");
		
		lblIntegrityValue = new JLabel("");
		assetDetails.add(lblIntegrityValue, "8, 8");
		
		JLabel label_4 = new JLabel("Type:");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_4, "2, 10");
		
		lblType = new JLabel("");
		assetDetails.add(lblType, "4, 10");
		
		JLabel label_11 = new JLabel("Availability Value:");
		label_11.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_11, "6, 10");
		
		lblAvailabilityValue = new JLabel("");
		assetDetails.add(lblAvailabilityValue, "8, 10");
		
		JLabel label_5 = new JLabel("Date acquired:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_5, "2, 12");
		
		lblDateAcquired = new JLabel("");
		assetDetails.add(lblDateAcquired, "4, 12");
		
		JLabel label_12 = new JLabel("Classification:");
		label_12.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_12, "6, 12");
		
		lblClassification = new JLabel("");
		assetDetails.add(lblClassification, "8, 12");
		
		JLabel label_6 = new JLabel("Status:");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_6, "2, 14");
		
		lblStatus = new JLabel("");
		assetDetails.add(lblStatus, "4, 14");
		
		JLabel label_13 = new JLabel("Storage Location:");
		label_13.setFont(new Font("Calibri", Font.PLAIN, 13));
		assetDetails.add(label_13, "6, 14");
		
		lblStorageLocation = new JLabel("");
		assetDetails.add(lblStorageLocation, "8, 14");
		
		JButton btnUpdateAsset = new JButton("Update Asset");
		btnUpdateAsset.setBackground(SystemColor.activeCaption);
		assetDetails.add(btnUpdateAsset, "8, 16");
		btnUpdateAsset.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnUpdateAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				behavior.updateAsset();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(225, 228, 537, 215);
		add(scrollPane_1);
		
		changeLogTable = new JTable();
		changeLogTable.setFont(new Font("Calibri", Font.PLAIN, 13));
		changeLogTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User", "Date", "Time", "Field", "Old Value", "New Value"
			}
		));
		scrollPane_1.setViewportView(changeLogTable);
		
		refresh();
		
	}
	
	public void refresh(){
		System.out.println(AssetTable.getInstance().getAllEntries().get(0).getName());
		
		table.fillTable(AssetTable.getInstance());
		assetTable.updateUI();
	}
}
