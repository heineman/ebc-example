package example.sliding.controller;

import java.awt.Point;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.Piece;
import example.sliding.model.Puzzle;

public class SelectPieceController {
	Model model;
	SlidingPuzzleApp app;
	
	public SelectPieceController(Model m, SlidingPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();
		
		for (Piece p : puzzle) {
			if (p.contains(c)) {
				model.clearSelectedPiece();
				model.setSelectedPiece(p);
				app.repaint();
			}
		}
	}
	
}
