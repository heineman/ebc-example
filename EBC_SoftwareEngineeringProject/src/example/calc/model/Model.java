package example.calc.model;

import java.util.Hashtable;
import java.util.Iterator;

public class Model implements Iterable<Constant> {
	Hashtable<String, Constant> constants = new Hashtable<>();
	
	public void add(String constName, double constValue) {
		constants.put(constName,  new Constant(constName, constValue));
	}
	
	public Iterator<Constant> iterator() {
		return constants.values().iterator();
	}

	public Constant getConstant(String name) {
		return constants.get(name);
	}

	public void delete(String name) {
		constants.remove(name);
	}
}
