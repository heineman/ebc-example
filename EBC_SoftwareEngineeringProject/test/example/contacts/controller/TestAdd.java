package example.contacts.controller;

import javax.swing.JList;

import org.junit.*;

import example.contacts.model.Contact;
import example.contacts.model.Model;
import example.contacts.view.ContactFrame;
import example.contacts.view.IndividualContactFrame;
import junit.framework.TestCase;

/** Actually validates IndividualContactFrame does the right thing. */
public class TestAdd extends TestCase {

	Model model;
	ContactFrame frame;
	Contact c1;
	
	@Before
	public void setUp() {
		model = new Model();
		c1 = new Contact("Someone", "1-508-831-0000", "someone@wpi.edu");
		model.add(c1);
		frame = new ContactFrame(model);
		frame.populate();
		frame.setVisible(true);
	}
	
	@After
	public void tearDown() {
		frame.setVisible(false);
		frame.dispose();
	}
	
	@Test
	public void testLoadedProperly() {
		Contact newContact = new Contact("");
		IndividualContactFrame icf = new IndividualContactFrame(newContact);
		icf.getNameField().setText("name1");
		icf.getPhoneField().setText("phone1");
		icf.getEmailField().setText("email1");
		icf.setVisible(true);
		
		// act on the dialog using the 2nd half of the controller.
		new AddContactController(model, frame).act(icf);
		icf.dispose();
		
		assertEquals ("name1", newContact.getName());
		assertEquals ("phone1", newContact.getPhone());
		assertEquals ("email1", newContact.getEmail());		
		
		JList<Contact> list = frame.getContactsList();
		assertEquals (2, list.getModel().getSize());
	}
}
