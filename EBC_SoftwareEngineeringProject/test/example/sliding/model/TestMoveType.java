package example.sliding.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMoveType {

	@Test
	public void testMove() {
		assertEquals (1, MoveType.Right.deltaC); 
		assertEquals (0, MoveType.Right.deltaR);
	}

}
