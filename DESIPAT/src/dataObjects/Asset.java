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
	private Date dateAcquired;
	private double financialValue;
	private int confidentialValue;
	private int integrityValue;
	private  int availabilityValue;

	public Asset(String name, int ownerID, int custodianID, int typeID, int maintID, int classID, int storageID, int periodID, Date dateAcquired, double financialValue, int confidentialValue, int integrityValue, int availabilityValue){
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
	
	public Asset(int ID, String name, int ownerID, int custodianID, int typeID, int maintID, int classID, int storageID, int periodID, Date dateAcquired,  double financialValue, int confidentialValue, int integrityValue, int availabilityValue){
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
	public int getCustodianID() {
		return custodianID;
	}
	public void setCustodianID(int custodianID) {
		this.custodianID = custodianID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getMaintID() {
		return maintID;
	}
	public void setMaintID(int maintID) {
		this.maintID = maintID;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getStorageID() {
		return storageID;
	}
	public void setStorageID(int storageID) {
		this.storageID = storageID;
	}
	public int getPeriodID() {
		return periodID;
	}
	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}
	public Date getDateAcquired() {
		return dateAcquired;
	}
	public void setDateAcquired(Date dateAcquired) {
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