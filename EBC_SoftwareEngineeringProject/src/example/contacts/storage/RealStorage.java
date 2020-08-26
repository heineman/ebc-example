package example.contacts.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import example.contacts.model.Contact;

/**
 * Storage uses 'tab' character to separate values. One contact stored per line
 */
public class RealStorage implements IStorage {
	File storageFile = new File("contactsList.txt");
	
	public static final String SEP = "\t";

	@Override
	public Iterator<Contact> contacts() {
		ArrayList<Contact> contacts = new ArrayList<>();

		Scanner sc;
		try {
			sc = new Scanner(storageFile);
		} catch (FileNotFoundException fnfe) {
			return contacts.iterator();
		}

		// retrieve each contact, one at a time.
		try {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] vals = line.split(SEP);
				Contact c = new Contact(vals[0], vals[1], vals[2]);
				contacts.add(c);
			}
		} finally {
			sc.close();
		}

		return contacts.iterator();
	}

	@Override
	public boolean store(Iterator<Contact> it) {
		try (PrintStream ps = new PrintStream(storageFile)) {
			while (it.hasNext()) {
				Contact c = it.next();
				ps.println(c.getName() + SEP + c.getPhone() + SEP + c.getEmail());
			}
		} catch (IOException ioe) {
			return false;
		}
		
		return true;
	}

}
