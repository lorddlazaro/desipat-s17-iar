package statements.updateTable;

import java.util.ArrayList;

import statements.UpdateStrategy;

public class UpdatePerson extends UpdateStrategy{

	public UpdatePerson(ArrayList<String> values, int toUpdate) {
		super("Person", values, "personID = " + toUpdate);
		
		setColsAndValues();
	}

	public void populateColumns() {
		columns.add("firstName");
		columns.add("middleInitial");
		columns.add("lastName");
	}
}
