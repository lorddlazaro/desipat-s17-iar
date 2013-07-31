package StatementStrategies;

import java.util.ArrayList;

public abstract class InsertStrategy implements StatementStrategy{
	private ArrayList<String> columnNames;
	private ArrayList<String> values;
	
	public String getStatement()
	{
		return "";
	}
}
