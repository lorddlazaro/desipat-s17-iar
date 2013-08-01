package fields;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;


class DateInput extends InputField{
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<Integer> day = new JComboBox<Integer>();
	JComboBox<Integer> year = new JComboBox<Integer>();
	
	ArrayList<String> monthList = new ArrayList<String>();
	
	public DateInput(String name) {
		super(name);
		
		this.addItems();
	}
	
	public void addFields() {
		this.add(month);
		this.add(day);
		this.add(year);
	}
	
	public void addItems() {
		monthList.add("January");  monthList.add("February");  monthList.add("March");
		monthList.add("April");  monthList.add("May");  monthList.add("June");
		monthList.add("July");  monthList.add("August");  monthList.add("October");
		monthList.add("October");  monthList.add("November");  monthList.add("December");
		
		for (int i = 0; i < 12; i++)
			month.addItem(monthList.get(i));
		
		// if month changes, change day's number of days
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] dayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				
				day.removeAllItems();
				
				for (int i = 0; i < dayCount[month.getSelectedIndex()];i++)
					day.addItem(i);
				
				// leap years yay
				if (month.getSelectedItem().toString().equals("February")) {
					int currYear = Integer.parseInt(year.getSelectedItem().toString());
					if (currYear % 400 == 0 || (currYear % 100 != 0 && currYear % 4 == 0))
						day.addItem(29);
				}
			}
		});
		
		for (int i = 1990; i <= 2050; i++)
			year.addItem(i);
	}
	
	// date format: yyyymmdd
	public void setInput(String toSet) {
		int setMonth, setDay, setYear;
		
		setYear = Integer.parseInt(toSet.substring(0, 4));
		setMonth = Integer.parseInt(toSet.substring(4, 6));
		setDay = Integer.parseInt(toSet.substring(6));
		
		month.setSelectedItem(monthList.get(setMonth));
		year.setSelectedItem(setYear);
		day.setSelectedItem(setDay);
	}
	
	public String getInput() {
		int setMonth, setDay, setYear;
		
		setYear = Integer.parseInt(year.getSelectedItem().toString());
		setMonth = month.getSelectedIndex() + 1;
		setDay = Integer.parseInt(day.getSelectedItem().toString());
		
		return "" + setYear + setMonth + setDay;
	}
}