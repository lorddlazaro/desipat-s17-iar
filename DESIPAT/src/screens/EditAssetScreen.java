package screens;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;

import screenBehaviourStrategy.AddAssetScreenBehavior;
import screenBehaviourStrategy.AssetScreenBehaviorStrategy;
import screenBehaviourStrategy.EditAssetScreenBehavior;

import java.awt.SystemColor;


public class EditAssetScreen extends AddAssetScreen {

	public EditAssetScreen(AssetScreenBehaviorStrategy behaviour) {
		super(behaviour);
		// TODO Auto-generated constructor stub
	}

	/*private JTextField txtName;
	private JTextField txtFinancial;
	private JSlider sldConfidentiality;
	private JSlider sldIntegrity;
	private JSlider sldAvailability;
	private JComboBox cbxMonth;
	private JComboBox cbxDay;
	private JComboBox cbxYear;
	private JComboBox cbxType;
	private JComboBox cbxStorage;
	private JComboBox cbxClassification;
	private JComboBox cbxMaintenance;
	private JComboBox cbxOwner;
	private JComboBox cbxCustodian;


	private JTextField txtRetention;
	AssetScreenBehaviorStrategy behaviour;
	public EditAssetScreen(EditAssetScreenBehavior behaviour){
		this.behaviour=behaviour;
		initialize();
	}
	
	public void initialize() {
		//behaviour=new EditAssetScreenBehavior();
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		//asset=a;
		//this.personList=personList;
		//this.storageList=storageList;
		JLabel lblAddNewAsset = new JLabel("Edit Asset");
		lblAddNewAsset.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAddNewAsset.setBounds(10, 11, 168, 29);
		add(lblAddNewAsset);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOwner.setBounds(50, 268, 46, 14);
		add(lblOwner);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblName.setBounds(50, 76, 46, 14);
		add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblType.setBounds(50, 352, 46, 14);
		add(lblType);
		
		JLabel lblMaintenanceSchedule = new JLabel("Maintenance Schedule");
		lblMaintenanceSchedule.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMaintenanceSchedule.setBounds(50, 225, 143, 14);
		add(lblMaintenanceSchedule);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(410, 51, 46, 14);
		add(lblValue);
		
		JLabel lblConfidentiality = new JLabel("Confidentiality:");
		lblConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblConfidentiality.setBounds(433, 106, 88, 14);
		add(lblConfidentiality);
		
		JLabel lblIntegrity = new JLabel("Integrity:");
		lblIntegrity.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblIntegrity.setBounds(433, 151, 88, 14);
		add(lblIntegrity);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAvailability.setBounds(431, 194, 88, 14);
		add(lblAvailability);
		
		JLabel lblFinancial = new JLabel("Financial:");
		lblFinancial.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFinancial.setBounds(433, 76, 88, 14);
		add(lblFinancial);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(30, 51, 148, 14);
		add(lblBasicInformation);
		

		
		JLabel lblCustodian = new JLabel("Custodian");
		lblCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCustodian.setBounds(50, 310, 88, 14);
		add(lblCustodian);
		
		JLabel lblStorageLocation = new JLabel("Storage Location");
		lblStorageLocation.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStorageLocation.setBounds(50, 393, 115, 14);
		add(lblStorageLocation);
		
		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblClassification.setBounds(50, 139, 88, 14);
		add(lblClassification);


		cbxType = new JComboBox();
		cbxType.setModel(new DefaultComboBoxModel(new String[] {"Document", "Equipment", "Product"}));
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxType.setBounds(194, 349, 174, 20);
		add(cbxType);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtName.setBounds(194, 73, 174, 20);
		add(txtName);
		txtName.setColumns(10);
		
		sldConfidentiality = new JSlider();
		sldConfidentiality.setMajorTickSpacing(1);
		sldConfidentiality.setBackground(SystemColor.inactiveCaption);
		sldConfidentiality.setPaintTicks(true);
		sldConfidentiality.setMinimum(1);
		sldConfidentiality.setValue(0);
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(531, 106, 197, 29);
		add(sldConfidentiality);
		
		sldIntegrity = new JSlider();
		sldIntegrity.setMajorTickSpacing(1);
		sldIntegrity.setBackground(SystemColor.inactiveCaption);
		sldIntegrity.setPaintTicks(true);
		sldIntegrity.setMinimum(1);
		sldIntegrity.setMaximum(5);
		sldIntegrity.setValue(0);
		sldIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldIntegrity.setBounds(531, 151, 197, 29);
		add(sldIntegrity);
		
		sldAvailability = new JSlider();
		sldAvailability.setBackground(SystemColor.inactiveCaption);
		sldAvailability.setMinimum(1);
		sldAvailability.setMajorTickSpacing(1);
		sldAvailability.setPaintTicks(true);
		sldAvailability.setPaintLabels(true);
		sldAvailability.setValue(0);
		sldAvailability.setMaximum(5);
		sldAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldAvailability.setBounds(531, 192, 195, 47);
		add(sldAvailability);
		
		txtFinancial = new JTextField();
		txtFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFinancial.setBounds(531, 74, 195, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);
		
		cbxStorage = new JComboBox();
		cbxStorage.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxStorage.setBounds(194, 390, 174, 20);
		add(cbxStorage);
		
		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential"}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxClassification.setBounds(194, 133, 174, 20);
		add(cbxClassification);
		
		cbxMaintenance = new JComboBox();
		cbxMaintenance.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly", "Yearly"}));
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxMaintenance.setBounds(194, 222, 174, 20);
		add(cbxMaintenance);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDateAcquired.setBounds(50, 170, 88, 14);
		add(lblDateAcquired);

		cbxMonth = new JComboBox();
		cbxMonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED)
				{
				}
			}
		});
		cbxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		cbxMonth.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxMonth.setBounds(136, 171, 96, 20);
		add(cbxMonth);
		
		cbxDay = new JComboBox();
		cbxDay.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxDay.setBounds(244, 171, 53, 20);
		add(cbxDay);
		
		cbxYear = new JComboBox();
		ArrayList<String>yearList=new ArrayList<String>();
		for(int year=1900;year<=2050;year++)
		{
			yearList.add(year+"");
		}
		String[] years=yearList.toArray(new String[yearList.size()]);
		cbxYear.setModel(new DefaultComboBoxModel(years));
		cbxYear.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxYear.setBounds(309, 171, 59, 20);
		add(cbxYear);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMonth.setBounds(151, 191, 46, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDay.setBounds(257, 191, 32, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblYear.setBounds(316, 191, 46, 14);
		add(lblYear);
		
		JButton btnEdit = new JButton("Save Changes");
		btnEdit.setBackground(SystemColor.activeCaption);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEdit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEdit.setBounds(583, 406, 179, 37);
		add(btnEdit);
		
		cbxOwner = new JComboBox();
		cbxOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxOwner.setBounds(194, 265, 174, 20);
		add(cbxOwner);
		
		cbxCustodian = new JComboBox();
		cbxCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		cbxCustodian.setBounds(194, 307, 174, 20);
		add(cbxCustodian);
		
	
	}
	
	public void refresh(){}*/

}

