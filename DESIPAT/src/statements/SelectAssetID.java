package statements;

import java.sql.SQLException;
import java.util.ArrayList;

import dbHandler.Query;

public class SelectAssetID extends Query {

	public SelectAssetID(String AssetName) {
		query = "SELECT identifier FROM asset WHERE name = '" + AssetName+ "';";
	}
	
	@Override
	public void fillResultList() {
		try{
            resultList = new ArrayList<Integer>();
			
			if(myResult.isBeforeFirst()){
				myResult.first();
				resultList.add(myResult.getInt(1));
			}
			myResult.close();
		}catch(SQLException e){
			
		}	
	}
}
