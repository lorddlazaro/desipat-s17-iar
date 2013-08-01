package statementStrategies2;

public class SelectAllStrategy implements StatementStrategy {
	private String statement;
	private String tableName;
	private String condition;
	public SelectAllStrategy(String tableName)
	{
		this.tableName=tableName;
		this.condition=condition;
	}
	public String getStatement(){
		statement = "SELECT * FROM "+tableName+";";
		return statement;
	}
}
