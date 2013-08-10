package screens;
import screenBehaviourStrategy.AddTypeScreenBehavior;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import screens.EditAssetScreen;
import screens.AddPersonScreen;

import dataObjects.Asset;

import screenBehaviourStrategy.AddAssetScreenBehavior;
import screenBehaviourStrategy.AddPersonScreenBehaviour;
import screenBehaviourStrategy.AddStorageScreenBehavior;
import screenBehaviourStrategy.AssetScreenBehaviorStrategy;
import screenBehaviourStrategy.EditAssetScreenBehavior;


public class AddAssetScreen extends JPanel implements TableObserver {
	private JTextField txtName;
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
	
	/*private JTextField textFieldNewItem2;
	private JTextField textFieldNewItem3;
	private JTextField textFieldNewItem1;*/
	private JButton btnNewOwner;
	private JButton btnNewCustodian;
	private JButton btnNewType;
	private JButton btnNewStorage;
	private JPanel panelNewItem;
	
	/*private JLabel lblNewItem2;
	private JLabel lblNewItem1;
	private JLabel lblNewItem3;
	private JButton btnNewItemSave;
	private JButton btnNewItemCancel;*/
	protected JLabel lblAddNewAsset;
	
	private DateFormat dateFormat;

	AssetScreenBehaviorStrategy behaviour;
	
	public AddAssetScreen(AssetScreenBehaviorStrategy behaviour){
		this.behaviour=behaviour;
		initialize();
	}
	
