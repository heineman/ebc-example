package example.contacts.view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import example.contacts.model.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class IndividualContactFrame extends JDialog {
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField emailField;
	
	private JButton okButton;
	
	Contact contact;
	boolean updated = false; 
	
	public JTextField getNameField() { return nameField; }
	public JTextField getPhoneField() { return phoneField; }
	public JTextField getEmailField() { return emailField; }
	public JButton getOkButton() { return okButton; }
	
	public IndividualContactFrame(Contact c) {
		this.contact = c;
		setSize(500, 240);
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setText(c.getName());   // added manually
		nameField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setText(c.getPhone());   // added manually
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setText(c.getEmail());   // added manually
		
		okButton = new JButton("Ok");
		
		JButton cancelButton = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName)
							.addGap(69)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhoneNumber)
								.addComponent(lblEmail))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
								.addComponent(phoneField, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(okButton)
							.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
							.addComponent(cancelButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumber)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(cancelButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		// Simply hide to remove
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updated = false;
				IndividualContactFrame.this.setVisible(false);
			}
		});
		
		// Locally enable button IF name field has any value.
		nameField.addKeyListener(new KeyAdapter()  {
			@Override
			public void keyReleased(KeyEvent e) {
				okButton.setEnabled(nameField.getText().length() > 0);
			}
		});
		
		// Hide but update contact
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updated = true; 
				IndividualContactFrame.this.setVisible(false);
			}
		});
	}
	
	public boolean wasUpdated() { return updated; }
	public Contact getContact() { return contact; }
	
	/** Only here for WindowBuilder. */
	IndividualContactFrame() {
		this (new Contact ("sample", "1-800-123-4567", "example@example.com"));
	}
}
