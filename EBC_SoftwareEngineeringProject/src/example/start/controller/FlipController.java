package example.start.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

import example.start.model.*;
import example.start.view.*;

/**
 * Controller that responds to mouse events (in particular PRESS) and acts accordingly by randomly
 * moving the state to a new location and flipping it.
 *
 * Could also have just implemented MouseListener but that would require additional work.
 */
public class FlipController extends MouseAdapter {

	Random rnd = new Random();

	final StartingFrame app;
	final Model model;

	public FlipController(StartingFrame app, Model m) {
		this.app = app;
		this.model = m;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		State s = model.getState();
		Rectangle r = s.getLocation();

		Point p = me.getPoint();
		if (r.contains(p)) {
			s.flip();

			// choose a new random location
			JPanel panel = app.getStartingPanel();
			int newX = (int) ((panel.getWidth() - 100)*rnd.nextDouble());
			int newY = (int) ((panel.getHeight() - 100)*rnd.nextDouble());

			Rectangle newR = new Rectangle(newX, newY, 100, 100);
			s.setLocation(newR);
			app.repaint();
		}
	}
}
