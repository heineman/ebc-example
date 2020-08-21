package example.sliding.model;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Piece selectedPiece;
	
	public Model () {
		
	}
	
	public void setPuzzle(Puzzle p) { puzzle = p; }
	public Puzzle getPuzzle() { return puzzle; }
	
	public void setSelectedPiece(Piece p) { selectedPiece = p; }
	public void clearSelectedPiece() { selectedPiece = null; } 
	public Piece getSelectedPiece() { return selectedPiece; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
}