	public void initialize() {
		//behaviour=new AddAssetScreenBehavior();
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		lblAddNewAsset = new JLabel("Add New Asset");
		lblAddNewAsset.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		lblAddNewAsset.setBounds(10, 11, 168, 29);
		add(lblAddNewAsset);
		
		JLabel lblBasicInformation = new JLabel("Basic Information");
		lblBasicInformation.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBasicInformation.setBounds(42, 51, 168, 14);
		add(lblBasicInformation);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblName.setBounds(62, 79, 46, 14);
		add(lblName);
		
		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblClassification.setBounds(62, 143, 88, 14);
		add(lblClassification);
		
		JLabel lblDateAcquired = new JLabel("Date Acquired");
		lblDateAcquired.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDateAcquired.setBounds(62, 182, 88, 14);
		add(lblDateAcquired);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMonth.setBounds(186, 201, 46, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDay.setBounds(272, 201, 32, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblYear.setBounds(329, 201, 46, 14);
		add(lblYear);
		
		JLabel lblMaintenanceSchedule = new JLabel("Maintenance Schedule");
		lblMaintenanceSchedule.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblMaintenanceSchedule.setBounds(62, 407, 148, 14);
		add(lblMaintenanceSchedule);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValue.setBounds(418, 51, 46, 14);
		add(lblValue);
		
		JLabel lblFinancial = new JLabel("Financial");
		lblFinancial.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFinancial.setBounds(446, 79, 88, 14);
		add(lblFinancial);
		
		JLabel lblConfidentiality = new JLabel("Confidentiality");
		lblConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblConfidentiality.setBounds(446, 109, 99, 14);
		add(lblConfidentiality);
		
		JLabel lblIntegrity = new JLabel("Integrity");
		lblIntegrity.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblIntegrity.setBounds(446, 140, 99, 14);
		add(lblIntegrity);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAvailability.setBounds(446, 172, 99, 14);
		add(lblAvailability);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblType.setBounds(62, 328, 46, 14);
		add(lblType);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOwner.setBounds(62, 249, 46, 14);
		add(lblOwner);
		
		JLabel lblCustodian = new JLabel("Custodian");
		lblCustodian.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCustodian.setBounds(62, 289, 88, 14);
		add(lblCustodian);
		
		JLabel lblStorageLocation = new JLabel("Storage Location");
		lblStorageLocation.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStorageLocation.setBounds(62, 368, 100, 14);
		add(lblStorageLocation);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtName.setBounds(201, 77, 156, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtFinancial = new JTextField();
		txtFinancial.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFinancial.setBounds(555, 77, 192, 20);
		add(txtFinancial);
		txtFinancial.setColumns(10);
		
		cbxClassification = new JComboBox();
		cbxClassification.setModel(new DefaultComboBoxModel(new String[] {"Public", "Internal", "Sensitive", "Confidential", ""}));
		cbxClassification.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxClassification.setBounds(201, 141, 156, 20);
		add(cbxClassification);
		
		cbxMonth = new JComboBox();
		//cbxMonth.addItemListener(new ItemListener() ;
		cbxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		cbxMonth.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMonth.setBounds(183, 182, 88, 20);
		add(cbxMonth);
		
		cbxDay = new JComboBox();
		ArrayList <String> dayList=new ArrayList<String>();
		for (int i = 1; i <= 31; i++)
			dayList.add(i+"");
		String[]days=dayList.toArray(new String[dayList.size()]);
		cbxDay.setModel(new DefaultComboBoxModel(days));
		cbxDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxDay.setBounds(272, 182, 55, 20);
		add(cbxDay);
		
		cbxYear = new JComboBox();
		
		ArrayList<String>yearList=new ArrayList<String>();
		for(int year=1900;year<=2050;year++)
		{
			yearList.add(year+"");
		}
		String[] years=yearList.toArray(new String[yearList.size()]);
		cbxYear.setModel(new DefaultComboBoxModel(years));
		cbxYear.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxYear.setBounds(328, 182, 64, 20);
		add(cbxYear);
		
		cbxMaintenance = new JComboBox();
		cbxMaintenance.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly", "Yearly"}));
		cbxMaintenance.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxMaintenance.setBounds(201, 405, 156, 20);
		add(cbxMaintenance);
		
		sldConfidentiality = new JSlider();
		sldConfidentiality.setBackground(SystemColor.inactiveCaption);
		sldConfidentiality.setPaintTicks(true);
		sldConfidentiality.setMajorTickSpacing(1);
		sldConfidentiality.setMinimum(1);
		sldConfidentiality.setMaximum(5);
		sldConfidentiality.setValue(0);
		sldConfidentiality.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldConfidentiality.setBounds(555, 107, 195, 29);
		add(sldConfidentiality);
		
		sldIntegrity = new JSlider();
		sldIntegrity.setBackground(SystemColor.inactiveCaption);
		sldIntegrity.setPaintTicks(true);
		sldIntegrity.setMajorTickSpacing(1);
		sldIntegrity.setMinimum(1);
		sldIntegrity.setValue(0);
		sldIntegrity.setMaximum(5);
		sldIntegrity.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldIntegrity.setBounds(555, 137, 195, 29);
		add(sldIntegrity);
		
		sldAvailability = new JSlider();
		sldAvailability.setBackground(SystemColor.inactiveCaption);
		sldAvailability.setPaintLabels(true);
		sldAvailability.setPaintTicks(true);
		sldAvailability.setMajorTickSpacing(1);
		sldAvailability.setMinimum(1);
		sldAvailability.setValue(0);
		sldAvailability.setMaximum(5);
		sldAvailability.setFont(new Font("Calibri", Font.PLAIN, 12));
		sldAvailability.setBounds(555, 168, 195, 47);
		add(sldAvailability);
		
		cbxType = new JComboBox();
		cbxType.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxType.setBounds(201, 326, 156, 20);
		add(cbxType);
		
		cbxOwner = new JComboBox();
		cbxOwner.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxOwner.setBounds(201, 247, 156, 20);
		add(cbxOwner);
		
		cbxCustodian = new JComboBox();
		cbxCustodian.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCustodian.setBounds(201, 287, 156, 20);
		add(cbxCustodian);
		
		
		
		cbxStorage = new JComboBox();
		cbxStorage.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxStorage.setBounds(201, 366, 156, 20);
		add(cbxStorage);
		
		
		btnNewOwner = new JButton("New");
		btnNewOwner.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(0);
				panelNewItem = new AddPersonScreenBehaviour().getView(); 
				panelNewItem.setName("Add Owner");
				//panelNewItem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			
			}
		}) ;
		btnNewOwner.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewOwner.setBounds(367, 247, 70, 20);
		add(btnNewOwner);
		
		btnNewCustodian = new JButton("New");
		btnNewCustodian.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(1);
			panelNewItem = new AddPersonScreenBehaviour().getView(); 
			panelNewItem.setName("Add Custodian");
			panelNewItem.setBounds(447, 248, 315, 137);
			add(panelNewItem);
			
			
			}
		});
		btnNewCustodian.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewCustodian.setBounds(367, 287, 70, 20);
		add(btnNewCustodian);
		
		btnNewType = new JButton("New");
		btnNewType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(2);
				panelNewItem = new AddTypeScreenBehavior().getView(); 
				//panelNewItem.setName("Add Type");
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			}
		});
		btnNewType.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewType.setBounds(367, 326, 70, 20);
		add(btnNewType);
		
		btnNewStorage = new JButton("New");
		btnNewStorage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
			//behaviour.setNewItemPanel(3);
				panelNewItem = new AddStorageScreenBehavior().getView(); 
				//panelNewItem.setName("Add Storage");
				panelNewItem.setBounds(447, 248, 315, 137);
				add(panelNewItem);
			}
		});
		btnNewStorage.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewStorage.setBounds(367, 366, 70, 20);
		add(btnNewStorage);
		
		JButton btnAdd = new JButton("Add Asset");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Asset a = null;
				String dateAcquired = cbxYear.getSelectedItem() + "-" + (cbxMonth.getSelectedIndex()+1) + "-" + cbxDay.getSelectedItem();
				try {
					a =new Asset(txtName.getText(), cbxOwner.getSelectedIndex(),cbxCustodian.getSelectedIndex(),cbxType.getSelectedIndex(),cbxMaintenance.getSelectedIndex(),cbxClassification.getSelectedIndex(),cbxStorage.getSelectedIndex(),0 ,(Date) dateFormat.parse(dateAcquired), Float.parseFloat(txtFinancial.getText()),sldConfidentiality.getValue(),sldIntegrity.getValue(),sldAvailability.getValue());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//int periodID, Date dateAcquired,){
				behaviour.saveAsset(a);
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAdd.setBounds(583, 406, 179, 37);
		add(btnAdd);
		
		/*panelNewItem = new JPanel();
		panelNewItem.setVisible(false);
		panelNewItem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelNewItem.setBounds(447, 248, 315, 137);
		add(panelNewItem);
		panelNewItem.setLayout(null);*/
		
		/*textFieldNewItem1 = new JTextField();
		textFieldNewItem1.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem1.setBounds(126, 8, 179, 20);
		panelNewItem.add(textFieldNewItem1);
		textFieldNewItem1.setColumns(10);
		
		textFieldNewItem2 = new JTextField();
		textFieldNewItem2.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem2.setBounds(126, 39, 179, 20);
		panelNewItem.add(textFieldNewItem2);
		textFieldNewItem2.setColumns(10);
		
		textFieldNewItem3 = new JTextField();
		textFieldNewItem3.setFont(new Font("Calibri", Font.PLAIN, 13));
		textFieldNewItem3.setBounds(126, 70, 179, 20);
		panelNewItem.add(textFieldNewItem3);
		textFieldNewItem3.setColumns(10);*/
		
		/*btnNewItemCancel = new JButton("Cancel");
		btnNewItemCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				behaviour.cancel();
			}
		});
		btnNewItemCancel.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewItemCancel.setBounds(126, 106, 85, 20);
		panelNewItem.add(btnNewItemCancel);
		
		btnNewItemSave = new JButton("Save");
		btnNewItemSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				
				behaviour.saveItem();
			}
		});
		btnNewItemSave.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNewItemSave.setBounds(222, 106, 70, 20);
		panelNewItem.add(btnNewItemSave);*/
		
		/*lblNewItem1 = new JLabel("Storage Location");
		lblNewItem1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem1.setBounds(10, 8, 106, 14);
		panelNewItem.add(lblNewItem1);
		
		lblNewItem2 = new JLabel("<label>");
		lblNewItem2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem2.setBounds(10, 39, 93, 14);
		panelNewItem.add(lblNewItem2);
		
		lblNewItem3 = new JLabel("<label>");
		lblNewItem3.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewItem3.setBounds(10, 70, 93, 14);
		panelNewItem.add(lblNewItem3);*/

	}
	
	public void refresh(){
		//update comboboxes
	}
}