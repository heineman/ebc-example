package example.contacts.view;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import example.contacts.controller.*;
import example.contacts.model.Contact;
import example.contacts.model.Model;

import javax.swing.JButton;
import javax.swing.JList;

public class ContactFrame extends JFrame {
	
	Model model;
	
	JButton addButton;
	JButton updateButton;
	JButton removeButton;
	JList<Contact> contactsList;
	
	/** Can navigate to the contacts list. */
	public JList<Contact> getContactsList() {
		return contactsList;
	}
	
	/** Can navigate to the buttons. */
	public JButton getAddButton() { return addButton; }
	public JButton getRemoveButton() { return removeButton; }
	public JButton getUpdateButton() { return updateButton; }
	
	public ContactFrame(Model m) {
		this.model = m;
		setSize(500, 320);
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		JLabel lblContacts = new JLabel("Contacts:"); 
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		addButton = new JButton("Add");
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		
		removeButton = new JButton("Remove");
		removeButton.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
						.addComponent(lblContacts)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(removeButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(112)
							.addComponent(updateButton)
							.addGap(145)
							.addComponent(addButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblContacts)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(removeButton)
						.addComponent(updateButton)
						.addComponent(addButton))
					.addContainerGap())
		);

		contactsList = new JList<Contact>();
		contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(contactsList);
		getContentPane().setLayout(groupLayout);
		
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RemoveSelectedController(model, ContactFrame.this).process();
			} 
		});
		
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateContactController(model, ContactFrame.this).process();
			} 
		});
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddContactController(model, ContactFrame.this).process();
			} 
		});
		
		contactsList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				new SelectItemController (model, ContactFrame.this).process();
			}			
		});
	}
	
	/** Populate contact list from Model. */
	public void populate() {
		DefaultListModel<Contact> dlm = new DefaultListModel<Contact>();
		Contact[] values = model.getArray();
		for (Contact c : values) {
			dlm.addElement(c);
		}
				
		contactsList.setModel(dlm);
	}

}
