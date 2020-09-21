package oo.contractChecking;

public class Driver {
	public static void main(String[] args) {
		
		int []a = new int[] {1, 8, 3, 6, 2, 5};
		int []b = new int[] {3, 4, 7, 5};
		int []c = new int[] {6, 4, 6, 5};
		
		// all should work
		trial (a, b);
		
		// duplicates might cause problems...		
		trial (a, c);
	}
	
	private static void trial (int []a, int []b) {
		int[] vals;
		try {
			vals = validate (new SafeService1(), a, b);
			System.out.println("Duplicates:");
			for (int i : vals) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(">>> " + e.getMessage());
		}
		
		try {
			vals = validate (new SafeService2(), a, b);
			System.out.println("Duplicates:");
			for (int i : vals) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(">>> " + e.getMessage());
		}
		
		try {
			vals = validate (new SafeService3(), a, b);
			System.out.println("Duplicates:");
			for (int i : vals) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(">>> " + e.getMessage());
		}
		
		try {
			vals = validate (new UnsafeService(), a, b);
			System.out.println("Duplicates:");
			for (int i : vals) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(">>> " + e.getMessage());
		}
		
	}

	private static int[] validate(IDuplicate d, int[] a, int[] b) throws Exception {
		System.out.println("Validating for " + d.getClass());
		if (d instanceof IDuplicate2) {
			if (((IDuplicate2)d).hasDuplicates(a)) {
				throw new Exception ("a[] has duplicate value.");
			}
			
			if (((IDuplicate2)d).hasDuplicates(b)) {
				throw new Exception ("b[] has duplicate value.");
			}
		}
		
		return d.compare(a, b);
	}
}
