package oo.iterator;

import java.util.Iterator;

public class ArrayIterator<K> implements Iterator<K> {

	/** Store array reference. */
	K ar[];

	/** State of iteration. */
	int idx;

	/** max. */
	final int max;

	/** Construct iterator object. */
	public ArrayIterator (K[] ar) {
		this.ar = ar;

		idx = 0; // start at 0th element
		this.max = ar.length; 
	}
	
	public ArrayIterator (K[] ar, int max) {
		this.ar = ar;

		idx = 0; // start at 0th element
		this.max = max; 
	}


	@Override
	public boolean hasNext() {
		return (idx < max);
	}

	@Override
	public K next() {
		K val = ar[idx++];
		return val;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Unable to remove values from underlying array.");
	}

}
