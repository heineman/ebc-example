package example.sliding.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Piece> {
	ArrayList<Piece> pieces = new ArrayList<>();
	
	ArrayList<Piece> originals = new ArrayList<>();
	
	public final int numRows;
	public final int numColumns;
	int exitRow;
	int exitColumn;
	MoveType exitDirection;
	
	public Puzzle(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}
	
	public void setExitRow(int r) { exitRow = r; }
	public int getExitRow() { return exitRow; }
	
	public void setExitColumn(int c) { exitColumn = c; }
	public int getExitColumn() { return exitColumn; }
	
	public void setExitDirection(MoveType dir) { exitDirection = dir; }
	public MoveType getExitDirection() { return exitDirection; }

	public void add(Piece p, int col, int row) {
		p.setColumn(col);
		p.setRow(row);
		
		// check overlapping....
		
		pieces.add(p);
		originals.add(p.copy());
	}
	
	public boolean isCovered(Coordinate coord) {
		for (Piece p : pieces) {
			if (p.contains(coord)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator<Piece> iterator() {
		return pieces.iterator();
	}

	public void reset() {
		pieces.clear();
		for (Piece p: originals) {
			pieces.add(p.copy());
		}
	}

	public boolean isWinCondition(int col, int row, MoveType dir) {
		return col == exitColumn && row == exitRow && dir == exitDirection;
	}
	
}
