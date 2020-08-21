package example.sliding.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Piece> {
	ArrayList<Piece> pieces = new ArrayList<>();
	
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
		pieces.add(p);
	}

	@Override
	public Iterator<Piece> iterator() {
		return pieces.iterator();
	}
	
}
