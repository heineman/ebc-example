package oo.covariance;

import junit.framework.TestCase;

public class TestInterface extends TestCase {

	// can s2 replace s1 at .05?
	public void testBasic() {
		ICalculation   s1 = new Sample1();
		ICalculation   s2 = new Sample2();

		// both satisfactory
		float x = 0.5f;
		double res1 =  s1.compute(x);
		double res2 =  s2.compute(x);
		
		// THIS FAILS! Can't use at .05
		System.out.println(res1);
		System.out.println(res2);
		assertEquals(res1, res2, .00001);
	}
	
//	 can s2 replace s1 at .05
	public void testUnusual() {
		ICalculation   s1 = new Sample1();
		ICalculation   s2 = new Sample2();

		// both satisfactory
		float x = -.099f;
		double res1 =  s1.compute(x);
		double res2 =  s2.compute(x);
		
		System.out.println(res1);
		System.out.println(res2);
		assertEquals(res1, res2, .00001);
	}
	
}
