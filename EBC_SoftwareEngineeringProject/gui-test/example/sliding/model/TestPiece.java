package example.sliding.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPiece {

	@Test
	public void testConstruction() {
		Piece piece = new Piece(1, 2);
		assertEquals (1, piece.width);
		assertEquals (2, piece.height);
		assertFalse (piece.isWinner());
	}
	
	@Test
	public void testContains() {
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
	
	@Test
	public void testWinner() {
		Piece piece = new Piece(1, 2);
		piece.setWinner(true);
		assertTrue (piece.isWinner());
	}
	
	@Test
	public void testCopy() {
		Piece piece = new Piece(1, 2);
		Piece p2 = piece.copy();
		assertEquals (p2.row, piece.row); // could do more....
	}
	
	@Test
	public void testPlacement() {
		Piece piece = new Piece(1, 2);
		piece.setRow(2);
		assertEquals (2, piece.getRow());
		piece.setColumn(1);
		assertEquals (1, piece.getColumn());
	}

	@Test
	public void testMove() {
		Piece piece = new Piece(1, 2);
		piece.setColumn(2);
		piece.setRow(1);
		piece.move(MoveType.Right);
		
		assertEquals(3, piece.getColumn());
		assertEquals(new Coordinate(3, 1), piece.getLocation());
	}
	
}
