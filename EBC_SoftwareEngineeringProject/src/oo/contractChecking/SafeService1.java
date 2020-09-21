package oo.contractChecking;

public class SafeService1 implements IDuplicate {

	/**
	 * Return array of those elements common to the unique sets
	 * a and b
	 */
	public int[] compare(int[] a, int[] b) throws Exception {
		int[] retVal = new int[0];
		
		// Check pre-conditions.
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j< a.length; j++) {
				if (a[i] == a[j]) {
					throw new Exception ("PreConditionException: Array a not composed of unique values.");
				}
			}
		}
		
		for (int i = 0; i < b.length-1; i++) {
			for (int j = i+1; j< b.length; j++) {
				if (b[i] == b[j]) {
					throw new Exception ("PreConditionException: Array b not composed of unique values.");
				}
			}
		}
		
		// ACTUAL WORK
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					// expand and copy elements into new one.
					int[]newOnes = new int[retVal.length+1];
					System.arraycopy(retVal, 0, newOnes, 0, retVal.length);
					newOnes[retVal.length] = a[i];
					
					retVal = newOnes;
				}
			}
		}
		
		// check postconditions.
		for (int i = 0; i < retVal.length; i++) {
			boolean found = false;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == retVal[i]) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				throw new Exception ("PostConditionException: element not found in a");
			}
			
			found = false;
			for (int j = 0; j < b.length; j++) {
				if (b[j] == retVal[i]) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				throw new Exception ("PostConditionException: element not found in b");
			}
		}
		return retVal;
	}
	
	
}
