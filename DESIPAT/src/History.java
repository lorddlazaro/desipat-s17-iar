import java.sql.Date;

public class History {
	private int assetID;
	private Date startDate;
	private Date endDate;
	
	public int getAssetID() {
		return assetID;
	}
	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
