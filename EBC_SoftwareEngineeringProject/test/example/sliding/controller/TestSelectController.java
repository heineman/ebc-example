package example.sliding.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import example.sliding.model.Coordinate;
import example.sliding.model.Piece;

public class TestSelectController extends AppTestCase {
	
	@Test
	public void testSelect() {
		SelectPieceController spc = new SelectPieceController (model, app);
		Point pt = coordinateToPoint(new Coordinate(1,4));
		assertEquals (new Coordinate(1,4), app.getPuzzlePanel().pointToCoordinate(pt));
		
		spc.process(pt);
		
		Piece p = getPiece(new Coordinate(1, 4)).get(); 
		assertEquals (p, model.getSelectedPiece());
		
		// this piece can only move left and right. ensure buttons are enabled/disabled
		assertTrue (app.getLeftButton().isEnabled());
		assertTrue (app.getRightButton().isEnabled());
		assertFalse (app.getUpButton().isEnabled());
		assertFalse (app.getDownButton().isEnabled());
	}
}
