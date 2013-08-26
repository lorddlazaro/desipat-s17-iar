package dataObjects;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Asset extends TableEntry{
	public final static int NAME_INDEX = 1;
	public final static int OWNERID_INDEX = 2;
	public final static int CUSTODIANID_INDEX = 3;
	public final static int TYPEID_INDEX = 4;
	public final static int MAINTID_INDEX = 5;
	public final static int CLASSID_INDEX = 6;
	public final static int STORAGEID_INDEX = 7;
	public final static int PERIODID_INDEX = 8;
	public final static int DATEACQUIRED_INDEX = 9;
	public final static int FINANCIALVALUE_INDEX = 10;
	public final static int CONFIDENTIALVALUE_INDEX = 11;
	public final static int INTEGRITYVALUE_INDEX = 12;
	public final static int AVAILABILITYVALUE_INDEX = 13;
	
	private String name;
	private int ownerID;
	private int custodianID;
	private int typeID;
	private int maintID;
	private int classID;
	private int storageID;
	private int periodID;
	private String dateAcquired;
	private double financialValue;
	private int confidentialValue;
	private int integrityValue;
	private  int availabilityValue;

	public Asset(String name, int ownerID, int custodianID, int typeID, int maintID, int classID, int storageID, int periodID, String dateAcquired, double financialValue, int confidentialValue, int integrityValue, int availabilityValue){
		 //TODO 
		 setID(-1);
		 setName(name);
		 setOwnerID(ownerID);
		 setCustodianID(custodianID);
		 setTypeID(typeID);
		 setMaintID(maintID);
		 setClassID(classID);
		 setStorageID(storageID);
		 setPeriodID(periodID);
		 setDateAcquired(dateAcquired);
		 setFinancialValue(financialValue);
		 setConfidentialValue(confidentialValue);
		 setIntegrityValue(integrityValue);
		 setAvailabilityValue(availabilityValue);
	}
	
	public Asset(int ID, String name, int ownerID, int custodianID, int typeID, int maintID, int classID, int storageID, int periodID, String dateAcquired,  double financialValue, int confidentialValue, int integrityValue, int availabilityValue){
		 setID(ID);
		 setName(name);
		 setOwnerID(ownerID);
		 setCustodianID(custodianID);
		 setTypeID(typeID);
		 setMaintID(maintID);
		 setClassID(classID);
		 setStorageID(storageID);
		 setPeriodID(periodID);
		 setDateAcquired(dateAcquired);
		 setFinancialValue(financialValue);
		 setConfidentialValue(confidentialValue);
		 setIntegrityValue(integrityValue);
		 setAvailabilityValue(availabilityValue);
	}
	
	@Override
	public boolean equals(Object o){
		Asset other = (Asset)o;
		
		if(!name.equals(other.getName()))
			return false;
		if(ownerID != other.getOwnerID())
			return false;
		if(custodianID != other.getCustodianID())
			return false;
		if(typeID != other.getTypeID())
			return false;
		if(maintID != other.getMaintID())
			return false;
		if(classID != other.getClassID())
			return false;
		if(storageID != other.getStorageID())
			return false;
		if(periodID != other.getPeriodID())
			return false;
		
		System.out.println("YO2");
		
		System.out.println(Date.valueOf(dateAcquired)+" vs "+(Date.valueOf(other.getDateAcquired())));
		if(!Date.valueOf(dateAcquired).equals(Date.valueOf(other.getDateAcquired())))
			return false;
		
		System.out.println("YO");
		
		if(financialValue != other.getFinancialValue())
			return false;
		
		
		
		
		if(confidentialValue != other.getConfidentialValue())
			return false;
		if(integrityValue != other.getIntegrityValue())
			return false;
		if(availabilityValue != other.getAvailabilityValue())
			return false;
		
		return true;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	public Person getOwner() {
		return PersonTable.getInstance().getEntry(ownerID);
	}
	public int getCustodianID() {
		return custodianID;
	}
	public void setCustodianID(int custodianID) {
		this.custodianID = custodianID;
	}
	public Person getCustodian() {
		return PersonTable.getInstance().getEntry(custodianID);
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public Type getType() {
		return TypeLookUpTable.getInstance().getEntry(typeID);
	}
	public int getMaintID() {
		return maintID;
	}
	public void setMaintID(int maintID) {
		this.maintID = maintID;
	}
	public Maintenance getMaintenance() {
		return MaintenanceLookUpTable.getInstance().getEntry(maintID);
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public Classification getClassification() {
		return ClassificationLookUpTable.getInstance().getEntry(classID);
	}
	public int getStorageID() {
		return storageID;
	}
	public void setStorageID(int storageID) {
		this.storageID = storageID;
	}
	public Storage getStorage() {
		return StorageTable.getInstance().getEntry(storageID);
	}
	public int getPeriodID() {
		return periodID;
	}
	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}
	public RetentionPeriod getRetentionPeriod() {
		return RetentionPeriodLookUpTable.getInstance().getEntry(periodID);
	}
	public String getDateAcquired() {
		return dateAcquired;
	}
	public void setDateAcquired(String dateAcquired) {
		this.dateAcquired = dateAcquired;
	}
	public double getFinancialValue() {
		return financialValue;
	}
	public void setFinancialValue(double financialValue) {
		this.financialValue = financialValue;
	}
	public int getConfidentialValue() {
		return confidentialValue;
	}
	public void setConfidentialValue(int confidentialValue) {
		this.confidentialValue = confidentialValue;
	}
	public int getIntegrityValue() {
		return integrityValue;
	}
	public void setIntegrityValue(int integrityValue) {
		this.integrityValue = integrityValue;
	}
	public int getAvailabilityValue() {
		return availabilityValue;
	}
	public void setAvailabilityValue(int availabilityValue) {
		this.availabilityValue = availabilityValue;
	}

	public ArrayList<String> getValues() {
		if(values == null){
			values = new ArrayList<String>();
			values.add(String.valueOf(getID()));
			values.add(getName());
			values.add(String.valueOf(getOwnerID()));
			values.add(String.valueOf(getCustodianID()));
			values.add(String.valueOf(getTypeID()));
			values.add(String.valueOf(getMaintID()));
			values.add(String.valueOf(getClassID()));
			values.add(String.valueOf(getStorageID()));
			values.add(String.valueOf(getPeriodID()));
			values.add(getDateAcquired().toString());
			values.add(String.valueOf(getFinancialValue()));
			values.add(String.valueOf(getConfidentialValue()));
			values.add(String.valueOf(getIntegrityValue()));
			values.add(String.valueOf(getAvailabilityValue()));
		}
		return values;
	}
}