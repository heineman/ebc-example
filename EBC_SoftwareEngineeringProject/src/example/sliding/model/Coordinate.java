package example.sliding.model;

public class Coordinate {
	public final int col;
	public final int row;
	
	public Coordinate(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	public String toString () {
		return "(" + col + "," + row + ")";
	}
}
