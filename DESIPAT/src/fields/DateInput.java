package fields;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;


public class DateInput extends AbstractInputField{
	JComboBox<String> monthField;
	JComboBox<Integer> dayField;
	JComboBox<Integer> yearField;
	
	ArrayList<String> monthList = new ArrayList<String>();
	
	// date format: yyyy-MM-dd
	public DateInput(String name) {
		super(name);
		
		monthField.setFont(new Font("Calibri", Font.PLAIN, 12));
		dayField.setFont(new Font("Calibri", Font.PLAIN, 12));
		yearField.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		this.addItems();
	}

	private void addItems() {
		monthList.add("January");  
		monthList.add("February");  
		monthList.add("March");
		monthList.add("April");  
		monthList.add("May");  
		monthList.add("June");
		monthList.add("July");  
		monthList.add("August");  
		monthList.add("September");
		monthList.add("October");  
		monthList.add("November");  
		monthList.add("December");
		
		for (int i = 0; i < 12; i++)
			monthField.addItem(monthList.get(i));
		
		// if month changes, change day's number of days
		monthField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					setDay();
			}
		});
		setDay();
		
		for (int i = 1990; i <= 2050; i++)
			yearField.addItem(i);
	}	
	private void setDay(){
		int[] dayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		dayField.removeAllItems();
		
		for (int i = 1; i <= dayCount[monthField.getSelectedIndex()];i++)
			dayField.addItem(i);
		
		// leap years yay
		if (monthField.getSelectedItem().toString().equals("February")) {
			int currYear = Integer.parseInt(yearField.getSelectedItem().toString());
			if (currYear % 400 == 0 || (currYear % 100 != 0 && currYear % 4 == 0))
				dayField.addItem(29);
	
		}
	}
	
	protected void addFields() {
		monthField = new JComboBox<String>();
		this.add(monthField);
		
		dayField = new JComboBox<Integer>();
		this.add(dayField);
		
		yearField = new JComboBox<Integer>();
		this.add(yearField);
	}
	protected void clearInput() {
		setInput((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
	}
	public void setInput(String toSet) {
		int setMonth, setDay, setYear;
		
		setYear = Integer.parseInt(toSet.split("-")[0]);
		setMonth = Integer.parseInt(toSet.split("-")[1])-1;
		setDay = Integer.parseInt(toSet.split("-")[2]);
		
		monthField.setSelectedItem(monthList.get(setMonth));
		yearField.setSelectedItem(setYear);
		dayField.setSelectedItem(setDay);
	}
	public String getInput() {
		int setMonth, setDay, setYear;
		
		setYear = (int) yearField.getSelectedItem();
		setMonth = monthField.getSelectedIndex()+1;
		setDay = (int) dayField.getSelectedItem();
		
		if(setMonth < 10 && setDay > 9)
			return String.valueOf(setYear + "-0" + setMonth + "-" + setDay);
		else if(setMonth > 9 && setDay < 10)
			return String.valueOf(setYear + "-" + setMonth + "-0" + setDay);
		else if(setMonth < 10 && setDay < 10)
			return String.valueOf(setYear + "-0" + setMonth + "-0" + setDay);
		else
			return String.valueOf(setYear + "-" + setMonth + "-" + setDay);
	}

	
}