package example.start.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import example.start.model.Model;
import example.start.model.State;

/**
 * Rudimentary panel that renders the model to the user.
 */
public class StartingPanel extends JPanel {

	/** For EBC: Boundary object needs model so it can properly render iself. */
	Model model;

	public StartingPanel(Model m) {
		this.model = m;
	}

	/** This special method is the drawing method for a JPanel object. Override to include your desired behavior. */
	@Override
	public void paintComponent(Graphics g) {
		if (model != null) {
			State s = model.getState();
			Rectangle r = s.getLocation();
			if (model.isTails()) {
				g.fillRect(r.x, r.y, r.width, r.height);
				g.setColor(Color.WHITE);
				g.drawString(s.value(), (int)r.getCenterX(), (int)r.getCenterY());
			} else {
				g.drawRect(r.x, r.y, r.width, r.height);
				g.drawString(s.value(), (int)r.getCenterX(), (int)r.getCenterY());
			}
		}
	}

}
