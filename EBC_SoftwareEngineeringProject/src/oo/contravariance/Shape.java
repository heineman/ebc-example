package oo.contravariance;

/**
 * Common behaviors for shape objects.
 * 
 * @author George Heineman (heineman@cs.wpi.edu)
 */
public interface Shape {
	/**
	 * Determines if given point is contained within the shape that implements this
	 * interface. 
	 */
	public boolean containedWithin (Point p);
	
	/**
	 * Return an object capable of enumerating all points that define the shape.
	 */
	public java.util.Enumeration points(); 
}