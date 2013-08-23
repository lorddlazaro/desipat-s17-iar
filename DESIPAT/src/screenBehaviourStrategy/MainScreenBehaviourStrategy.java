package screenBehaviourStrategy;

public interface MainScreenBehaviourStrategy {
	public void gotoViewAssetScreen();
	public void gotoAdminScreen();
	public void gotoAccountScreen();
	public void gotoLogScreen();
	public void gotoAddAssetScreen();
	public void gotoEditAssetScreen();
	public void logout();
	public void loadEntry(int ID);
}
