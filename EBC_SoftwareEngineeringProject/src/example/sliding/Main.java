package example.sliding;

import example.sliding.boundary.SlidingPuzzleApp;
import example.sliding.model.Model;

public class Main {
	
	public static void main(String[] args) {
		Model m = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(m);
		app.setVisible(true);
	}
}
