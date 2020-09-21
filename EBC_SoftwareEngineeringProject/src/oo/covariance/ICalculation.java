package oo.covariance;

/**
 * Interface definining core functionality.
 * 
 * @author George Heineman (heineman@cs.wpi.edu)
 */
public interface ICalculation {

	/**
	 * Return natural log of (x+1).
	 * 
	 *   Precondition: 1 > x > -1
	 *   
	 *   Contract: Must produce at least 5 digits of precision.
	 * 
	 * @param x    value as a float.  
	 */
	public double compute (float x);  
	
	
}