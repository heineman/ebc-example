package example.sliding.controller;

import java.awt.Point;

import org.junit.*;

import example.sliding.boundary.PuzzlePanel;
import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Coordinate;
import example.sliding.model.ModelTestCase;

public abstract class AppTestCase extends ModelTestCase {
	
	protected SlidingPuzzleApp app;
	
	@Before
	public void createApp() {
		app = new SlidingPuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2, c.row * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2);
	}

}
