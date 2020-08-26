package example.contacts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.contacts.controller.QuitController;
import example.contacts.model.*;
import example.contacts.view.ContactFrame;
import example.contacts.storage.IStorage;
import example.contacts.storage.RealStorage;
import example.contacts.util.Util;

public class Main {
	public static void main(String args[]) {
		Model m = new Model(); 
		
		// load up from test storage
		IStorage st = new RealStorage(); 
		st.contacts().forEachRemaining(c -> m.add(c));
		
		ContactFrame frame = new ContactFrame(m);
		frame.populate();
		
		frame.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				 if (new QuitController().confirm(frame)) {
					 st.store(m.contacts());
                     frame.dispose();
             }
			}
		});
		
		Util.centerFrame(frame);
		frame.setVisible(true);
	} 
}
