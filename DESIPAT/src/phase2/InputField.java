package phase2;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public interface InputField {
	public abstract void setInput(String toSet);
	public abstract String getInput();
}

class TextInput implements InputField{
	JTextField myField = new JTextField();
	
	public TextInput() {
		
	}
	
	public void setListener(ActionListener myListener) {
		myField.addActionListener(myListener);
	}
	
	public void setInput(String toSet) {
		myField.setText(toSet);
	}
	
	public String getInput() {
		return myField.getText();
	}
}

class ComboBoxInput implements InputField{
	JComboBox<String> myField = new JComboBox<String>();
	
	public ComboBoxInput() {
		
	}
	
	public void setInput(String toSet) {
		myField.setSelectedItem(toSet);
	}
	
	public String getInput() {
		return myField.getSelectedItem().toString();
	}
}

class SliderInput implements InputField{
	JSlider myField = new JSlider();
	
	public SliderInput() {
		
	}
	
	public void setInput(String toSet) {
		myField.setValue(Integer.parseInt(toSet));
	}
	
	public String getInput() {
		return myField.getValue() + "";
	}
}

class PasswordInput implements InputField{
	JPasswordField myField = new JPasswordField();
	
	public PasswordInput() {
		
	}
	
	// unsure if needed
	public void setListener(ActionListener myListener) {
		myField.addActionListener(myListener);
	}
	
	public void setInput(String toSet) {
		myField.setText(toSet);
	}
	
	public String getInput() {
		return myField.getText();
	}
}

class DateInput implements InputField{
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<Integer> day = new JComboBox<Integer>();
	JComboBox<Integer> year = new JComboBox<Integer>();
	
	ArrayList<String> monthList = new ArrayList<String>();
	
	public DateInput() {
		
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