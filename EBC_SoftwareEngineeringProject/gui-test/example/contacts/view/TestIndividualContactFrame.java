package example.contacts.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import example.contacts.model.Contact;
import example.contacts.model.Model;

public class TestIndividualContactFrame {
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
	public void testIndivFrame() {
		IndividualContactFrame icf = new IndividualContactFrame();
		assertEquals ("sample", icf.getNameField().getText());
		assertTrue (icf.getOkButton() != null);
		assertFalse (icf.wasUpdated());
		icf.dispose();
	}
}
