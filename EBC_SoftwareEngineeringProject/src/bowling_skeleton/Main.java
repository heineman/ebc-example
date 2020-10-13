package bowling_skeleton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import bowling.IBowling;
import bowling.view.GameView;

/**
 * Sample implementation conforming to the existing classes in bowling package.
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IBowling model = new Game();
		final GameView frame = new GameView(model);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}      
		});
	}

}
