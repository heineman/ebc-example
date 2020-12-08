package example.sliding.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPuzzle {

	@Test
	public void testConst() {
		Puzzle p = new Puzzle(4, 5);
		assertEquals (4, p.numColumns);
		assertEquals (5, p.numRows);
	}
	
	@Test
	public void testMethods() {
		Puzzle p = new Puzzle(4, 5);
		assertEquals (4, p.numColumns);
		assertEquals (5, p.numRows);
		p.setExitColumn(1);
		p.setExitRow(2);
		p.setExitDirection(MoveType.Up);
		
		assertEquals (1, p.getExitColumn());
		assertEquals (2, p.getExitRow());
		assertEquals (MoveType.Up, p.getExitDirection());
	}
}
