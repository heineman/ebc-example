package example.sliding.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import example.sliding.model.Coordinate;
import example.sliding.model.MoveType;
import example.sliding.model.Piece;

public class TestResetController extends AppTestCase {
	
	@Test
	public void testReset() {
		Piece p = this.getPiece(new Coordinate(1,4)).get(); // piece in bottom of '012' state
		model.setSelectedPiece(p);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (1, model.getNumMoves());
		assertTrue (getPiece(new Coordinate(0,4)).isPresent());  // moved
		
		ResetController rpc = new ResetController(model, app);
		rpc.reset();
		
		assertEquals (0, model.getNumMoves());
		assertFalse (getPiece(new Coordinate(0,4)).isPresent());  // no longer there
	}
}
