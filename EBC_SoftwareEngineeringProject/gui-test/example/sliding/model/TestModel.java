package example.sliding.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class TestModel extends ModelTestCase { 

	@Test
	public void testInitialState( ) {
		assertEquals (0, model.getNumMoves());
		assertTrue (model.getSelectedPiece() == null);
		
		// no moves available.
		assertEquals (0, model.availableMoves().size());
	}
	
	@Test
	public void testPossibleMove() {
		Piece p = this.getPiece(new Coordinate(1, 4)).get(); 
		assertEquals (2, p.width);
		assertEquals (1, p.height);
		model.setSelectedPiece(p);
		
		List<MoveType> available = model.availableMoves();
		assertEquals (2, available.size());
		assertTrue (available.contains(MoveType.Left));
		assertTrue (available.contains(MoveType.Right));
	}
	
	@Test
	public void testMove() {
		assertFalse (model.tryMove(MoveType.Left));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 4)).get(); 
		model.setSelectedPiece(p);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (1, model.getNumMoves());
		assertEquals (new Coordinate(0, 4), p.getLocation());
	}
	
	@Test
	public void testBadMoves() {
		Piece p = this.getPiece(new Coordinate(0,0)).get(); 
		model.setSelectedPiece(p);
		assertEquals (0, model.availableMoves().size());
		
		p = this.getPiece(new Coordinate(3,0)).get(); 
		model.setSelectedPiece(p);
		assertEquals (0, model.availableMoves().size());
	}
	
	@Test
	public void testReset() {
		assertFalse (model.tryMove(MoveType.Left));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 4)).get(); 
		model.setSelectedPiece(p);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (1, model.getNumMoves());
		assertEquals (new Coordinate(0, 4), p.getLocation());
		
		model.resetPuzzle();
		assertEquals (0, model.getNumMoves());
		p = this.getPiece(new Coordinate(1, 4)).get(); 
		assertTrue(p != null);
	}
	
	@Test
	public void testWin() {
		assertFalse (model.isGameOver());
		model.setGameOver(true);
		assertTrue (model.isGameOver());
		model.setGameOver(false);
		
		assertFalse (model.isWinCondition(MoveType.Left));
		Piece p = this.getPiece(new Coordinate(2, 0)).get();
		assertTrue (p.isWinner);
		
		model.setSelectedPiece(p);
		
		assertFalse (model.isWinCondition(MoveType.Down));
	}
	
}
