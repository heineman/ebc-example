package example.contacts.controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import example.contacts.model.*;
import example.contacts.view.*;
import example.contacts.util.Util;

public class AddContactController {
	
	Model model;
	ContactFrame frame;
	
	public AddContactController (Model m, ContactFrame frame) {
		this.model = m;
		this.frame = frame;
	}
	
	public void process() {
		String sss = JOptionPane.showInputDialog("Please enter some text");
		System.out.println(sss);
		IndividualContactFrame icf = new IndividualContactFrame(new Contact(""));
		icf.getNameField().setEditable(true);
		icf.getOkButton().setEnabled(false);
		icf.setModal(true);
		Util.centerFrame(icf);
		icf.setVisible(true);
		
		// only get here when user properly completes dialog
		if (icf.wasUpdated()) { 
			act(icf);
		}

		icf.dispose();     // otherwise thread lingers
		frame.repaint();   // refresh
	}
	
	/** 
	 * Real logic here, once 'ok' pressed in IndividualContactFrame, when starting with new Contact. 
	 * Pulled out separately so this method can be tested.
	 */
	void act(IndividualContactFrame icf) {
		
		Contact newContact = icf.getContact();
		newContact.setName(icf.getNameField().getText());  
		newContact.setEmail(icf.getEmailField().getText());
		newContact.setPhone(icf.getPhoneField().getText());
		
		// this might replace any existing ones.
		model.add(newContact);
		
		// to ensure sorting.
		JList<Contact> list =  frame.getContactsList();
		DefaultListModel<Contact> lm = (DefaultListModel<Contact>) list.getModel();
		lm.removeAllElements();
		for (Contact ct : model.getArray()) {
			lm.addElement(ct);
		}
	}
}
