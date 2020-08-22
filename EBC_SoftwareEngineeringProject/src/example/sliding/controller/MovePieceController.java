package example.sliding.controller;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.boundary.UpdateButtons;
import example.sliding.model.Model;
import example.sliding.model.MoveType;

public class MovePieceController {
	Model model;
	SlidingPuzzleApp app;
	
	public MovePieceController(Model m, SlidingPuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(MoveType dir) {
		if (model.getSelectedPiece() == null) { return false; }
		
		if (model.tryMove(dir)) {
			UpdateButtons.enableButtons(app, model.availableMoves());
			
			app.getActualMovesLabel().setText("" + model.getNumMoves());
			app.repaint();
		}
		
		return true;
	}
	
}
