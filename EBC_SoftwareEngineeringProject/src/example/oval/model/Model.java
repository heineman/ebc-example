package example.oval.model;

import java.util.*;

public class Model {
	ArrayList<Oval> ovals = new ArrayList<Oval>();
	Oval active = null;
	
	public void setActiveOval (Oval c) {
		active = c;
	}
	
	public void addOval(Oval c) {
		ovals.add(c);
	}

	public ArrayList<Oval> getOvals() {
		return ovals;
	}

	public Oval getActive() {
		return active;
	}
}
