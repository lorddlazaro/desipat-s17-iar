package phase2;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import databaseTableObjects.TableSubject;

public abstract class TablePanel extends JScrollPane{
	private JTable table;
	
	public abstract void initialize();
	public abstract void fillTable(TableSubject tableSubject);
	public abstract void refresh();
}
