package statements.insertNew;

import dataObjects.Type;
import statements.InsertStrategy;

public class NewType extends InsertStrategy {

	public NewType(Type type) {
		super("TypeLookUp", 
				"type",
				"'"+type.getType()+"'");
		// TODO Auto-generated constructor stub
	}

}
