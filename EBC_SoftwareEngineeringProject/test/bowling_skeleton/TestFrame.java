package bowling_skeleton;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases are developed in tandem with the code.
 */
public class TestFrame {

	@Test
	public void test() {
		Game g = new Game();
		g.roll(7);
		assertEquals(7, g.score());
		g.roll(2);
		assertEquals(9, g.score());
	}
	
	@Test
	public void testCompleteGame() {
		Game g =new Game();
		int[] rolls = new int[] { 9, 1, 10, 2, 4, 7 ,3, 6, 2 ,0, 4, 5, 5, 7, 2, 6, 3, 9, 1, 5};
		for (int r : rolls) {
			g.roll(r);
		}
		
		assertEquals (120, g.score());
	}
}
