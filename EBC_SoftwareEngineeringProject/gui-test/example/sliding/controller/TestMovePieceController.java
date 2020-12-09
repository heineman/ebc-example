package example.sliding.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.sliding.model.Coordinate;
import example.sliding.model.MoveType;

public class TestMovePieceController extends AppTestCase {
	
	@Test
	public void testMove() {
		SelectPieceController spc = new SelectPieceController (model, app);
		Point pt = coordinateToPoint(new Coordinate(1,4));
		assertEquals (new Coordinate(1,4), app.getPuzzlePanel().pointToCoordinate(pt));
		
		spc.process(pt);
		
		// now request move via MovePieceController
		MovePieceController mpc = new MovePieceController(model, app);
		assertTrue (mpc.move(MoveType.Left));

		// validate piece in that location
		assertEquals (model.getSelectedPiece(), this.getPiece(new Coordinate(0,4)).get());
	}
}
