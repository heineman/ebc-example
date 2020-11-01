package example.range;

import example.range.model.Model;
import example.range.view.App;

public class Main {
	public static void main(String args[]) {
		Model m = new Model();
		App app = new App(m);

		app.setVisible(true);
	}
}
