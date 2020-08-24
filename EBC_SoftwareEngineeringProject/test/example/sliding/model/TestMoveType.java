package example.sliding.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class TestMoveType {

	@Test
	public void testMove() {
		assertEquals (1, MoveType.Right.deltaC); 
		assertEquals (0, MoveType.Right.deltaR);
	}

}
