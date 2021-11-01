package oo.minimal;

import javax.swing.JFrame;

import oo.minimal.model.Model;
import oo.minimal.view.Application;

public class Main {
	public static void main(String[] args) {

		// create model first
		Model m = new Model(0);

		// then launch application 
		final Application app = new Application (m);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
