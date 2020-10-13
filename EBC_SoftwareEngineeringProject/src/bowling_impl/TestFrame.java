package bowling_impl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases I developed as I was implementing this Bowling application.
 */
public class TestFrame {

	@Test
	public void test() {
		Frame f = new Frame(9,null);
		assertEquals (0, f.getNumRolls());
	}
	
	@Test
	public void testOneRoll() {
		Frame f = new Frame(9,null);
		assertEquals (0, f.getNumRolls());
		f.roll(6);
		assertEquals (1, f.getNumRolls());
	}

	@Test
	public void testTwoRoll() {
		Frame f = new Frame(9,null);
		assertEquals (0, f.getNumRolls());
		f.roll(6);
		assertEquals (1, f.getNumRolls());
		f.roll(3);
		assertEquals (2, f.getNumRolls());
	}
	
	@Test
	public void testGame() {
		Game g= new Game();
		g.roll(1);
		assertEquals (1, g.score());
		g.roll(4);
		assertEquals (5, g.score());
		g.roll(4);
		assertEquals (9, g.score());
		g.roll(5);
		assertEquals (14, g.score());
		g.roll(6);
		assertEquals (20, g.score());
		g.roll(4);
		assertEquals (24, g.score());
		g.roll(5);
		assertEquals (34, g.score());
		g.roll(5);
		assertEquals (39, g.score());
		g.roll(10);
		assertEquals (59, g.score());
		g.roll(0);
		assertEquals (59, g.score());
		g.roll(1);
		assertEquals (61, g.score());   // this tracked down the defect!!! problem with isSpare() method
		g.roll(7);
		assertEquals (68, g.score());   
		g.roll(3);
		assertEquals (71, g.score());   
		g.roll(6);
		assertEquals (83, g.score());   // note 77 score never shows up since we move right onto the spare+6
		g.roll(4);
		assertEquals (87, g.score());
		g.roll(10);
		assertEquals (107, g.score());
		g.roll(2);
		assertEquals (111, g.score());   // IF at this point, all future rolls were 0, this would be score
		g.roll(8);
		assertEquals (127, g.score());
		g.roll(6);
		assertEquals (133, g.score());
	}
	
	// another example
	@Test
	public void testAnother1() {
		// http://bowlmovementswy.blogspot.com/2010_04_01_archive.html
		Game g= new Game();
		g.roll(9);
		g.roll(1);
		g.roll(7);
		g.roll(1);
		g.roll(8);
		g.roll(0);
		g.roll(10);
		g.roll(10);  // note: two strikes in a row -- must test this
		g.roll(8);
		g.roll(0);
		g.roll(10);
		g.roll(10);
		g.roll(8);
		g.roll(1);
		g.roll(7);
		g.roll(3);
		g.roll(9);
		assertEquals (162, g.score());
	}
	
	@Test
	public void testTurkey() {
		Game g= new Game();
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);  
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		assertEquals (300, g.score());
	}
	
}
