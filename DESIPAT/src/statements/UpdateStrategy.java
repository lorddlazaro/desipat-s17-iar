package statements;

import java.util.ArrayList;

import dbHandler.NonQuery;

public abstract class UpdateStrategy extends NonQuery{
	private String statement;
	private String tableName;
	private ArrayList<String> columns;
	private ArrayList<String> values;
	private String condition;
	public UpdateStrategy(String tableName, ArrayList<String> columns, ArrayList<String> values, String condition)
	{
		this.tableName=tableName;
		this.columns=columns;
		this.values=values;
		this.condition=condition;
	}
	public String getStatement(){
		String columnsAndValues="";
		for (int i=0;i<columns.size();i++)
		{
			columnsAndValues.concat(columns.get(i)+"="+values.get(i));
		}
		statement = "UPDATE "+tableName+" SET"+columnsAndValues+" WHERE "+condition+";";
		return statement;
	}
}
