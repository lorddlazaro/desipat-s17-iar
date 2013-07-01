import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class assetScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	DBConnection db;
	private JTable table;
	private JPanel panel_3;
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
	public assetScreen() {
		setLayout(null);
		
		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 11, 160, 539);
		add(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(323, 415, 451, 135);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(518, 75, 127, 313);
		add(panel_3);
		panel_3.setLayout(null);
		
		lblIdentifier = new JLabel("Identifier:");
		lblIdentifier.setBounds(5, 5, 90, 14);
		panel_3.add(lblIdentifier);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(5, 19, 90, 14);
		panel_3.add(lblName);
		
		lblOwner = new JLabel("Owner:");
		lblOwner.setBounds(8, 32, 36, 14);
		panel_3.add(lblOwner);
		
		lblCustodian = new JLabel("Custodian:");
		lblCustodian.setBounds(6, 46, 52, 14);
		panel_3.add(lblCustodian);
		
		lblType = new JLabel("Type:");
		lblType.setBounds(7, 65, 28, 14);
		panel_3.add(lblType);
		
		lblDateAcquired = new JLabel("Date acquired:");
		lblDateAcquired.setBounds(7, 81, 71, 14);
		panel_3.add(lblDateAcquired);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(43, 100, 35, 14);
		panel_3.add(lblStatus);
		
		lblMaintenance = new JLabel("Maintenance Schedule:");
		lblMaintenance.setBounds(6, 115, 111, 14);
		panel_3.add(lblMaintenance);
		
		lblFinancialValue = new JLabel("Financial Value:");
		lblFinancialValue.setBounds(6, 138, 74, 14);
		panel_3.add(lblFinancialValue);
		
		lblConfidentialValue = new JLabel("Confidential Value:");
		lblConfidentialValue.setBounds(17, 158, 90, 14);
		panel_3.add(lblConfidentialValue);
		
		lblIntegrityValue = new JLabel("Integrity Value:");
		lblIntegrityValue.setBounds(5, 176, 75, 14);
		panel_3.add(lblIntegrityValue);
		
		lblAvailabilityValue = new JLabel("Availability Value:");
		lblAvailabilityValue.setBounds(11, 195, 84, 14);
		panel_3.add(lblAvailabilityValue);
		
		lblClassification = new JLabel("Classification:");
		lblClassification.setBounds(10, 214, 66, 14);
		panel_3.add(lblClassification);
		
		lblStorageLocation = new JLabel("Storage Location:");
		lblStorageLocation.setBounds(6, 229, 85, 14);
		panel_3.add(lblStorageLocation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(180, 45, 127, 313);
		add(panel_2);
		
		JLabel label = new JLabel("Identifier:");
		label.setBounds(5, 5, 48, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(5, 19, 31, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Owner:");
		label_2.setBounds(8, 32, 36, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Custodian:");
		label_3.setBounds(6, 46, 52, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Type:");
		label_4.setBounds(7, 65, 28, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Date acquired:");
		label_5.setBounds(7, 81, 71, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Status:");
		label_6.setBounds(43, 100, 35, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Maintenance Schedule:");
		label_7.setBounds(6, 115, 111, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Financial Value:");
		label_8.setBounds(6, 138, 74, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Confidential Value:");
		label_9.setBounds(17, 158, 90, 14);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Integrity Value:");
		label_10.setBounds(5, 176, 75, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Availability Value:");
		label_11.setBounds(11, 195, 84, 14);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Classification:");
		label_12.setBounds(10, 214, 66, 14);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Storage Location:");
		label_13.setBounds(6, 229, 85, 14);
		panel_2.add(label_13);
		
		JButton btnAddAsset = new JButton("Add Asset");
		btnAddAsset.setBounds(180, 11, 89, 23);
		add(btnAddAsset);
		
		JButton btnUpdateAsset = new JButton("Update Asset");
		btnUpdateAsset.setBounds(279, 11, 104, 23);
		add(btnUpdateAsset);
		
		db = new DBConnection();
		updateAssetTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				updateLabels();
			}
		});
		
	}
	
	public void updateAssetTable() {
		db.open();
		ResultSet rs = db.executeQuery(db.c, "select identifier,name from asset;");
		try {
			table.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

	}
	public void updateLabels(){
		if(table.getSelectedRow()==-1)
			return;
		
		int selectedIdentifier = (int)table.getModel().getValueAt(table.getSelectedRow(), 0);
		System.out.println("Selected asset's identifier: "+selectedIdentifier);
		
		db.open();
		ResultSet rs = db.executeQuery(db.c,"select * from asset where identifier ="+selectedIdentifier+";");
		System.out.println("passed rs");
		try {
			while(rs.next()){
				System.out.println(rs.getInt("identifier"));
				System.out.println(rs.getString("identifier"));
				//lblIdentifier.setText(rs.getString("identifier"));
				lblIdentifier.setText(rs.getString("identifier"));
				lblName.setText(rs.getString("name"));
				lblOwner.setText(rs.getString("ownerID"));
				lblCustodian.setText(rs.getString("custodianID"));
				lblType.setText(rs.getString("typeID"));
				lblDateAcquired.setText(rs.getString("dateAcquired"));
				lblStatus.setText(rs.getString("status"));
				lblMaintenance.setText(rs.getString("maintID"));
				lblFinancialValue.setText(rs.getString("financialValue"));
				lblConfidentialValue.setText(rs.getString("confidentialValue"));
				lblIntegrityValue.setText(rs.getString("integrityValue"));
				lblAvailabilityValue.setText(rs.getString("availabilityValue"));
				lblClassification.setText(rs.getString("classID"));
				lblStorageLocation.setText(rs.getString("storageID"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}
}
