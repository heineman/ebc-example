package example.calc.model;

public class Constant {
	public final String name;
	public final double value;
	
	public Constant (String n, double v) {
		this.name = n;
		this.value =v;
	}
	
	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o instanceof Constant) {
			Constant other = (Constant) o;
			return other.name.equals(name);
		}
		
		return false;
	}
	
	public String toString() {
		return name + " = " + value;
	}
}
