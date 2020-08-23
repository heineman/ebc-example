package example.sliding.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;
import example.sliding.model.Puzzle;

public class PuzzlePanel extends JPanel {

	Model model;
	public static final int boxSize = 80;
	public static final int offset = 2;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computeRectangle (Piece p) {
		int col = p.getColumn();
		int row = p.getRow();
		
		// DEFECT
		Rectangle rect = new Rectangle(col*boxSize + offset, row*boxSize + offset, p.width*boxSize - 2*offset, p.height*boxSize - 2*offset);
		return rect;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.x/boxSize, p.y/boxSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; } // nothing to draw. Only here for windowbuilder.
		
		Piece selectedPiece = model.getSelectedPiece();
		Puzzle puzzle = model.getPuzzle();
		for (Piece p : puzzle) {
			
			if (p.equals(selectedPiece)) {
				g.setColor(Color.yellow);
			} else {
				if (p.isWinner()) {
					g.setColor(Color.red);;
				} else {
					g.setColor(Color.gray);
				}
			}
			
			Rectangle r = computeRectangle(p);
			g.fillRect(r.x, r.y, r.width, r.height);
		}	
	}
}
