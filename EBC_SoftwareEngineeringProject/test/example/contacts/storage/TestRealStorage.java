package example.contacts.storage;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import example.contacts.model.Contact;

public class TestRealStorage {

	@Test
	public void testSampleReal() {
		RealStorage rs = new RealStorage();
		
		// DONE FOR TESTING so don't interfere.
		rs.storageFile = new File (new File ("test"), "testContacts.txt");
		rs.storageFile.delete();
		
		Contact contact1 =  new Contact("name1", "phone1", "email1");
		Contact contact2 =  new Contact("name2", "phone2", "email2");
		ArrayList<Contact> list = new ArrayList<Contact>();
		list.add(contact1);
		list.add(contact2);
		rs.store(list.iterator());
		
		Iterator<Contact> it = rs.contacts();
		
		ArrayList<Contact> newlist = new ArrayList<Contact>();
		newlist.add(it.next());
		newlist.add(it.next());
		
		assertTrue(newlist.contains(contact1));
		assertTrue(newlist.contains(contact2));
		
		assertTrue(rs.storageFile.length() > 0);
		rs.storageFile.delete();
	}
}
