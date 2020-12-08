package oo.contractChecking;

import junit.framework.TestCase;

public abstract class BaseTests extends TestCase {
	
	// object being tested.
	abstract IDuplicate getObject();
	
	// handles the assertion.
	public void assertEquals (int[] a, int[]b) {
		if (a.length != b.length) {
			fail();
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				fail();
			}
		}
	}
	
	// see if a duplicate in B is detected.
	public void testDuplicates () {
		try {
			int[] c = getObject().compare(new int[] { 1, 2}, new int[] {1, 1});
			fail();
		} catch (Exception e) {
		}
		
		try {
			int[] c = getObject().compare( new int[] {1, 1}, new int[] { 1, 2});
			fail();
		} catch (Exception e) {
		}
			
	}
	
	public void testSimple () {
		int []a = new int[] {1, 8, 3, 6, 2, 5};
		int []b = new int[] {3, 4, 7, 5};
		
		try {
			int[] c = getObject().compare(a, b);
			assertEquals (c, new int[]{3, 5});
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		a = new int[] {1, 8, 3, 6, 2, 5};
		b = new int[] {9, 4, 7, 0};
				
		try {
			int[] c = getObject().compare(a, b);
			assertEquals (0, c.length);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}
