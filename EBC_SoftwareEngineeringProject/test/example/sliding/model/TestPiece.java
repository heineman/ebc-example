package example.sliding.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPiece {

	@Test
	void testConstruction() {
		Piece piece = new Piece(1, 2);
		assertEquals (1, piece.width);
		assertEquals (2, piece.height);
	}
	
	@Test
	void testContains() {
		Piece p = new Piece (1, 2);
		p.setRow(0);
		p.setColumn(0);
		
		/**
		 * (0,0)
		 * (0,1)
		 */
		assertTrue(p.contains(new Coordinate(0,0)));
		assertTrue(p.contains(new Coordinate(0,1)));
		
		assertFalse(p.contains(new Coordinate(1,1)));
	}

}
