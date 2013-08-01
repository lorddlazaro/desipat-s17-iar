package tablePanels;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataObjects.TableSubject;

public abstract class TablePanel extends JScrollPane{
	private JTable table;
	
	public abstract void initialize();
	public abstract void fillTable(TableSubject tableSubject);
	public void refresh(){
		this.revalidate();
	}
}
