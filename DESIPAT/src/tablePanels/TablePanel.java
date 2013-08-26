package tablePanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import screens.TableObserver;

public abstract class TablePanel extends JPanel{

	protected JScrollPane scrollPane;
	protected JLabel header;
	protected JTable table;
	
	public TablePanel(){
		setOpaque(false);
		setLayout(new BorderLayout());
		
		initTable();
	}
	
	public TablePanel(String title){
		setOpaque(false);
		setLayout(new BorderLayout());
		
		header = new JLabel(title);
		header.setFont(new Font("Segoe WP", Font.PLAIN, 23));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		add(header, BorderLayout.PAGE_START);
		
		initTable();
	}
	
	private void initTable(){
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.LIGHT_GRAY);
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public abstract void fillTable(DefaultTableModel model);
}
