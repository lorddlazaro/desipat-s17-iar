package screenBehaviourStrategy;

public interface AdminScreenBehaviorStrategy {
	public abstract void selectedCellChanged();
	public abstract void deleteUserClicked();
	public abstract void changeDetailsClicked();
	public abstract void addUserClicked();
	public abstract void selectedChanged();
	public abstract void fillTable();
	public abstract void fillClearance();
}
