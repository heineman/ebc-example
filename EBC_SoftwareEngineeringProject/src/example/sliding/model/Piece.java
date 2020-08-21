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

}
