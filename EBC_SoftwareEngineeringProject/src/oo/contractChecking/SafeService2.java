package oo.contractChecking;

public class SafeService2 implements IDuplicate {

	/**
	 * Return array of those elements common to the unique sets
	 * a and b
	 */
	public int[] compare(int[] a, int[] b) throws Exception {
		int[] retVal = new int[0];
		
		// ACTUAL WORK
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					
					// validate that we haven't already inserted; if
					// we have, then the input set wasn't unique
					for (int k = 0; k < retVal.length; k++) {
						if (a[i] == retVal[k]) {
							throw new Exception ("PreconditionException: value " + a[i] + " is duplicated in either a or b.");
						}
					}
					
					// expand and copy elements into new one.
					int[]newOnes = new int[retVal.length+1];
					System.arraycopy(retVal, 0, newOnes, 0, retVal.length);
					newOnes[retVal.length] = a[i];
					
					retVal = newOnes;
				}
			}
		}
		
		return retVal;
	}
	
	
}
