package example.oval.model;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

public class TestOval {
	
	@Test
	public void testConstructor() {
		Point p = new Point (30, 60);
		Oval o = new Oval(p, 10, 20);
		
		assertEquals (40, o.height);
		assertEquals (20, o.width);		
	}
}
