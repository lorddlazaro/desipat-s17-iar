package assetLogger;

import screens.ViewAssetScreen;
import statements.SelectAssetID;
import statements.SelectFromAsset;
import dataObjects.Asset;
import dbHandler.Query;

public class AssetEdited extends AssetLogger {

	private String oldValues  = "", newValues = "";
	private String assetField = "";
	
	public AssetEdited(int actionID, Asset newAsset) {
		super(actionID, newAsset);
		
		int assetID = ViewAssetScreen.getAssetTableSelectedAssetID();
		
		SelectFromAsset selectAsset = new SelectFromAsset(assetID);
		selectAsset.executeStatement();
		
		Asset oldAsset = (Asset) selectAsset.getResultList().get(0);
		
		if(!oldAsset.getName().equals(newAsset.getName())) 
		{
			oldValues += oldAsset.getName();
			newValues += newAsset.getName();
			assetField += "AssetName ";
		}
		
		if(!oldAsset.getClassification().equals(newAsset.getClassification()))
		{
			oldValues += oldAsset.getClassification();
			newValues += newAsset.getClassification();
			assetField += "Classification ";
		}
		
		if(!oldAsset.getDateAcquired().equals(newAsset.getDateAcquired()))
		{
			oldValues += oldAsset.getDateAcquired();
			newValues += newAsset.getDateAcquired();
			assetField += "Date Acquired ";
		}
		
		if(!oldAsset.getOwner().equals(newAsset.getOwner()))
		{
			oldValues += oldAsset.getOwner();
			newValues += newAsset.getOwner();
			assetField += "Owner ";
		}
		
		if(!oldAsset.getCustodian().equals(newAsset.getCustodian()))
		{
			oldValues += oldAsset.getCustodian();
			newValues += newAsset.getCustodian();
			assetField += "Custodian ";
		}
		
		if(!oldAsset.getType().equals(newAsset.getType()))
		{
			oldValues += oldAsset.getType();
			newValues += newAsset.getType();
			assetField += "Type ";
		}
		
		if(!oldAsset.getStorage().equals(newAsset.getStorage()))
		{
			oldValues += oldAsset.getStorage();
			newValues += newAsset.getStorage();
			assetField += "Storage ";
		}
		
		if(!oldAsset.getMaintenance().equals(newAsset.getMaintenance()))
		{
			oldValues += oldAsset.getMaintenance();
			newValues += newAsset.getMaintenance();
			assetField += "Maintenance ";
		}
			
		if(!oldAsset.getRetentionPeriod().equals(newAsset.getRetentionPeriod()))
		{
			oldValues += oldAsset.getRetentionPeriod();
			newValues += newAsset.getRetentionPeriod();
			assetField += "Retention Period ";
		}
		
		if((oldAsset.getFinancialValue() != newAsset.getFinancialValue()))
		{
			oldValues += oldAsset.getFinancialValue();
			newValues += newAsset.getFinancialValue();
			assetField += "Financial ";
		}
		
		if(!(oldAsset.getConfidentialValue() == newAsset.getConfidentialValue()))
		{
			oldValues += oldAsset.getConfidentialValue();
			newValues += newAsset.getConfidentialValue();
			assetField += "Confidentiality Value";
		}
		
		if(!(oldAsset.getIntegrityValue() == newAsset.getIntegrityValue()))
		{
			oldValues += oldAsset.getIntegrityValue();
			newValues += newAsset.getIntegrityValue();
			assetField += "Integrity Value ";
		}
		
		if(!(oldAsset.getAvailabilityValue() == newAsset.getAvailabilityValue()))
		{
			oldValues += oldAsset.getAvailabilityValue();
			newValues += newAsset.getAvailabilityValue();
			assetField += "Availability Value ";
		}
			
		log.setNewValue(newValues);
		log.setOldValue(oldValues);
		log.setAssetField(assetField);
		log.setAssetID(assetID);

	}

}

