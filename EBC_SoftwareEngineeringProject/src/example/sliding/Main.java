package example.sliding;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.controller.ExitController;
import example.sliding.model.Model;
import example.sliding.model.MoveType;
import example.sliding.model.Piece;
import example.sliding.model.Puzzle;

public class Main {
	
	public static void main(String[] args) {
		Model m = new Model();
		
		Puzzle puzzle = new Puzzle(4, 5);
		puzzle.setExitColumn(1);
		puzzle.setExitRow(3);
		puzzle.setExitDirection(MoveType.Down);
		
		Piece p = new Piece(2, 2);
		p.setWinner(true);
		puzzle.add(p, 1, 0);
		
		puzzle.add(new Piece(1, 2), 0, 0);
		puzzle.add(new Piece(1, 2), 3, 0);
		
		puzzle.add(new Piece(1, 2), 0, 2);
		puzzle.add(new Piece(1, 2), 3, 2);
		
//		puzzle.add(new Piece(1, 1), 1, 2);
//		puzzle.add(new Piece(1, 1), 2, 2);
//		puzzle.add(new Piece(1, 1), 2, 3);
//		puzzle.add(new Piece(1, 1), 1, 3);
//		
//		puzzle.add(new Piece(2, 1), 1, 4);
		m.setPuzzle(puzzle);
		
		SlidingPuzzleApp app = new SlidingPuzzleApp(m);
		
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		app.setVisible(true);
	}
}
