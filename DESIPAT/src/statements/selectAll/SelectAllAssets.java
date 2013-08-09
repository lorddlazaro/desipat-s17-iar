package statements.selectAll;

import java.sql.SQLException;
import java.util.ArrayList;

import dataObjects.Asset;
import statements.SelectAllStrategy;

public class SelectAllAssets extends SelectAllStrategy {
	public SelectAllAssets() {
		super("Asset");
	}

	public void fillResultList() {
		try {
			resultList = new ArrayList<Asset>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				while(!myResult.isAfterLast()){
					Asset asset= new Asset(myResult.getInt(1), myResult.getString(2), myResult.getInt(3), myResult.getInt(4), myResult.getInt(5), myResult.getInt(6), myResult.getInt(7), myResult.getInt(8), myResult.getInt(9), myResult.getDate(10), myResult.getInt(11), myResult.getInt(12), myResult.getInt(13), myResult.getInt(14));
					resultList.add(asset);
					myResult.next();
				}
			}
			myResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}