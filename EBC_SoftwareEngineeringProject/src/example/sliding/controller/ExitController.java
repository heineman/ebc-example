package example.sliding.controller;

import javax.swing.JOptionPane;
import example.sliding.boundary.SlidingPuzzleApp;

public class ExitController {
	SlidingPuzzleApp app;
	
	public ExitController(SlidingPuzzleApp app) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
	
}
