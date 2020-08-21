package example.sliding.model;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Piece selectedPiece;
	
	/**
	 *  (0,0) (1,0) (2,0)
	 *  (0,1) (1,1) (2,1)
	 *  (0,2) (1,2)
	 *  (0,3) (1,3)
	 *  (0,4) (1,4)
	 * 
	 */
	public Model () {
		puzzle = new Puzzle(4, 5);
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
	}
	
	public void setPuzzle(Puzzle p) { puzzle = p; }
	public Puzzle getPuzzle() { return puzzle; }
	
	public void setSelectedPiece(Piece p) { selectedPiece = p; }
	public void clearSelectedPiece() { selectedPiece = null; } 
	public Piece getSelectedPiece() { return selectedPiece; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
}
