package oo.contravariance;

/**
 * Enables one to enumerate each point in a polygon.
 * 
 * @author heineman
 */
public class PolygonEnumeration implements java.util.Enumeration {

	/** Polygon being iterated over. */
	Polygon p;
	int index = 0;
	
	/** Constructor keeps track of the polygon. */
	public PolygonEnumeration (Polygon p) {
		this.p = p;
		index = 0;
	}
	
	/** More to go? */
	public boolean hasMoreElements() {
		return (index < p.count());
	}

	/** Return the ith point and advance. */
	public Object nextElement() {
		return p.getPoint(index++);
	}

}