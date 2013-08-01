package statementStrategies2;

public class SelectLookUpStrategy implements StatementStrategy{
	private String statement;
	private String tableName;
	private String condition;
	public SelectLookUpStrategy(String tableName, String condition)
	{
		this.tableName=tableName;
		this.condition=condition;
	}
	public String getStatement(){
		statement = "SELECT ID FROM "+tableName+" WHERE " + condition + ";";
		return statement;
	}
}
