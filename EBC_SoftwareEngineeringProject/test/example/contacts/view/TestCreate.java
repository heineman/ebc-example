package example.contacts.view;

import javax.swing.JList;

import org.junit.*;

import example.contacts.model.Contact;
import example.contacts.model.Model;
import junit.framework.TestCase;

/** Just validates that the GUI shows up. */
public class TestCreate extends TestCase {

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
		JList<Contact> list = frame.getContactsList();
		assertEquals (1, list.getModel().getSize());
		
		Contact c = list.getModel().getElementAt(0);
		assertEquals (c1, c);
	}
}
