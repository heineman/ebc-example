package example.oval.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import example.oval.controller.*;
import example.oval.model.*;

/**
 * The Java GUI entity for visual display that supports mouse
 * interaction by registering mouse listeners.
 */
public class OvalPanel extends JPanel {
	Model model;
	
	public OvalPanel (Model m) {
		this.model = m;
	
		OvalCreator control = new OvalCreator(model, this);
		this.addMouseListener(control);
		this.addMouseMotionListener(control); 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ArrayList<Oval> circles = model.getOvals();
		int idx = 1;
		for (Oval c : circles) {
			g.setColor(Color.black);
			g.drawOval(c.x, c.y, c.width, c.height);
			g.setColor(Color.gray);
			Font font = new Font("Comic Sans MS", Font.PLAIN, c.height);
			g.setFont(font);
			g.drawString(""+idx, c.x + c.width/4, c.y + c.height);
			idx++;
		}
		
		g.setColor(Color.red);
		Oval active = model.getActive();
		if (active != null) {
			g.drawOval(active.x, active.y, active.width, active.height);
		}
	}
}
