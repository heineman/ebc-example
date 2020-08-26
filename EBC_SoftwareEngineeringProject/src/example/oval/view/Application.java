package example.oval.view;

import javax.swing.*;

import example.oval.model.*;

public class Application extends JFrame {
	Model model;
	OvalPanel panel;
	
	public Application(Model m) {
		super ("Oval Drawer");
		
		this.model = m;
		
		setSize(400, 400);
		panel = new OvalPanel(model);
		add(panel);
	}
	
	public OvalPanel getPanel() { return panel; }
	
}
