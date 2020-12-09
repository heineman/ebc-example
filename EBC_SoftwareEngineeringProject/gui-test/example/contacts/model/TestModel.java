package example.contacts.model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	
	@Test
	public void testCreateEmpty() {
		Model m = new Model();
		assertFalse (m.contacts().hasNext());
	}
	
	@Test
	public void testMake() {
		Model m = new Model();
		Contact c1 = new Contact("name", "phone", "email");
		m.add(c1);
		
		Contact c2 = m.contacts().next();
		assertEquals (c1, c2);
	}
	
	@Test
	public void testDelete() {
		Model m = new Model();
		Contact c1 = new Contact("name", "phone", "email");
		m.add(c1);
		
		Contact c2 = m.remove("name");
		assertEquals (c1, c2);
	}

	@Test
	public void testRetrieve() {
		Model m = new Model();
		Contact c1 = new Contact("name", "phone", "email");
		m.add(c1);
		Contact c2 = new Contact("other", "phone2", "email2");
		m.add(c2);
		
		Contact[] contacts = m.getArray();
		assertEquals (2, contacts.length);
		
		// make sure both are in this array
		boolean bc1 = false;
		boolean bc2 = false;
		for (Contact c : contacts) {
			if (c.equals(c1)) { bc1 = true; }
			if (c.equals(c2)) { bc2 = true; }
		}
	
		assertTrue(bc1 && bc2);
	}
	
}
