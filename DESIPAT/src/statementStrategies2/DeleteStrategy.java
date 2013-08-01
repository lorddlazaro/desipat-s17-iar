package statementStrategies2;

public class DeleteStrategy implements StatementStrategy{
	private String statement;
	private String tableName;
	private String condition;
	public DeleteStrategy(String tableName, String condition)
	{
		this.tableName=tableName;
		this.condition=condition;
	}
	public String getStatement(){
		statement = "DELETE FROM "+tableName+" WHERE " + condition + ";";
		return statement;
	}
}
