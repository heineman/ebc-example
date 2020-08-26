package example.contacts.controller;

import javax.swing.*;

public class QuitController {
	public boolean confirm(JFrame app) {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			return true;
		}

		// don't exit
		return false;
	}
}
