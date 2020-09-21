package oo.contractChecking;

public class UnsafeService implements IDuplicate {

	/**
	 * Return array of those elements common to the unique sets a and b.
	 * 
	 * For all elements in a, see if it exists in b, and if so add to our output set.
	 */
	@Override
	public int[] compare(int[] a, int[] b) throws Exception {
		// no more than a.length will be in the output.
		int[] total = new int[a.length];
		
		int max = -1;
		for (int i = 0; i < a.length; i++) {
			
			// for each element in a, try to find in b, and add to our return if found.
			for (int j = 0; j < b.length; j++) {
				if (b[j] == a[i]) {
					max++;
					total[max] = b[j];
					break;
				}
			}
		}
		
		// now return just the subset that was matched.
		int[] retVal = new int[max+1];
		java.lang.System.arraycopy(total, 0, retVal, 0, max+1);
		return retVal;
	}
	

}
