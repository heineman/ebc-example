package example.contacts.controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import example.contacts.model.*;
import example.contacts.view.*;

public class RemoveSelectedController {
	
	Model model;
	ContactFrame frame;
	
	public RemoveSelectedController (Model m, ContactFrame frame) {
		this.model = m;
		this.frame = frame;
	} 
	
	public void process() {
		JList<? extends Contact> list =  frame.getContactsList();
		int idx = list.getSelectedIndex();
		if (idx < 0) {
			return;
		}
		
		DefaultListModel<Contact> lm = (DefaultListModel<Contact>) list.getModel();
		
		Contact c = list.getSelectedValue();
		model.remove(c.getName());
		lm.remove(idx);
		
		// refresh
		frame.repaint();
	}
}
 