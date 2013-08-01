package statementStrategies;

public class InsertStrategy implements StatementStrategy{
	private String statement;
	private String tableName;
	private String columns;
	private String values;
	public InsertStrategy(String tableName, String columns, String values)
	{
		this.tableName=tableName;
		this.columns=columns;
		this.values=values;
	}
	public String getStatement(){
		statement = "INSERT INTO "+tableName+" ("+columns+") VALUES "+values + ";";
		return statement;
	}
}
