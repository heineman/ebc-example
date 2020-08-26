package example.contacts.storage;

import java.util.ArrayList;
import java.util.Iterator;

import example.contacts.model.Contact;

/**
 * Used for testing. 
 * 
 * This is considered a "Mock object"
 */
public class TestStorage implements IStorage {

	@Override
	public Iterator<Contact> contacts() {
		ArrayList<Contact> list = new ArrayList<>();
		// starting with some initial values to get started
		Contact c = new Contact("self");
		c.setPhone("1-508-831-5502");
		c.setEmail("heineman@wpi.edu");
		list.add(c);
		
		c = new Contact("registrar");
		c.setPhone("1-508-831-5211");
		c.setEmail("registrar@wpi.edu");
		list.add(c);
		
		c = new Contact("departmentHead");
		c.setPhone("1-508-831-5357");
		c.setEmail("cew@wpi.edu");
		list.add(c);
		
		return list.iterator();
	}

	@Override
	public boolean store(Iterator<Contact> it) {
		return true;
	}
	
}