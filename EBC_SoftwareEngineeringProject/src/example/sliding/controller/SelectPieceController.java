package example.sliding.controller;

import java.awt.Point;
import java.util.List;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.boundary.UpdateButtons;
import example.sliding.model.Coordinate;
import example.sliding.model.Model;
import example.sliding.model.MoveType;
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
				
				List<MoveType> moves = model.availableMoves(p);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
	}
	
}
