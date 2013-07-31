package dbhandler;

public interface DBCommandHandler {
	public abstract void executeCommand();
	public abstract void setStatement(Statement stmt);
}
