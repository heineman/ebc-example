package example.oval.view;

import java.awt.Point;

import org.junit.*;

import example.oval.model.Model;
import example.oval.model.Oval;

public class TestOvalPanel {

	Model model;
	Application app;
	
	@Before
	public void setUp() {
		model = new Model();
		app = new Application(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() {
		app.setVisible(false);
	}
	
	// not much you can really do here other than ensure doesn't crash.
	@Test
	public void testDrawingWorks() {
		Point p = new Point (30, 60);
		Oval o = new Oval(p, 10, 20);
		
		model.addOval(o);
		app.panel.repaint();
		System.out.println("Drawn");
	}
}
