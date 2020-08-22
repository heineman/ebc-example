package example.sliding.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Piece selectedPiece;
	int numMoves = 0;
	
	/**
	 *  (0,0) (1,0) (2,0)
	 *  (0,1) (1,1) (2,1)
	 *  (0,2) (1,2)
	 *  (0,3) (1,3)
	 *  (0,4) (1,4)
	 * 
	 */
	public Model () {
		
	}
	
	public boolean tryMove(MoveType dir) {
		if (selectedPiece == null) { return false; }
		
		for (MoveType move : availableMoves()) {
			if (dir == move) {
				selectedPiece.move(dir);
				numMoves ++;
				return true;
			}
		}
		
		return true;
	}
	
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedPiece == null) {
			return moves;
		}
		return availableMoves(selectedPiece);
	}
	
	public List<MoveType> availableMoves(Piece p) {
		ArrayList<MoveType> moves = new ArrayList<>();
		
		Coordinate coord = p.getLocation();
		
		if (p.isWinner()) {
			int exitCol = puzzle.getExitColumn();
			int exitRow = puzzle.getExitRow();
			Coordinate exitCoord = new Coordinate(exitCol, exitRow);
			if (coord.equals(exitCoord)) {
				moves.add(MoveType.Down);
			}
		}
		
		// Left?
		if (coord.col > 0) {
			boolean available = true;
			for (int r = 0; r < p.height; r++) {
				if (puzzle.isCovered(new Coordinate(coord.col - 1, coord.row))) {
					available = false;
				}
			}
			if (available) {
				moves.add(MoveType.Left);
			}
		}
		
		// Right?
		if (coord.col + p.width < puzzle.numColumns) {
			boolean available = true;
			for (int r = 0; r < p.height; r++) {
				if (puzzle.isCovered(new Coordinate(coord.col + p.width, coord.row))) {
					available = false;
				}
			}
			if (available) {
				moves.add(MoveType.Right);
			}
		}
		
		// Up?
		if (coord.row > 0) {
			boolean available = true;
			for (int c = 0; c < p.width; c++) {
				if (puzzle.isCovered(new Coordinate(coord.col, coord.row - 1))) {
					available = false;
				}
			}
			if (available) {
				moves.add(MoveType.Up);
			}
		}
				
		// Down?
		if (coord.row + p.height < puzzle.numRows) {
			boolean available = true;
			for (int c = 0; c < p.width; c++) {
				if (puzzle.isCovered(new Coordinate(coord.col, coord.row + p.height))) {
					available = false;
				}
			}
			if (available) {
				moves.add(MoveType.Down);
			}
		}
		
		return moves;
	}
	
	public void setPuzzle(Puzzle p) { 
		puzzle = p;
		numMoves = 0;
		gameOver = false;
		selectedPiece = null;
	}
	public Puzzle getPuzzle() { return puzzle; }
	
	public void setSelectedPiece(Piece p) { selectedPiece = p; }
	public void clearSelectedPiece() { selectedPiece = null; } 
	public Piece getSelectedPiece() { return selectedPiece; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }

	public int getNumMoves() { return numMoves; }
	
	public void resetPuzzle() {
		puzzle.reset();
		selectedPiece = null;
		numMoves = 0;
		gameOver = false;
	}

	public boolean isWinCondition(MoveType dir) {
		if (selectedPiece == null) { return false; }
		if (!selectedPiece.isWinner) { return false; }
		
		return puzzle.isWinCondition(selectedPiece.getColumn(), selectedPiece.getRow(), dir);
	}
}
