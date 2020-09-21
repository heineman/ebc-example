package oo.contravariance;

/**
 * Represents a point in the XY plane
 * 
 * @author George Heineman (heineman@cs.wpi.edu)
 */
public class Point {

	/** The x-coordinate. */
	int x;
	
	/** The y-coordinate. */
	int y;
	
	/**
	 * Construct a point in the XY plane.
	 * 
	 * @param x
	 * @param y
	 */
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/** Enhanced equals. */
	public boolean equals (Object o) {
		if (o == null) return false;
		
		if (o.getClass() != getClass()) {
			String s = toString();
			if (o.getClass() != s.getClass()) return false;
			return s.equals(o.toString());
		}
		
		Point p = (Point) o;
		return (p.x == x) && (p.y == y);
	}
	
	/**
	 * Represent point as a String.
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public int getX() { return x; }
	public int getY() { return y; }

}