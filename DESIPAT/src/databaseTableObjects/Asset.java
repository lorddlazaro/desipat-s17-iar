package databaseTableObjects;
import java.util.List;
import java.sql.Date;

public class Asset extends TableEntry{
	
private int assetID;
private String name;
private int type;
private Boolean isActive;

private int maintenanceSchedule;
private String dateAcquired; 
private Date dateRetired;

private float valueFinancial;
private int valueConfidentiality;
private int valueIntegrity;
private  int valueAvailability;

private  int classification;

private int custodianID;
private int ownerID;
private int storageID;

private int status;

private String ownerFirstName;
private String ownerMiddleInitial;
private String ownerLastName;

private String custodianFirstName;
private String custodianMiddleInitial;
private String custodianLastName;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Boolean getIsActive() {
	return isActive;
}
public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}
public int getMaintenanceSchedule() {
	return maintenanceSchedule;
}
public void setMaintenanceSchedule(int maintenanceSchedule) {
	this.maintenanceSchedule = maintenanceSchedule;
}
public String getDateAcquired() {
	return dateAcquired;
}
public void setDateAcquired(String dateAcquired) {
	this.dateAcquired = dateAcquired;
}
public Date getDateRetired() {
	return dateRetired;
}
public void setDateRetired(Date dateRetired) {
	this.dateRetired = dateRetired;
}
public float getValueFinancial() {
	return valueFinancial;
}
public void setValueFinancial(float valueFinancial) {
	this.valueFinancial = valueFinancial;
}
public int getValueConfidentiality() {
	return valueConfidentiality;
}
public void setValueConfidentiality(int valueConfidentiality) {
	this.valueConfidentiality = valueConfidentiality;
}
public int getValueIntegrity() {
	return valueIntegrity;
}
public void setValueIntegrity(int valueIntegrity) {
	this.valueIntegrity = valueIntegrity;
}
public int getValueAvailability() {
	return valueAvailability;
}
public void setValueAvailability(int valueAvailability) {
	this.valueAvailability = valueAvailability;
}
public int getClassification() {
	return classification;
}
public void setClassification(int classification) {
	this.classification = classification;
}
public int getStatus(){
	return status;
}
public void setStatus(int status){
	this.status=status;
}
/*public List<CustodyHistory> getCustodyHistory() {
	return custodyHistory;
}
public void setCustodyHistory(List<CustodyHistory> custodyHistory) {
	this.custodyHistory = custodyHistory;
}
public List<OwnershipHistory> getOwnershipHistory() {
	return ownershipHistory;
}
public void setOwnershipHistory(List<OwnershipHistory> ownershipHistory) {
	this.ownershipHistory = ownershipHistory;
}
public List<StorageHistory> getStorageHistory() {
	return storageHistory;
}
public void setStorageHistory(List<StorageHistory> storageHistory) {
	this.storageHistory = storageHistory;
}*/
public int getStorageID() {
	return storageID;
}
public void setStorageID(int storageID) {
	this.storageID = storageID;
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
public int getID() {
	return assetID;
}
public void setID(int assetID) {
	this.assetID = assetID;
}
public String getOwnerFirstName() {
	return ownerFirstName;
}
public void setOwnerFirstName(String ownerFirstName) {
	this.ownerFirstName = ownerFirstName;
}
public String getOwnerMiddleInitial() {
	return ownerMiddleInitial;
}
public void setOwnerMiddleInitial(String ownerMiddleInitial) {
	this.ownerMiddleInitial = ownerMiddleInitial;
}
public String getOwnerLastName() {
	return ownerLastName;
}
public void setOwnerLastName(String ownerLastName) {
	this.ownerLastName = ownerLastName;
}
public String getCustodianFirstName() {
	return custodianFirstName;
}
public void setCustodianFirstName(String custodianFirstName) {
	this.custodianFirstName = custodianFirstName;
}
public String getCustodianMiddleInitial() {
	return custodianMiddleInitial;
}
public void setCustodianMiddleInitial(String custodianMiddleInitial) {
	this.custodianMiddleInitial = custodianMiddleInitial;
}
public String getCustodianLastName() {
	return custodianLastName;
}
public void setCustodianLastName(String custodianLastName) {
	this.custodianLastName = custodianLastName;
}
}
