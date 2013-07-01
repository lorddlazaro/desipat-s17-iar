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


public class assetScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	DBConnection db;
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
	public assetScreen() {
		setLayout(null);
		
		table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 11, 205, 432);
		add(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(225, 228, 537, 215);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JButton btnAddAsset = new JButton("Add Asset");
		btnAddAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToAddAssetScreen();
			}
		});
		btnAddAsset.setBounds(225, 11, 127, 23);
		add(btnAddAsset);
		
		JButton btnUpdateAsset = new JButton("Update Asset");
		btnUpdateAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToEditAssetScreen();
			}
		});
		btnUpdateAsset.setBounds(362, 11, 127, 23);
		add(btnUpdateAsset);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(225, 46, 537, 171);
		add(panel_4);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(100dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(124dlu;default)"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Identifier:");
		panel_4.add(label, "2, 2");
		
		lblIdentifier = new JLabel("");
		panel_4.add(lblIdentifier, "4, 2");
		
		JLabel label_7 = new JLabel("Maintenance Schedule:");
		panel_4.add(label_7, "6, 2");
		
		lblMaintenance = new JLabel("");
		panel_4.add(lblMaintenance, "8, 2");
		
		JLabel label_1 = new JLabel("Name:");
		panel_4.add(label_1, "2, 4");
		
		lblName = new JLabel("");
		panel_4.add(lblName, "4, 4");
		
		JLabel label_8 = new JLabel("Financial Value:");
		panel_4.add(label_8, "6, 4");
		
		lblFinancialValue = new JLabel("");
		panel_4.add(lblFinancialValue, "8, 4");
		
		JLabel label_2 = new JLabel("Owner:");
		panel_4.add(label_2, "2, 6");
		
		lblOwner = new JLabel("");
		panel_4.add(lblOwner, "4, 6");
		
		JLabel label_9 = new JLabel("Confidential Value:");
		panel_4.add(label_9, "6, 6");
		
		lblConfidentialValue = new JLabel("");
		panel_4.add(lblConfidentialValue, "8, 6");
		
		JLabel label_3 = new JLabel("Custodian:");
		panel_4.add(label_3, "2, 8");
		
		lblCustodian = new JLabel("");
		panel_4.add(lblCustodian, "4, 8");
		
		JLabel label_10 = new JLabel("Integrity Value:");
		panel_4.add(label_10, "6, 8");
		
		lblIntegrityValue = new JLabel("");
		panel_4.add(lblIntegrityValue, "8, 8");
		
		JLabel label_4 = new JLabel("Type:");
		panel_4.add(label_4, "2, 10");
		
		lblType = new JLabel("");
		panel_4.add(lblType, "4, 10");
		
		JLabel label_11 = new JLabel("Availability Value:");
		panel_4.add(label_11, "6, 10");
		
		lblAvailabilityValue = new JLabel("");
		panel_4.add(lblAvailabilityValue, "8, 10");
		
		JLabel label_5 = new JLabel("Date acquired:");
		panel_4.add(label_5, "2, 12");
		
		lblDateAcquired = new JLabel("");
		panel_4.add(lblDateAcquired, "4, 12");
		
		JLabel label_13 = new JLabel("Storage Location:");
		panel_4.add(label_13, "6, 12");
		
		lblClassification = new JLabel("");
		panel_4.add(lblClassification, "8, 12");
		
		JLabel label_6 = new JLabel("Status:");
		panel_4.add(label_6, "2, 14");
		
		lblStatus = new JLabel("");
		panel_4.add(lblStatus, "4, 14");
		
		JLabel label_12 = new JLabel("Classification:");
		panel_4.add(label_12, "6, 14");
		
		lblStorageLocation = new JLabel("");
		panel_4.add(lblStorageLocation, "8, 14");
		
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
		ResultSet rs = db.executeQuery(db.c,"select identifier, name, Concat(P.firstName, ' ',P.middleInitial,'. ', P.lastName) as owner, Concat(C.firstName, ' ',C.middleInitial,'. ', C.lastName) as custodian, type,dateAcquired,status, M.maintSched,  financialValue, confidentialValue,integrityValue,availabilityValue, L.classification, S.storageLocation from asset A inner join person P on P.personID=A.ownerID inner join person C on C.personID=A.custodianID inner join typelookup T on T.typeID=A.typeID inner join maintenancelookup M on M.maintID=A.maintID inner join classificationlookup L on L.classID=A.classID inner join storage S on S.storageID=A.storageID where identifier="+selectedIdentifier);
		
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
		db.close();
	}
	
	private void goToAddAssetScreen(){
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		mainScreen.changeCard((JPanel)mainScreen.panelCards, "panelAddAsset");
	}
	private void goToEditAssetScreen(){
		MainScreen mainScreen = (MainScreen)SwingUtilities.getWindowAncestor(this);
		mainScreen.changeCard((JPanel)mainScreen.panelCards, "panelEditAsset");
	}
}
