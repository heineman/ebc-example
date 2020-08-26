package example.contacts.model;

import java.util.*;

public class Model {
	Hashtable<String,Contact> contacts = new Hashtable<>();
	
	/**
	 * Add contact, possibly overwriting old contact information with same name. Return old
	 * one just in case.
	 * 
	 * @param c
	 * @return
	 */
	public Contact add(Contact c) {
		Contact old = contacts.get(c.getName());
		contacts.put(c.getName(), c);
		
		return old;
	}
	
	/** Remove any contact associated with name, and return it if it was present. */
	public Contact remove(String name) {
		Contact old = contacts.get(name);
		contacts.remove(name);
		return old;
	}

	/** Return all contacts as a sorted array. */
	public Contact[] getArray() {
		Contact[] array = contacts.values().toArray(new Contact[0]);
		Arrays.sort(array);
		return array;
	}

	/** Return all contacts as an iterator. */
	public Iterator<Contact> contacts() {
		return contacts.values().iterator();
	}
}
