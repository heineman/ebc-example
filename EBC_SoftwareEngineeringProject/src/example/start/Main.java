package example.start;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.start.controller.ExitController;
import example.start.model.Model;
import example.start.model.State;
import example.start.view.StartingFrame;

/**
 * This class exists outside of the traditional EBC since it is the launcher class.
 * Here the initialization is straightforward since there is no persistent behavior. That is,
 * we construct a new model each time. With more sophisticated requirements, the state would need
 * to be retrieved from persistent storage.
 *
 */
public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		State s = new State("Win", "Lose", new Rectangle(100, 100, 100, 100));
		model.setState(s);

		StartingFrame app = new StartingFrame(model);

		// Java ability to register a controller to react to attempts by user to close a window.
		app.addWindowListener (new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new ExitController(app).process();
			}

		});

		// this starts off the whole application.
		app.setVisible(true);
	}
}
