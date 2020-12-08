package example.range.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import example.range.model.Model;
import example.range.view.App;

public class TestComputeController {

	Model model;
	App app;

	@Before
	public void setUp() throws Exception {
		model = new Model();
		app = new App(model);
		app.setVisible(true);

		// If you ever have your GUI just "HANG" and not stop, this is low-level Swing
		// Issue and we can avoid this if we just pause for small time (50 milliseconds)
		Thread.sleep(50);
	}

	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
		app.dispose();
	}
	

	@Test
	public void test() {
		app.getStartDateField().setText("11/03/2019");
		app.getEndDateField().setText("11/09/2019");

		ComputeController cc = new ComputeController(app, model);
		cc.compute();

		assertEquals (6, model.range());
	}
}
