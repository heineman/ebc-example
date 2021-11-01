package example.sliding.model;

import java.util.Optional;

import org.junit.Before;

public abstract class ModelTestCase { 

	protected Model model;
	
	/** Helper test method for location a piece by a coordinate. */
	protected Optional<Piece> getPiece(Coordinate c) {
		for (Piece p : model.getPuzzle()) {
			if (p.contains(c)) {
				return Optional.of(p);
			}
		}
		
		return Optional.empty(); 
	}
	
	@Before
	public void setUp() { 
		model  = new Model();
		
		Puzzle puzzle = new Puzzle(4, 5);
		puzzle.setExitColumn(1);
		puzzle.setExitRow(3);
		puzzle.setExitDirection(MoveType.Down);
		
		Piece p = new Piece(2, 2);
		p.setWinner(true);
		puzzle.add(p, 1, 0);
		
		puzzle.add(new Piece(1, 2), 0, 0);
		puzzle.add(new Piece(1, 2), 3, 0);
		
		puzzle.add(new Piece(1, 2), 0, 2);
		puzzle.add(new Piece(1, 2), 3, 2);
		
		puzzle.add(new Piece(1, 1), 1, 2);
		puzzle.add(new Piece(1, 1), 2, 2);
		puzzle.add(new Piece(1, 1), 2, 3);
		puzzle.add(new Piece(1, 1), 1, 3);
		
		puzzle.add(new Piece(2, 1), 1, 4);
		
		model.setPuzzle(puzzle);
	}

}
