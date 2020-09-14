package example.contacts.controller;

import javax.swing.JList;

import example.contacts.model.*;
import example.contacts.view.*;
import example.contacts.util.Util;

public class UpdateContactController {
	
	Model model;
	ContactFrame frame;
	
	public UpdateContactController (Model m, ContactFrame frame) {
		this.model = m;
		this.frame = frame;
	}
	
	public void process() {
		JList<? extends Contact> list =  frame.getContactsList();
		int idx = list.getSelectedIndex();
		if (idx < 0) {
			return;
		} 

		Contact contact = list.getSelectedValue();
		IndividualContactFrame icf = new IndividualContactFrame(contact);
		icf.setModal(true);
		Util.centerFrame(icf);
		icf.setVisible(true);
		
		// only get here when user properly completes dialog
		if (icf.wasUpdated()) {
			act(icf);
		}
		
		icf.dispose();
		
		// refresh
		frame.repaint(); 
	}
	
	/** 
	 * Real logic here, once 'ok' pressed in IndividualContactFrame, when starting with new Contact. 
	 * Pulled out separately so this method can be tested.
	 */
	void act(IndividualContactFrame icf) {
		JList<? extends Contact> list =  frame.getContactsList();
		Contact contact = list.getSelectedValue();

		contact.setName(icf.getNameField().getText());   
		contact.setEmail(icf.getEmailField().getText());
		contact.setPhone(icf.getPhoneField().getText());
	}
}
