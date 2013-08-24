package statements;

import java.util.ArrayList;

import dbHandler.NonQuery;

public abstract class UpdateStrategy extends NonQuery{
	protected String tableName;
	protected String condition;
	protected ArrayList<String> columns;
	protected ArrayList<String> values;
	protected String columnsAndValues="";
	
	public UpdateStrategy(String tableName, ArrayList<String> values, String condition)
	{
		this.tableName = tableName;
		this.condition = condition;
		this.values = values;
		
		columns = new ArrayList<String>();
		populateColumns();
		
		setColsAndValues();
	}
	
	public abstract void populateColumns();

	public void setColsAndValues(){
		for (int i=0;i<columns.size();i++)
		{
			if(!values.get(i).isEmpty()){
				columnsAndValues += columns.get(i)+"='"+values.get(i);
				columnsAndValues += (i<columns.size()-1)? "'," : "";
			}
		}
		
		nonQuery = "UPDATE " + tableName + " SET " + columnsAndValues + "' WHERE " + condition + ";";
	}
}
