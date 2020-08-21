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

}
