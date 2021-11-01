package example.oval.controller;

import static org.junit.Assert.*;

import org.junit.*;

import example.oval.model.Model;
import example.oval.view.*;

public class TestOvalCreator extends generic.MouseEventTestCase {
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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		app.setVisible(false);
	}
	
	@Test
	public void testCreateFirst() {
		OvalCreator controller = new OvalCreator(model, app.getPanel());
		OvalPanel panel = app.getPanel();
		
		assertTrue (model.getActive() == null);
		controller.mousePressed(this.createPressed(panel, 30, 80));
		controller.mouseDragged(this.createDragged(panel, 100, 180));
		
		assertTrue (model.getActive() != null);
		
		controller.mouseReleased(this.createReleased(panel, 100, 180));
		
		// one oval exists and none are active.
		assertEquals (1, model.getOvals().size());
		assertTrue (model.getActive() == null);
		app.repaint();
	}
}
