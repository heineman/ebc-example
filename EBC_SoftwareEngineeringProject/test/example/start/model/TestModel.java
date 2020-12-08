package example.start.model;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Test;

public class TestModel {
	@Test
	public void testSomething() {
		Model m = new Model();
		State s = new State("Heads", "Tails", new Rectangle(10,20,30,40));
		m.setState(s);
		assertEquals("Heads", m.getState().side1);
	}
	

}
