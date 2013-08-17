package fields;

import javax.swing.JSlider;


class SliderInput extends AbstractInputField{
	JSlider myField = new JSlider();
	
	public SliderInput(String name) {
		super(name);
	}
	
	public void addFields() {
		this.add(myField);
	}
	
	public void setInput(String toSet) {
		myField.setValue(Integer.parseInt(toSet));
	}
	
	public String getInput() {
		return myField.getValue() + "";
	}
}
