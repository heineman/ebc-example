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
	
	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		
		if (o instanceof Coordinate) {
			Coordinate other = (Coordinate) o;
			return col == other.col && row == other.row;
		}
		
		return false;
	}
}
