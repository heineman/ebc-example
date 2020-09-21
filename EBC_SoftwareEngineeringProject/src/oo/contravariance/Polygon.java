package oo.contravariance;

import java.util.Iterator;

/**
 * Represents a polygon in 2D space.
 * 
 * A Polygon is a closed plane figure with n sides (where n > 2) thus
 * there are n corner points that define the polygon.
 *  
 * (http://mathworld.wolfram.com/Polygon.html) thus 
 * 
 * This initial implementation enforces that users know IN ADVANCE the
 * number of points that will be in the polygon. Until THREE points are
 * added, a polygon is 'OPEN' -- thereafter, it is 'CLOSED'. 
 * 
 * @author George Heineman (heineman@cs.wpi.edu)
 */
public class Polygon implements Shape, Iterable<Point> {

	/** Maximum number is fixed. */
	public static final int maxPoints = 20;
	
	/** Polygon has a maximum series of points.... */
	Point [] points; 
	
	/** How many points are in the polygon, to date. */
	int numPoints;
	
	// Constructors
	
	/**
	 * To construct a polygon, there needs to be at least three points.
	 * 
	 * Note: By next week, we will explore what happens if n < 3.
	 */
	public Polygon () {
		// allocate points array. Without this allocation, can't access points[i]
		points = new Point[maxPoints];
		numPoints = 0;
	}
	
	// Methods
	public int count () {
		return numPoints;
	}
	
	/**
	 * Return whether Polygon is closed.
	 */
	public boolean isClosed () {
		return (numPoints > 2);
	}
	
	/**
	 * return the ith point.
	 * @param i
	 * @return
	 */
	Point getPoint (int i) {
		return points[i];
	}
	
	/**
	 * Return whether Polygon is empty.
	 */
	public boolean isEmpty () {
		return (numPoints == 0);
	}
	
	/**
	 * Given a polygon p1..pn, add a new point pn+1 that forms a new polygon.
	 * If there isn't room, return false; true otherwise.
	 */
	public boolean addPoint (Point p) {
		// add first THEN advance the number of points for this polygon
		if (numPoints < maxPoints) {
			points[numPoints++] = p;
			return true;
		}
		
		// too big!
		return false;
	}
	
	/**
	 * Represent polygon as a String.
	 * 
	 *  EMPTY polygon is    --> [EMPTY polygon]
	 *  CLOSED polygons are --> [CLOSED polygon:p0;p1;...;pn-1;p0]
	 *  OPEN polygons are   --> [OPEN polygon:p0;p1]
	 */
	public String toString () {
		String output = "[";
		
		// annotate with state of polygon
		if (isEmpty()) {
			output += "EMPTY polygon";
		} else if (isClosed()) {
			output += "CLOSED polygon:";
		} else {
			output += "OPEN polygon:";
		}
		
		// now insert point information
		for (int i = 0; i < numPoints; i++) {
			output += points[i].toString();
			
			// output trailing ';' EXCEPT for last one...
			// [compare with TEST of for loop]
			if (i < numPoints-1) {
				output += ";";
			}
		}
		
		// for CLOSED polygons, insert first point again
		if (isClosed()) {
			output += ";" + points[0];
		}
		
		// close string and we're done.
		output = output + "]";
		
		return output;
	}
	
	public Iterator<Point> iterator() {
		return new PolygonIterator(this);
	}

	/** Declare implementation of defined interface method "containedWithin". */
	public boolean containedWithin(Point p) {
		// TO DO LATER: NOTE: this is likely a complex method!
		
		return false;
	}
	
	/** When requested, returns an object capable of traversing all points in the shape. */
	public PolygonEnumeration points() {
		return new PolygonEnumeration (this);
	}
	
}