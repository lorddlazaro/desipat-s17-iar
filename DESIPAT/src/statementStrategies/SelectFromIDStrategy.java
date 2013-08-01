package statementStrategies;

public class SelectFromIDStrategy implements StatementStrategy { 
	private String statement;
	private String tableName;
	private String condition;
	public SelectFromIDStrategy(String tableName, String condition)
	{
		this.tableName=tableName;
		this.condition=condition;
	}
	public String getStatement(){
		statement = "SELECT * FROM "+tableName+" WHERE ID = " + condition + ";";
		return statement;
	}
}
