package example.start.model;

import java.awt.Rectangle;

/**
 * A state object has two sides (represented by strings) and starts with an initial Rectangular location.
 *
 * A state can be flipped.
 * A state can have its location changed.
 */
public class State {

	final String side1;
	final String side2;

	/** Current value (one of side1 or side2). */
	String value;

	/** Current location. */
	Rectangle rect;

	public State(String side1, String side2, Rectangle initial) {
		this.side1 = side1;
		this.side2 = side2;
		value = side1;
		rect = initial;
	}

	public void flip() {
		if (value.contentEquals(side1)) {
			value = side2;
		} else {
			value = side1;
		}
	}

	public void setLocation(Rectangle r) {
		this.rect = r;
	}

	public Rectangle getLocation() {
		return rect;
	}

	public String value() {
		return value;
	}

}
