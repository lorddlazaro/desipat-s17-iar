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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;


public class assetScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	DBConnectionFactory db;
	private Connection conn;
	private JTable table;
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
	public assetScreen() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 205, 382);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				updateLabels();
			}
		});
		
		JButton btnAddAsset = new JButton("Add Asset");
		btnAddAsset.setBackground(SystemColor.activeCaption);
		btnAddAsset.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnAddAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToAddAssetScreen();
			}
		});
		btnAddAsset.setBounds(10, 11, 205, 39);
		add(btnAddAsset);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(225, 11, 537, 206);
		add(panel_4);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(73dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Identifier:");
		label.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label, "2, 2");
		
		lblIdentifier = new JLabel("");
		panel_4.add(lblIdentifier, "4, 2");
		
		JLabel label_7 = new JLabel("Maintenance Schedule:");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_7, "6, 2");
		
		lblMaintenance = new JLabel("");
		panel_4.add(lblMaintenance, "8, 2");
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_1, "2, 4");
		
		lblName = new JLabel("");
		panel_4.add(lblName, "4, 4");
		
		JLabel label_8 = new JLabel("Financial Value:");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_8, "6, 4");
		
		lblFinancialValue = new JLabel("");
		panel_4.add(lblFinancialValue, "8, 4");
		
		JLabel label_2 = new JLabel("Owner:");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_2, "2, 6");
		
		lblOwner = new JLabel("");
		panel_4.add(lblOwner, "4, 6");
		
		JLabel label_9 = new JLabel("Confidential Value:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_9, "6, 6");
		
		lblConfidentialValue = new JLabel("");
		panel_4.add(lblConfidentialValue, "8, 6");
		
		JLabel label_3 = new JLabel("Custodian:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_3, "2, 8");
		
		lblCustodian = new JLabel("");
		panel_4.add(lblCustodian, "4, 8");
		
		JLabel label_10 = new JLabel("Integrity Value:");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_10, "6, 8");
		
		lblIntegrityValue = new JLabel("");
		panel_4.add(lblIntegrityValue, "8, 8");
		
		JLabel label_4 = new JLabel("Type:");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_4, "2, 10");
		
		lblType = new JLabel("");
		panel_4.add(lblType, "4, 10");
		
		JLabel label_11 = new JLabel("Availability Value:");
		label_11.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_11, "6, 10");
		
		lblAvailabilityValue = new JLabel("");
		panel_4.add(lblAvailabilityValue, "8, 10");
		
		JLabel label_5 = new JLabel("Date acquired:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_5, "2, 12");
		
		lblDateAcquired = new JLabel("");
		panel_4.add(lblDateAcquired, "4, 12");
		
		JLabel label_12 = new JLabel("Classification:");
		label_12.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_12, "6, 12");
		
		lblClassification = new JLabel("");
		panel_4.add(lblClassification, "8, 12");
		
		JLabel label_6 = new JLabel("Status:");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_6, "2, 14");
		
		lblStatus = new JLabel("");
		panel_4.add(lblStatus, "4, 14");
		
		JLabel label_13 = new JLabel("Storage Location:");
		label_13.setFont(new Font("Calibri", Font.PLAIN, 13));
		panel_4.add(label_13, "6, 14");
		
		lblStorageLocation = new JLabel("");
		panel_4.add(lblStorageLocation, "8, 14");
		
		JButton btnUpdateAsset = new JButton("Update Asset");
		btnUpdateAsset.setBackground(SystemColor.activeCaption);
		panel_4.add(btnUpdateAsset, "8, 16");
		btnUpdateAsset.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnUpdateAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToEditAssetScreen();
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
		
		db = new DBConnection();
		updateAssetTable();
		
	}
	
	public void updateAssetTable() {
		System.out.println("before query1");
		Connection conn = db.openConnection();
		System.out.println("before query");
		ResultSet rs = db.executeQuery(conn, "select identifier,name from asset;");
		try {
			table.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();
	    System.out.println("metadatacount: "+metaData.getColumnCount());
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	        System.out.println(metaData.getColumnName(column));
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
		
		Connection conn = db.openConnection();
		ResultSet rs = db.executeQuery(conn,"select identifier, name, Concat(P.firstName, ' ',P.middleInitial,'. ', P.lastName) as owner, Concat(C.firstName, ' ',C.middleInitial,'. ', C.lastName) as custodian, type,dateAcquired,status, M.maintSched,  financialValue, confidentialValue,integrityValue,availabilityValue, L.classification, S.storageLocation from asset A inner join person P on P.personID=A.ownerID inner join person C on C.personID=A.custodianID inner join typelookup T on T.typeID=A.typeID inner join maintenancelookup M on M.maintID=A.maintID inner join classificationlookup L on L.classID=A.classID inner join storage S on S.storageID=A.storageID where identifier="+selectedIdentifier);
		
		System.out.println("passed rs");
		try {
			while(rs.next()){
				System.out.println(rs.getInt("identifier"));
				System.out.println(rs.getString("identifier"));
				//lblIdentifier.setText(rs.getString("identifier"));
				lblIdentifier.setText(rs.getString("identifier"));
				lblName.setText(rs.getString("name"));

				lblOwner.setText(rs.getString("owner"));
				
				lblCustodian.setText(rs.getString("custodian"));
				lblType.setText(rs.getString("type"));
				lblDateAcquired.setText(rs.getString("dateAcquired"));
				lblStatus.setText(rs.getString("status"));
				lblMaintenance.setText(rs.getString("maintSched"));
				lblFinancialValue.setText(rs.getString("financialValue"));
				lblConfidentialValue.setText(rs.getString("confidentialValue"));
				lblIntegrityValue.setText(rs.getString("integrityValue"));
				lblAvailabilityValue.setText(rs.getString("availabilityValue"));
				lblClassification.setText(rs.getString("classification"));
				lblStorageLocation.setText(rs.getString("storageLocation"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
		fillTableAssetChangeLog();
	}
	
	private void goToAddAssetScreen(){
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		mainScreen.changeCard((JPanel)mainScreen.panelCards, "panelAddAsset");
		
	}
	private void goToEditAssetScreen(){
		
		if(table.getSelectedRow()==-1)
			return;
		int selectedIdentifier=(int)table.getModel().getValueAt(table.getSelectedRow(), 0);
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		
		mainScreen.panelEditAsset.setAssetID(selectedIdentifier);
		mainScreen.panelEditAsset.fillComboBoxPerson();
		mainScreen.panelEditAsset.fillComboBoxStorage();
		mainScreen.panelEditAsset.loadCurrentAssetInfo();
		System.out.println("Selected asset's identifier: "+selectedIdentifier);
		
		mainScreen.changeCard((JPanel)mainScreen.panelCards, "panelEditAsset");
	}
	
	public void fillTableAssetChangeLog(){
		if(table.getSelectedRow()==-1)
			return;
		int selectedIdentifier=(int)table.getModel().getValueAt(table.getSelectedRow(), 0);
		
		conn = db.openConnection();
		DefaultTableModel model = (DefaultTableModel)changeLogTable.getModel();
		while(model.getRowCount() > 0)
			model.removeRow(0);
		String query="";
		try {
			query = "SELECT u.username, al.actionDate, al.actionTime, acl.assetfield, acl.oldvalue, acl.newvalue  FROM UserAccount AS u, ActionLog AS al, assetchangelog as acl, asset as a WHERE u.userID = al.userID and acl.actionid = al.actionid and a.identifier = acl.assetid and  a.identifier ="+selectedIdentifier+";";
			ResultSet rs = db.executeQuery(conn, query);
			if (rs.isBeforeFirst()) {
				rs.first();
				while (!rs.isAfterLast()) {
					model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6)});
					rs.next();
				}
			}

			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(query);
	}
}
