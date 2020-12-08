package oo.covariance;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICalculation   s1 = new Sample1();
		ICalculation   s2 = new Sample2();

		// both satisfactory
		float x = 0.5f;
		System.out.println ("s1 calculates as: " + s1.compute(x));
		System.out.println ("s2 calculates as: " + s2.compute(x));
		
		// Outside of bounds for 1 of the values
		x = 2.0f;
		System.out.println ("s1 calculates as: " + s1.compute(x));
		System.out.println ("s2 calculates as: " + s2.compute(x));
		
		// invalid for both
		x = -1.0f;
		System.out.println ("s1 calculates as: " + s1.compute(x));
		System.out.println ("s2 calculates as: " + s2.compute(x));

	}

}