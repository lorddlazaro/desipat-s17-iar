package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.AssetChangeLog;
import statements.SelectAllStrategy;

public class SelectAllAssetChangeLogs extends SelectAllStrategy {
	public SelectAllAssetChangeLogs() {
		super("AssetChangeLog");
	}
	
	public void fillResultList() {
		try {
			resultList = new ArrayList<AssetChangeLog>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					AssetChangeLog log= new AssetChangeLog(myResult.getInt(1), myResult.getInt(2), myResult.getInt(3), myResult.getString(4), myResult.getString(5), myResult.getString(6));
					resultList.add(log);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}