package oo.covariance;

public class Sample1 implements ICalculation {

	/**
	 * Compute ln (1+x).
	 * 
	 *   Precondition: x > -1
	 * 
	 * WEAKER precondition.
	 * 
	 * @param x
	 */
	public double compute(float x) {
		return Math.log(x+1);
	}
}