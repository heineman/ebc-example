package oo.contractChecking;

import java.util.Hashtable;

/**
 * Note how checking code for conditions is pulled into private
 * methods.
 * 
 * @author heineman
 */

public class SafeService4 implements IDuplicate2 {

	private void checkUniqueness (String type, int []a) throws Exception {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j< a.length; j++) {
				if (a[i] == a[j]) {
					throw new Exception ("PreConditionException: Array " + type + " is not composed of unique values.");
				}
			}
		}
	}
	
	private void checkMembership (String type, int []c, int[]a) throws Exception {
		for (int i = 0; i < c.length; i++) {
			boolean found = false;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == c[i]) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				throw new Exception ("PostConditionException: element not found in a");
			}
		}
	}
	
	
	/**
	 * Return array of those elements common to the unique sets
	 * a and b
	 */
	public int[] compare(int[] a, int[] b) throws Exception {
		int[] retVal = new int[0];
		
		checkUniqueness ("a", a);
		checkUniqueness ("b", b);
		
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
		checkMembership ("a", retVal, a);
		checkMembership ("b", retVal, a);
		
		return retVal;
	}

	@Override
	public boolean hasDuplicates(int[] a) {
		Hashtable<Integer,Boolean> match = new Hashtable<Integer,Boolean>();
		for (int i = 0 ; i < a.length; i++) {
			if (match.put(i, true)) { return true; }
		}
		
		return false;
	}
	
	
}
