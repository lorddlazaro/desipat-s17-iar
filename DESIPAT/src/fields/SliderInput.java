package fields;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.JSlider;


public class SliderInput extends AbstractInputField{
	JSlider sliderField;
	
	public SliderInput(String name) {
		super(name);
		
		sliderField.setBackground(SystemColor.inactiveCaption);
		sliderField.setPaintTicks(true);
		sliderField.setMajorTickSpacing(1);
		sliderField.setMinimum(1);
		sliderField.setMaximum(5);
		sliderField.setValue(0);
		sliderField.setFont(new Font("Calibri", Font.PLAIN, 12));
	}
	
	protected void addFields() {
		sliderField = new JSlider();
		add(sliderField);
	}
	
	protected void clearInput(){
		sliderField.setValue(1);
	}
	
	public void setInput(String toSet) {
		sliderField.setValue(Integer.parseInt(toSet));
	}
	
	public String getInput() {
		return sliderField.getValue() + "";
	}
}
