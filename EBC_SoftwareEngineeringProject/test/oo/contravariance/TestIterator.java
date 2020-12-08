package oo.contravariance;

import java.util.Iterator;

import junit.framework.TestCase;

public class TestIterator extends TestCase {
	
	public void testFor() {
		Polygon p = new Polygon();
		assertTrue (p.isEmpty());
		
		p.addPoint(new Point (10,20));
		p.addPoint (new Point (5,5));
		
		for (Iterator<Point> it = p.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		
		for (Point pt : p) {
			System.out.println (pt);
		}
	}
	
	public void testConcurrent() {
		Polygon p = new Polygon();
		assertTrue (p.isEmpty());
		
		p.addPoint(new Point (10,20));
		p.addPoint (new Point (5,5));
		
		Iterator<Point> it1 = p.iterator();
		Iterator<Point> it2 = p.iterator();
		
		assertEquals (new Point (10,20), it1.next());
		assertEquals (new Point (10,20), it2.next());
		assertEquals (new Point (5,5), it2.next());
		assertFalse (it2.hasNext());
		assertTrue (it1.hasNext());
		assertEquals (new Point (5,5), it1.next());
	}
	
	public void testEmptyIterator() {
		Polygon p = new Polygon();
		assertTrue (p.isEmpty());
		
		Iterator<Point> it = p.iterator();
		assertFalse (it.hasNext());
	}
	
	public void testNonEmpty() {
		Polygon p = new Polygon();
		assertTrue (p.isEmpty());
		
		p.addPoint(new Point (10,20));
		p.addPoint (new Point (5,5));
		
		Iterator<Point> it = p.iterator();
		assertTrue (it.hasNext());
	}
	
	public void testElements() { 
		Polygon p = new Polygon();
		assertTrue (p.isEmpty());
		
		p.addPoint(new Point (10,20));
		p.addPoint (new Point (5,5));
		
		Iterator<Point> it = p.iterator();
		assertEquals (new Point (10,20), it.next());
		assertEquals (new Point (5,5), it.next());
		assertFalse (it.hasNext());
	}
}
