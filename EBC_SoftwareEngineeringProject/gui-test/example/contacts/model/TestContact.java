package example.contacts.model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestContact extends TestCase {
	
	@Test
	public void testCreate() {
		Contact contact =  new Contact("name", "phone", "email");
		assertEquals ("name", contact.getName());
		assertEquals ("phone", contact.getPhone());
		assertEquals ("email", contact.getEmail());
	}
	
	@Test
	public void testSimpleCreate() {
		Contact contact =  new Contact("name");
		assertEquals ("name", contact.getName());
		assertNull ("phone", contact.getPhone());
		assertNull ("email", contact.getEmail());
	}
	
	@Test
	public void testSets() {
		Contact contact =  new Contact("name", "phone", "email");
		contact.setName("otherName");
		assertEquals ("otherName", contact.getName());
		contact.setPhone("otherPhone");
		assertEquals ("otherPhone", contact.getPhone());
		contact.setEmail("otherEmail");
		assertEquals ("otherEmail", contact.getEmail());
	}
	
	@Test
	public void testCompare() {
		Contact contact1 =  new Contact("name", "phone", "email");
		Contact contact2 =  new Contact("name", "phone2", "email");
		Contact contact3 =  new Contact("name", "phone", "email3");
		Contact contact4 =  new Contact("name", "phone", "email");
		
		assertFalse(contact1.equals(contact2));
		assertFalse(contact1.equals(contact3));
		assertTrue(contact1.equals(contact4));
		
		Contact contactDiff =  new Contact("name2", "phone", "email");
		assertEquals(0, contact1.compareTo(contact4));
		assertEquals(0, contact1.compareTo(contact2));   // same b/c of name
		assertEquals(0, contact1.compareTo(contact3));   // same b/c of name
		
		assertTrue(contact1.compareTo(contactDiff) < 0);
	}
	
	@Test
	public void testEqualsOddCases() {
		Contact contact1 =  new Contact("name", "phone", "email");
		Contact contact2 =  new Contact("name", null, "email");
		Contact contact3 =  new Contact("name", "phone", null);
		Contact contact4 =  new Contact(null, "phone", "email");
		
		assertFalse (contact1.equals(null));
		assertFalse (contact1.equals("something"));
		assertFalse (contact1.equals(contact2));
		assertFalse (contact1.equals(contact3));
		assertFalse (contact1.equals(contact4));
		
		assertEquals (contact2, contact2);
		
	}
	
	@Test
	public void testToString() {
		Contact contact =  new Contact("name", "phone", "email");
		assertEquals ("name (ph:phone) (em:email)", contact.toString());
	}
}
