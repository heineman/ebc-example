package example.sliding.model;

import java.util.ArrayList;

public class Puzzle {
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
	
}
