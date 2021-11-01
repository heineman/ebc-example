package example.oval.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class TestModel { 
	@Test
	public void testStart() {
		Model m = new Model();
		
		assertTrue (m.getActive() == null);
	}
	
	@Test
	public void testOperate() {
		Model m = new Model();
		
		Point p = new Point (30, 60);
		Oval o = new Oval(p, 10, 20);
		
		m.addOval(o);
		assertEquals (1, m.getOvals().size());
	}
	
	@Test
	public void testActive() {
		Model m = new Model();
		
		Point p = new Point (30, 60);
		Oval o = new Oval(p, 10, 20);
		
		m.setActiveOval(o);
		assertEquals (o, m.getActive());
	}
}
