package example.sliding.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

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
		
		Rectangle rect = new Rectangle(col*boxSize, row*boxSize, p.width*(boxSize - offset), p.height*(boxSize - offset));
		return rect;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; } // nothing to draw. Only here for windowbuilder.
		
		Puzzle puzzle = model.getPuzzle();
		for (Piece p : puzzle) {
			g.setColor(Color.gray);
			Rectangle r = computeRectangle(p);
			g.fillRect(r.x, r.y, r.width, r.height);
		}	
	}
}
