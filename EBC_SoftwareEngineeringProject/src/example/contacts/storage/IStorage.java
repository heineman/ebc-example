package example.contacts.storage;

import java.util.Iterator;

import example.contacts.model.Contact;

/**
 * Interface for managing storage.
 *
 * This could have been fine-grained, allowing for specific requests such as:
 *    1. Add contact
 *    2. Update contact
 *    3. Delete contact
 *    
 * For now, this is simply defined by two methods. Use {@link IStorage#contacts()} to load from
 * storage all contacts. Use @link {@link IStorage#store(Iterator)} to store the contacts back to
 * persistent storage. Typically the store is completed by user request or when application exits. 
 */
public interface IStorage {
	/** Retrieve contacts. */
	Iterator<Contact> contacts();
	
	/** Store updated contacts. */
	boolean store(Iterator<Contact> it);
}
