package example.sliding.model;

public class Piece {
	public final int height;
	public final int width;
	boolean isWinner;
	int row;
	int col;
	
	public Piece(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public boolean isWinner() { return isWinner; }
	public void setWinner(boolean flag) { isWinner = flag; }
	
	public void setRow(int r) { this.row = r; }
	public void setColumn(int c) { this.col = c; }

	public int getColumn() { return col; }
	public int getRow() { return row; }
	public Coordinate getLocation () { return new Coordinate(col, row); }

	public boolean contains(Coordinate c) {
		if (c.col >= col && c.col < col + width && c.row >= row && c.row < row + height) {
			return true;
		}
		
		return false;
	}

}
